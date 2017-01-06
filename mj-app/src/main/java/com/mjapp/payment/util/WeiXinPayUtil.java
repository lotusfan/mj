package com.mjapp.payment.util;

import com.alibaba.fastjson.JSONObject;
import com.mjapp.payment.model.WeiXinCBModel;
import com.mjapp.util.HttpUtil;
import com.mjapp.util.Md5Encrypt;
import org.apache.log4j.Logger;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.net.URI;
import java.util.Set;

import org.apache.http.client.utils.URIBuilder;
import org.w3c.dom.*;

/**
 * @title: WeiXinPayUtil
 * @description:
 * @author: zhangfan
 * @data: 2016年11月13日 18:09
 */
public class WeiXinPayUtil {
    private static final Logger logger = Logger.getLogger(WeiXinPayUtil.class);


    /**
     * 微信返回数据签名认证
     *
     * @param weiXinCBData
     * @return
     */
    public static boolean validateSignWeiXin(WeiXinCBModel weiXinCBData, String KEY) {

        try {
            String sign = new String(weiXinCBData.getSign());
            weiXinCBData.setSign(null);
            List<String> attrAppNameList = new ArrayList<String>();
            JSONObject attrAppJson = JSONObject.parseObject(JSONObject.toJSONString(weiXinCBData));

            Set<String> attrAppNameSet = attrAppJson.keySet();
            for (String name : attrAppNameSet) {
                attrAppNameList.add(name);
            }

            String appData = WeiXinPayUtil.signString(attrAppJson, attrAppNameList, KEY);
            String sa = Md5Encrypt.md5(appData, "UTF-8");

            weiXinCBData.setSign(sign);
            return sign.equals(sa.toUpperCase());
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
            return false;
        }

    }


    /**
     * 微信支付签名生成
     *
     * @param json
     * @param list
     * @param key
     * @return
     */
    public static String signString(JSONObject json, List<String> list, String key) {

        Collections.sort(list);

        StringBuffer stringBuffer = new StringBuffer();

        for (String str : list) {
            if ("sign".equals(str)) {
                continue;
            }
            if (json.getString(str) == null || json.getString(str).length() < 1) continue;
            stringBuffer.append(str);
            stringBuffer.append("=");
            stringBuffer.append(json.get(str));
            stringBuffer.append("&");
        }
        stringBuffer.append("key=");
        stringBuffer.append(key);


        return stringBuffer.toString();

    }

    /**
     * 微信支付封装请求数据
     *
     * @param json
     * @return
     */
    public static String sendXMLData(JSONObject json) {

        StringBuffer sb = new StringBuffer();

        Set<String> set = json.keySet();

        sb.append("<xml>");
        for (String str : set) {
            sb.append("<" + str + ">");
            sb.append(json.get(str));
            sb.append("</" + str + ">");
        }
        sb.append("</xml>");

        return sb.toString();
    }

    /**
     * 微信请求prepayid
     *
     * @param data
     * @return
     * @throws Exception
     */
    public static String sendRequest(String data) throws Exception {

        URI uri = new URIBuilder().setScheme("https")
                .setHost("api.mch.weixin.qq.com")
                .setPath("/pay/unifiedorder")
                .build();
        return HttpUtil.doPost(uri.toString(), data);

    }

    public static String getCharacterDataFromElement(Element e) {
        Node child = e.getFirstChild();
        if (child instanceof CharacterData) {
            CharacterData cd = (CharacterData) child;
            return cd.getData();
        }
        return "?";
    }

}
