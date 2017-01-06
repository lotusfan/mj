package com.mjapp.payment.service;

import com.alibaba.fastjson.JSONObject;
import com.alipay.api.AlipayApiException;
import com.alipay.api.internal.util.AlipaySignature;
import com.mjapp.model.OrderSubTb;
import com.mjapp.model.OrderTb;
import com.mjapp.payment.model.ApplyForPayOrderParameterZFBModel;
import com.mjapp.payment.model.ZhiFuBaoCBModel;
import com.mjapp.payment.model.constant.CALLBACKRETURNCODE;
import com.mjapp.util.BigDecimalUtil;
import com.mjapp.util.ModelTransformUtil;
import com.mjapp.util.PROPERTIESUTIL;
import com.mjapp.util.TimeUtil;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Map;

/**
 * @title: ZhiFuBaoService
 * @description: 支付宝相关业务处理
 * @author: zhangfan
 * @data: 2016年11月13日 17:49
 */
@Service
public class ZhiFuBaoService {

    private static final Logger logger = Logger.getLogger(ZhiFuBaoService.class);


    /**
     * 生成 支付宝 调用支付服务验签字符串
     *
     * @param orderTb
     * @param subjectName
     * @return
     */
    public String payOrderStr(OrderTb orderTb, String subjectName) {


        ApplyForPayOrderParameterZFBModel am = new ApplyForPayOrderParameterZFBModel();
        ApplyForPayOrderParameterZFBModel.ApplyForPayOrderNotMustParameterZFBModel anm = am.new ApplyForPayOrderNotMustParameterZFBModel();

        anm.setSubject(subjectName);
        anm.setOut_trade_no(orderTb.getSn());
        anm.setTotal_amount(BigDecimalUtil.formatPoint2(orderTb.getPayPrice()));


        am.setTimestamp(TimeUtil.getTimeFormat1());
        am.setBiz_content(JSONObject.toJSONString(anm));
        try {
            am.setSign(AlipaySignature.rsaSign(ModelTransformUtil.toMap(am), PROPERTIESUTIL.get("private_key_zfb"), PROPERTIESUTIL.get("charset_zfb")));
        } catch (AlipayApiException e) {
            e.printStackTrace();
            return null;
        }




        return ModelTransformUtil.toUrlParameterStr(am);
    }


    public void handleZhiFuBaoCallBack(Map map) {

//        map.remove("sign_type");   待真实 测试
        try {
            System.out.println(AlipaySignature.rsaCheckV2(map, PROPERTIESUTIL.get("public_key_zfb"), PROPERTIESUTIL.get("charset_zfb")));
        } catch (AlipayApiException e) {
            e.printStackTrace();
        }
    }



