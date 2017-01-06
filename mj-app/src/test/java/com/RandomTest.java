package com;

import com.mjapp.util.Random6Digit;

/**
 * @title: RandomTest
 * @description: 随机数测试
 * @author: zhangfan
 * @data: 2016年10月22日 18:20
 */
public class RandomTest {


    public static void main(String[] args) {

        for (int i = 0; i < 1000; i++) {
            System.out.println(Random6Digit.get());
        }
    }
}
