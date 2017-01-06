package com.mjapp.util;

/**
 * @title: OrderSnGenerateUtil
 * @description: 订单sn生成
 * @author: zhangfan
 * @data: 2016年12月04日 15:31
 */
public class OrderSnUtil {

    public static String get() {
        String dateStr = TimeUtil.getTimeFormat2();
        return dateStr + Random6Digit.get();
    }


}