    /**
     * 支付宝回调处理
     *
     * @param zhiFuBaoCBData
     * @return
     */
    public CALLBACKRETURNCODE handleZhiFuBaoCallBack(ZhiFuBaoCBModel zhiFuBaoCBData) {
        try {

            //验证此返回是否处理过
//            boolean haveHandleFlag = validateTransactionId(zhiFuBaoCBData.getNotify_id(), ORDER.ZFB);
//            if (!haveHandleFlag) {
//                logger.info("支付宝返回已处理过----" + zhiFuBaoCBData.toString());
//                return CALLBACKRETURNCODE.ZHIFUBAOSUCCESS;
//            }

            //验证是否是支付宝返回来的真实请求
            boolean truth = validateZhiFuBaoTruth(zhiFuBaoCBData);
            if (!truth) {
                logger.info("不是支付宝返回的真实请求----" + zhiFuBaoCBData.toString());
                return CALLBACKRETURNCODE.ZHIFUBAOFAIL;
            }


        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
            return CALLBACKRETURNCODE.ZHIFUBAOFAIL;
        }
        String serviceDes = null;
        try {

            //支付宝返回状态  只有 SUCCESS  和   FINSHED  更新订单
            if (!(CALLBACKRETURNCODE.ZHIFUBAOTRADESUCCESS.getCode().equals(zhiFuBaoCBData.getTrade_status())
                    || CALLBACKRETURNCODE.ZHIFUBAOTRADEFINISHED.getCode().equals(zhiFuBaoCBData.getTrade_status()))) {
                serviceDes = "返回数据不做处理" + zhiFuBaoCBData.getTrade_status();
                logger.info("返回数据不做处理----" + zhiFuBaoCBData.toString());
                return CALLBACKRETURNCODE.ZHIFUBAOSUCCESS;
            }

            //sign验证


//            //验证订单
//            List<Orders> orderList = validateOrder(zhiFuBaoCBData.getOut_trade_no());
//            if (orderList == null || orderList.size() < 1) {
//
//                logger.info("支付宝返回业务订单库中无记录----" + zhiFuBaoCBData.toString());
//                return CALLBACKRETURNCODE.ZHIFUBAOSUCCESS;
//            }
//
//            //验证金额
//            BigDecimal zfbFee = zhiFuBaoCBData.getTotal_fee();
//            zfbFee = zfbFee.multiply(new BigDecimal(100));
//            boolean feeFlag = validateFee(zfbFee.intValue(), orderList);
//
//            if (feeFlag == false) {
//
//                logger.info("支付返回业务订单金额与库中不符----" + zhiFuBaoCBData.toString());
//                serviceDes = "支付返回业务订单金额与库中不符";
//                return CALLBACKRETURNCODE.ZHIFUBAOSUCCESS;
//            }
//
//            //更新订单状态为已支付
//            int upnum = updateOrder(orderList);
//
//            if (upnum != orderList.size()) {
//
//                logger.info("订单状态更新有误----" + zhiFuBaoCBData.toString());
//                serviceDes = "订单状态更新有误";
//                return CALLBACKRETURNCODE.ZHIFUBAOFAIL;
//            }

//			updateBuyPeopleCount(upnum, orderList.get(0).getActiid());
            logger.info("订单支付成功更新----" + zhiFuBaoCBData.toString());
            serviceDes = "订单支付成功更新";
            return CALLBACKRETURNCODE.ZHIFUBAOSUCCESS;
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
            serviceDes = "业务出现异常";
            logger.error("业务出现异常" + e.getMessage());
            return CALLBACKRETURNCODE.ZHIFUBAOFAIL;
        } finally {
            //记录入库
//            zhiFuBaoCBData.setMsg(serviceDes);
//            zhiFuBaoCBDataMapper.save(zhiFuBaoCBData);
        }

    }


    /**
     * 支付宝返回数据真实性验证
     *
     * @param zhiFuBaoCBData
     * @return
     */
    //1、商户需要验证该通知数据中的out_trade_no是否为商户系统中创建的订单号；
    //2、判断total_amount是否确实为该订单的实际金额（即商户订单创建时的金额）；
    //3、校验通知中的seller_id（或者seller_email) 是否为out_trade_no这笔单据对应的操作方（有的时候，一个商户可能有多个seller_id/seller_email）；
    //4、验证app_id是否为该商户本身。上述1、2、3、4有任何一个验证不通过，则表明同步校验结果是无效的，只有全部验证通过后，才可以认定买家付款成功。
    public boolean validateZhiFuBaoTruth(ZhiFuBaoCBModel zhiFuBaoCBData) {
        try {
            CloseableHttpClient httpClient = HttpClients.createDefault();
            URI uri = new URIBuilder().setScheme("https")
                    .setHost("mapi.alipay.com")
                    .setPath("/gateway.do")
                    .setParameter("service", "notify_verify")
                    .setParameter("notify_id", zhiFuBaoCBData.getNotify_id())
                    .setParameter("partner", zhiFuBaoCBData.getSeller_id())
                    .build();

            HttpPost httpPost = new HttpPost(uri);
            CloseableHttpResponse response = null;

            response = httpClient.execute(httpPost);

            HttpEntity httpEntity = response.getEntity();
            InputStream inputStream = httpEntity.getContent();

            InputStreamReader inputStreamReader = new InputStreamReader(inputStream);

            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
            String str = "";
            StringBuffer stringBuffer = new StringBuffer();
            while ((str = bufferedReader.readLine()) != null) {
                stringBuffer.append(str);
            }

            return Boolean.parseBoolean(stringBuffer.toString());
        } catch (URISyntaxException e) {
            e.printStackTrace();
            return false;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        } catch (UnsupportedOperationException e) {
            e.printStackTrace();
            return false;
        }
    }
}
