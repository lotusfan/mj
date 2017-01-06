package com.mjapp.util;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.HashMap;
import java.util.Random;

/**
 * @title: QrcodeUtil
 * @description: 二维码  工具类
 * @author: zhangfan
 * @data: 2016年11月20日 17:14
 */
public class QrcodeUtil {

    public static void createQrcode(String qrcodeFilePath, String fileName, String content) {
        try {
            int qrcodeWidth = 300;
            int qrcodeHeight = 300;
            String qrcodeFormat = "png";
            HashMap<EncodeHintType, String> hints = new HashMap<>();
            hints.put(EncodeHintType.CHARACTER_SET, "UTF-8");
            BitMatrix bitMatrix = new MultiFormatWriter().encode(content, BarcodeFormat.QR_CODE, qrcodeWidth, qrcodeHeight, hints);

            BufferedImage image = new BufferedImage(qrcodeWidth, qrcodeHeight, BufferedImage.TYPE_INT_RGB);
            File QrcodeFile = new File(qrcodeFilePath + fileName + "." + qrcodeFormat);
            ImageIO.write(image, qrcodeFormat, QrcodeFile);
            MatrixToImageWriter.writeToFile(bitMatrix, qrcodeFormat, QrcodeFile);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
