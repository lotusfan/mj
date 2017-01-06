package com.mjapp.payment.service;

import com.BaseTest;
import com.alibaba.fastjson.JSONObject;
import com.alipay.api.AlipayApiException;
import com.alipay.api.internal.util.AlipaySignature;
import com.mjapp.dao.OrderTbMapper;
import com.mjapp.model.OrderTb;
import com.mjapp.payment.model.ApplyForPayOrderParameterZFBModel;
import com.mjapp.util.BigDecimalUtil;
import com.mjapp.util.ModelTransformUtil;
import com.mjapp.util.PROPERTIESUTIL;
import com.mjapp.util.TimeUtil;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashMap;
import java.util.Map;

/**
 * @title: ZhiFuBaoServiceTest
 * @description: ${DESCRIPTION}
 * @author: zhangfan
 * @data: 2016年12月04日 16:44
 */
public class ZhiFuBaoServiceTest extends BaseTest {

    @Autowired
    private ZhiFuBaoService zhiFuBaoService;
    @Autowired
    private OrderTbMapper orderTbMapper;

    @Test
    public void testPayOrderStr() throws Exception {

        OrderTb orderTb = new OrderTb();
        orderTb.setId(1);
        orderTb = orderTbMapper.getUniqueBy(orderTb);

        ApplyForPayOrderParameterZFBModel am = new ApplyForPayOrderParameterZFBModel();
        ApplyForPayOrderParameterZFBModel.ApplyForPayOrderNotMustParameterZFBModel anm = am.new ApplyForPayOrderNotMustParameterZFBModel();

        anm.setSubject("测试");
        anm.setOut_trade_no(orderTb.getSn());
        anm.setTotal_amount(BigDecimalUtil.formatPoint2(orderTb.getPayPrice()));


        am.setTimestamp(TimeUtil.getTimeFormat1());
        am.setBiz_content(JSONObject.toJSONString(anm));
        try {
            System.out.println("---");
            Map map1 = ModelTransformUtil.toMap(am);
            System.out.println(AlipaySignature.getSignContent(map1));

            am.setSign(AlipaySignature.rsaSign(map1, PROPERTIESUTIL.get("private_key_zfb"), PROPERTIESUTIL.get("charset_zfb")));
            Map map = ModelTransformUtil.toMap(am);
            System.out.println(AlipaySignature.getSignContent(map));

            System.out.println(AlipaySignature.rsaCheckV2(map, PROPERTIESUTIL.get("public_key_zfb"), PROPERTIESUTIL.get("charset_zfb")));


        } catch (AlipayApiException e) {
            e.printStackTrace();
        }



        System.out.println(zhiFuBaoService.payOrderStr(orderTb, "支付宝订单测试"));
    }

    @Test
    public void testSignBoolen() throws Exception{


        Map<String, String> map = new HashMap<>();
        map.put("name", "zhangfan");

        map.put("sign", AlipaySignature.rsaSign(map, PROPERTIESUTIL.get("private_key_zfb"), PROPERTIESUTIL.get("charset_zfb")));
        System.out.println("------------" + JSONObject.toJSONString(map));

        System.out.println(AlipaySignature.rsaCheckV2(map, PROPERTIESUTIL.get("public_key_zfb"), PROPERTIESUTIL.get("charset_zfb")));

    }
}