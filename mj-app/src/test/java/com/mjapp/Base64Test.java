package com.mjapp;

import com.mjapp.util.Base64Utils;
import com.sun.xml.internal.messaging.saaj.util.ByteOutputStream;

import java.io.File;
import java.io.FileInputStream;

/**
 * @title: Base64Test
 * @description:
 * @author: zhangfan
 * @data: 2016年11月05日 16:02
 */
public class Base64Test {


    public static void main(String[] args) throws Exception{

//        System.out.println(Base64Utils.encode("测试".getBytes()));
        System.out.println(getPicBase64Str());
    }

    public static String getPicBase64Str() throws Exception{

        FileInputStream fileInputStream = new FileInputStream(new File("/Users/zhangfan/Desktop/test.png"));

        ByteOutputStream byteOutputStream = new ByteOutputStream();
        int i = 0;
        byte[] bytes = new byte[512];
        while ((i = fileInputStream.read(bytes)) > 0) {
            byteOutputStream.write(bytes, 0, i);
        }

        String str = Base64Utils.encode(byteOutputStream.getBytes());
        return str;
    }
}
