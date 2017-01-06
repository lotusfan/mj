package com.mjapp.util;

import com.alibaba.fastjson.JSONObject;
import com.alipay.api.internal.util.AlipaySignature;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * @title: RSAUtilsTest
 * @description: ${DESCRIPTION}
 * @author: zhangfan
 * @data: 2016年11月20日 13:19
 */
public class RSAUtilsTest {

    @Test
    public void rsatest() throws Exception{

        String key = "MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQDDI6d306Q8fIfCOaTXyiUeJHkrIvYISRcc73s3vF1ZT7XN8RNPwJxo8pWaJMmvyTn9N4HQ632qJBVHf8sxHi/fEsraprwCtzvzQETrNRwVxLO5jVmRGi60j8Ue1efIlzPXV9je9mkjzOmdssymZkh2QhUrCmZYI/FCEa3/cNMW0QIDAQAB";
        String str = "{\"code\":\"10000\",\"msg\":\"Success\",\"total_amount\":\"9.00\",\"app_id\":\"2014072300007148\",\"trade_no\":\"2014112400001000340011111118\",\"seller_id\":\"2088111111116894\",\"out_trade_no\":\"70501111111S001111119\"}";

        String result = "NGfStJf3i3ooWBuCDIQSumOpaGBcQz+aoAqyGh3W6EqA/gmyPYwLJ2REFijY9XPTApI9YglZyMw+ZMhd3kb0mh4RAXMrb6mekX4Zu8Nf6geOwIa9kLOnw0IMCjxi4abDIfXhxrXyj********";


        JSONObject json = JSONObject.parseObject(str);
        System.out.println(AlipaySignature.rsaCheckV2(jsonToMap(json), key, "UTF-8"));


        System.out.println(Base64Utils.encode(RSAUtils.encryptByPublicKey(str.getBytes(), key)));
        System.out.println(result);


    }

    public static Map<String, String> jsonToMap(JSONObject json) {

        Set<String> set = json.keySet();

        Map<String, String> map = new HashMap<>();
        for (String key : set) {
            map.put(key, json.getString(key));
        }
        return map;
    }



}