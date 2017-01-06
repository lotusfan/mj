package com.mjapp.cache;

import com.mjapp.util.RedisCache;

/**
 * @title: SmsCache
 * @description: 短信发送cache
 * @author: zhangfan
 * @data: 2016年10月04日 14:35
 */
public class SmsCache {

    static final String typeReg = "sms-reg-"; //手机注册使用短信
    static final String typeNum = "sms-num-"; //手机全部发送短信数量
    static final String typeBac = "sms-bac-"; //手机找回密码使用短信

    public static void putReg(String phone, String code) {
        RedisCache.put(typeReg + phone, code);
    }

    public static String getReg(String phone) {
        return RedisCache.get(typeReg + phone);
    }

    public static void putBac(String phone, String code) {
        RedisCache.put(typeReg + phone, code);
    }

    public static String getBac(String phone) {
        return RedisCache.get(typeReg + phone);
    }



    public static void putNum(String phone) {

        RedisCache.put(typeNum + phone, String.valueOf(getNum(phone) + 1));

    }


    public static int getNum(String phone) {

        String numStr = RedisCache.get(typeNum + phone);
        if(numStr == null || numStr.length() < 1) return 0;

        return Integer.valueOf(numStr).intValue();
    }


}
