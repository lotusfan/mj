package com.mjapp.util;

/**
 * @title: MjCodeValidate
 * @description: Mj  code  验证
 * @author: zhangfan
 * @data: 2016年10月29日 14:00
 */
public class MjCodeUitl {


    /**
     * 验证Mj code 是否合法
     *
     * @param str
     * @return
     */
    public static boolean validate(String str) {

        if(str == null || str.length() != 6) return false;

        try {
            Integer.parseInt(str);
        } catch (NumberFormatException e) {
            return false;
        }
        return true;
    }

}
