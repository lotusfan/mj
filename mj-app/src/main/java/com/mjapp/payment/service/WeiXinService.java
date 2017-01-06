package com.mjapp.payment.service;

import com.alibaba.fastjson.JSONObject;
import com.mjapp.payment.model.ReceiveWeiXingAppDataReq;
import com.mjapp.payment.model.WeiXinCBModel;
import com.mjapp.payment.model.constant.CALLBACKRETURNCODE;
import com.mjapp.payment.util.WeiXinPayUtil;
import com.mjapp.util.JaxbUtil;
import com.mjapp.util.Md5Encrypt;
import com.mjapp.util.UUID;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import java.io.InputStream;
import java.net.URI;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 * @title: WeiXinService
 * @description: 微信相关业务处理
 * @author: zhangfan
 * @data: 2016年11月13日 17:50
 */
@Service
public class WeiXinService {

    private static final Logger logger = Logger.getLogger(WeiXinService.class);

    private final String KEY = "27D5A9EDDADD4D05B6C776B99BB49566";
    private final String APPID = "wxdfe7743986030fcc";
    private final String MCHID = "1287883601";


    /**
     * 主动请求微信后台 确认 是否支付成功
     *
     * @param transaction_id
     * @return
     */
    public CALLBACKRETURNCODE requestWeiXinPaySuccessOrNot(String transaction_id) {

        try {

            //生成请求数据
            ReceiveWeiXingAppDataReq receiveWeiXingAppDataReq = new ReceiveWeiXingAppDataReq();
            receiveWeiXingAppDataReq.setAppid(APPID);
            receiveWeiXingAppDataReq.setMch_id(MCHID);
            receiveWeiXingAppDataReq.setNonce_str(UUID.get());
//			receiveWeiXingAppDataReq.setTransaction_id(transaction_id);
            receiveWeiXingAppDataReq.setOut_trade_no(transaction_id);

            List<String> attrAppNameList = new ArrayList();
            JSONObject attrAppJson = JSONObject.parseObject(JSONObject.toJSONString(receiveWeiXingAppDataReq));

            Set<String> attrAppNameSet = attrAppJson.keySet();
            for (String name : attrAppNameSet) {
                attrAppNameList.add(name);
            }

            String appData = WeiXinPayUtil.signString(attrAppJson, attrAppNameList, KEY);
            String sa = Md5Encrypt.md5(appData, "UTF-8");
            receiveWeiXingAppDataReq.setSign(sa.toUpperCase());

            //发送请求
            CloseableHttpClient httpClient = HttpClients.createDefault();
            URI uri = new URIBuilder().setScheme("https") //https://api.mch.weixin.qq.com/pay/orderquery
                    .setHost("api.mch.weixin.qq.com")
                    .setPath("/pay/orderquery")
                    .build();

            HttpPost httpPost = new HttpPost(uri);
            CloseableHttpResponse response = null;


            StringEntity entity = new StringEntity(JaxbUtil.convertToXml(receiveWeiXingAppDataReq));
            httpPost.setEntity(entity);
            httpPost.setHeader("Content-Type", "text/xml");

            response = httpClient.execute(httpPost);

            HttpEntity httpEntity = response.getEntity();
            InputStream inputStream = httpEntity.getContent();

            //返回数据解析
            WeiXinCBModel weiXinCBData = JaxbUtil.converyToJavaBean(inputStream, WeiXinCBModel.class);

            return handleWeiXingCallBack(weiXinCBData);

        } catch (Exception e) {
            e.printStackTrace();
            return CALLBACKRETURNCODE.WEIXINFAIL;
        }

    }


    /**
     * 微信回调处理
     *
     * @param weiXinCBData
     * @return
     */
    public CALLBACKRETURNCODE handleWeiXingCallBack(WeiXinCBModel weiXinCBData) {

        CALLBACKRETURNCODE serviceEnum = null;
        try {

            //微信返回状态码失败
            if (!CALLBACKRETURNCODE.WEIXINSUCCESS.getCode().equals(weiXinCBData.getReturn_code())) {
                logger.info("微信返回状态码失败----" + weiXinCBData.toString());
                return CALLBACKRETURNCODE.WEIXINFAIL;
            }

            //微信返回业务支付结果
            if (!CALLBACKRETURNCODE.WEIXINSUCCESS.getCode().equals(weiXinCBData.getResult_code())) {

                logger.info("微信返回业务支付结果失败----" + weiXinCBData.toString());
                serviceEnum = CALLBACKRETURNCODE.WEIXINFAILRESULTCODE;
                return CALLBACKRETURNCODE.WEIXINSUCCESS;
            }

            //验证此返回是否处理过
//            boolean haveHandleFlag = validateTransactionId(weiXinCBData.getTransaction_id(), ORDER.WX);
//            if (!haveHandleFlag) {
//                logger.info("微信返回已处理过----" + weiXinCBData.toString());
//                return CALLBACKRETURNCODE.WEIXINSUCCESS;
//            }
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
            logger.info("微信返回异常----" + e.getMessage() + weiXinCBData.toString());
            return CALLBACKRETURNCODE.WEIXINFAIL;
        }
        try {


            //sign验证
            boolean signFlag = WeiXinPayUtil.validateSignWeiXin(weiXinCBData, KEY);
            if (!signFlag) {
                logger.info("微信返回验证sign不一至----" + weiXinCBData.toString());
                serviceEnum = CALLBACKRETURNCODE.WEIXINFAILSIGN;
                return CALLBACKRETURNCODE.WEIXINSUCCESS;
            }

//            验证订单
//            List<Orders> orderList = validateOrder(weiXinCBData.getOut_trade_no());
//            if (orderList == null || orderList.size() < 1) {
//
//                logger.info("微信返回业务订单库中无记录----" + weiXinCBData.toString());
//                serviceEnum = CALLBACKRETURNCODE.WEIXINFAILORDERCOUNT;
//                return CALLBACKRETURNCODE.WEIXINSUCCESS;
//            }
//
//            //验证金额
//            boolean feeFlag = validateFee(weiXinCBData.getTotal_fee(), orderList);
//
//            if (feeFlag == false) {
//
//                logger.info("微信返回业务订单金额与库中不符----" + weiXinCBData.toString());
//                serviceEnum = CALLBACKRETURNCODE.WEIXINFAILORDERFEE;
//                return CALLBACKRETURNCODE.WEIXINSUCCESS;
//            }
//
//            //更新订单状态为已支付
//            int upnum = updateOrder(orderList);
//
//            if (upnum != orderList.size()) {
//
//                logger.info("订单状态更新有误----" + weiXinCBData.toString());
//                return CALLBACKRETURNCODE.WEIXINFAIL;
//            }


            logger.info("订单支付成功更新----" + weiXinCBData.toString());
            serviceEnum = CALLBACKRETURNCODE.WEIXINSUCCESS;
            return CALLBACKRETURNCODE.WEIXINSUCCESS;
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
            serviceEnum = CALLBACKRETURNCODE.WEIXNGFAILEXCEPTION;
            return CALLBACKRETURNCODE.WEIXINFAIL;
        } finally {
            //记录入库
//            weiXinCBData.setMsg(serviceEnum.getMsg());
//            weiXinCBDataMapper.save(weiXinCBData);
        }
    }


}
