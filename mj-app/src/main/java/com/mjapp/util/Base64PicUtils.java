package com.mjapp.util;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * @title: Base64PicUtils
 * @description: base64 字符串存储图片
 * @author: zhangfan
 * @data: 2016年10月22日 17:13
 */
public class Base64PicUtils {


    public static void savePicFile(String base64Str, String fileName, String filePath) {


        FileOutputStream fileOutputStream = null;
        try {

            File file = new File(filePath + fileName + "." + PROPERTIESUTIL.get("pic_suffix"));
            fileOutputStream = new FileOutputStream(file);

            fileOutputStream.write(Base64Utils.decode(base64Str));
            fileOutputStream.flush();

        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            if (fileOutputStream != null) {
                try {
                    fileOutputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

}
