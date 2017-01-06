package com;

import com.mjapp.util.PROPERTIESUTIL;
import org.junit.Test;

import java.io.UnsupportedEncodingException;

/**
 * @title: PropertiestTest
 * @description: djfkdf
 * @author: zhangfan
 * @data: 2016年10月21日 21:12
 */
public class PropertiestTest {


    @Test
    public void test() throws UnsupportedEncodingException {
        String str = PROPERTIESUTIL.get("sms_register");
        System.out.println(str);
        System.out.println(PROPERTIESUTIL.get("format_zfb"));
    }
}
