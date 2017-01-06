package com.mjapp.util;

/**
 * @title: PicOlineUrl
 * @description: 图片文件生成可访问的地址
 * @author: zhangfan
 * @data: 2016年10月22日 19:05
 */
public class PicOlineUrl {


    public static String transform(String fileName) {

        return PROPERTIESUTIL.get("pic_domain") + fileName + "." + PROPERTIESUTIL.get("pic_suffix");
    }
}
