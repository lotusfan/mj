package com.mjapp.util;

import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Properties;

/**
 * @title: PROPERTIESUTIL
 * @description: 获取配置文件信息
 * @author: zhangfan
 * @data: 2016年10月08日 20:39
 */
public class PROPERTIESUTIL {

    static Properties properties = new Properties();
    static {
        try {
            properties.load(new InputStreamReader(PROPERTIESUTIL.class.getResourceAsStream("/config.properties"), "UTF-8"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String get(String key) {

        return properties.getProperty(key);
    }
}
