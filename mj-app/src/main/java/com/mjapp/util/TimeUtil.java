package com.mjapp.util;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @title: TimeUtil
 * @description: 当前系统时间多种格式返回
 * @author: zhangfan
 * @data: 2016年12月03日 12:58
 */
public class TimeUtil {

    public static SimpleDateFormat format1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    public static SimpleDateFormat format2 = new SimpleDateFormat("yyyyMMddHHmmss");


    /**
     * format1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
     *
     * @return
     */
    public static String getTimeFormat1() {
        return format1.format(new Date());
    }

    /**
     * format2 = new SimpleDateFormat("yyyymmddHHmmss");
     *
     * @return
     */
    public static String getTimeFormat2() {
        return format2.format(new Date());
    }



}
