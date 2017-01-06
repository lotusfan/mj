package com.mjapp.util;

import java.math.BigDecimal;
import java.text.DecimalFormat;

/**
 * @title: BigDecimalUtil
 * @description: BigDecimal 工具类
 * @author: zhangfan
 * @data: 2016年12月04日 12:06
 */
public class BigDecimalUtil {


    /**
     * 保留两位小数   例:10.00    9.01    8.10
     *
     * @param bigDecimal
     * @return
     */
    public static String formatPoint2(BigDecimal bigDecimal) {

        return new DecimalFormat("#.00").format(bigDecimal);
    }
}
