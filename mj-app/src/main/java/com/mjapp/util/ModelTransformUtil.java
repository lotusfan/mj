package com.mjapp.util;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.mjapp.payment.model.constant.ENCODECONST;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * @title: ModelToMap
 * @description: java model 转为map
 * @author: zhangfan
 * @data: 2016年12月04日 12:14
 */
public class ModelTransformUtil {


    public static Map<String, String> toMap(Object o) {


        JSONObject jsonObject = toJsonObject(o);
        Set<String> set = jsonObject.keySet();
        Map<String, String> map = new HashMap<>();
        for (String key : set) {

            map.put(key, jsonObject.getString(key));
        }

        return map;
    }

    public static String toUrlParameterStr(Object o) {
        JSONObject jsonObject = toJsonObject(o);

        StringBuffer sb = new StringBuffer();
        Set<String> set = jsonObject.keySet();
        for (String key : set) {
            sb.append(key);
            sb.append("=");
            sb.append(jsonObject.getString(key));
//            try {
//                sb.append(URLEncoder.encode(jsonObject.getString(key), ENCODECONST.currentencode));
//            } catch (UnsupportedEncodingException e) {
//                e.printStackTrace();
//            }
            sb.append("&");
        }
        return sb.substring(0, sb.length() - 1).toString();
    }


    public static JSONObject toJsonObject(Object o) {
        if (o == null) throw new NullPointerException("model transform map :  model is null Exception");
        JSONObject jsonObject = JSON.parseObject(JSONObject.toJSONString(o));
        return jsonObject;
    }
}
