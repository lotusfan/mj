package com.mjapp.util;

import java.util.Random;

/**
 * @title: Random6Digit
 * @description: 生成6位数字随机数
 * @author: zhangfan
 * @data: 2016年10月03日 16:01
 */
public class Random6Digit {

    public static int get(){
        Random generator = new Random();
        generator.setSeed(System.currentTimeMillis());

        int num = generator.nextInt(899999) + 100000;
        if (num < 100000 || num > 999999) {
            num = generator.nextInt(99999) + 99999;
            if (num < 100000 || num > 999999) {
                try {
                    throw new Exception("Unable to generate PIN at this time..");
                } catch (Exception e) {
                    get();
                }
            }
        }
        return num;
    }
}
