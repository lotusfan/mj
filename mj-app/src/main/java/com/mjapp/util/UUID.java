package com.mjapp.util;

/**
 * @title: UUID
 * @description: 生成32位UUID
 * @author: zhangfan
 * @data: 2016年10月03日 14:37
 */
public class UUID {


    public static String get() {
        //return new StringBuilder(32).append(format(getIP())).append(format(getJVM())).append(format(getHiTime())).append(format(getLoTime())).append(format(getCount())).toString();
        return java.util.UUID.randomUUID().toString().replaceAll("-", "").toLowerCase();
    }
}
