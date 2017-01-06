package com.mjapp.util;

import com.mjapp.payment.model.constant.ENCODECONST;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.params.CoreConnectionPNames;

import javax.servlet.http.HttpServletRequest;
import java.io.*;
import java.net.URL;
import java.net.URLConnection;

/**
 * @title: HttpUtil
 * @description:
 * @author: zhangfan
 * @data: 2016年11月13日 18:12
 */
public class HttpUtil {


    public static String doPost(String url, String data) throws ClientProtocolException, IOException {

        //POST的URL
        HttpClient httpclient = new DefaultHttpClient();
        HttpPost httppost = new HttpPost(url);
        //建立HttpPost对象

        httpclient.getParams().setIntParameter(CoreConnectionPNames.CONNECTION_TIMEOUT, 5000);
        httpclient.getParams().setIntParameter(CoreConnectionPNames.SO_TIMEOUT, 5000);
        //建立一个NameValuePair数组，用于存储欲传送的参数
        StringEntity myEntity = new StringEntity(data, ENCODECONST.currentencode);
        //添加参数
        httppost.setEntity(myEntity);
        HttpResponse response = httpclient.execute(httppost);
        HttpEntity resEntity = response.getEntity();

        InputStreamReader reader = new InputStreamReader(resEntity.getContent(), ENCODECONST.currentencode);
        char[] buff = new char[1024];
        int length = 0;
        StringBuffer sb = new StringBuffer();
        while ((length = reader.read(buff)) != -1) {
            sb.append(new String(buff, 0, length));
        }
        httpclient.getConnectionManager().shutdown();
        String res = sb.toString();
        //System.out.print(res);
        return res;
    }

    public static String sendPost(String url, String param) {
        PrintWriter out = null;
        BufferedReader in = null;
        String result = "";
        try {
            URL realUrl = new URL(url);
            // 打开和URL之间的连接
            URLConnection conn = realUrl.openConnection();
            // 设置通用的请求属性
            conn.setRequestProperty("accept", "*/*");
            conn.setRequestProperty("connection", "Keep-Alive");
            conn.setRequestProperty("user-agent",
                    "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1;SV1)");
            // 发送POST请求必须设置如下两行
            conn.setDoOutput(true);
            conn.setDoInput(true);
            // 获取URLConnection对象对应的输出流
            out = new PrintWriter(conn.getOutputStream());
            // 发送请求参数
            out.print(param);
            // flush输出流的缓冲
            out.flush();
            // 定义BufferedReader输入流来读取URL的响应
            in = new BufferedReader(
                    new InputStreamReader(conn.getInputStream()));
            String line;
            while ((line = in.readLine()) != null) {
                result += line;
            }
            //System.out.print(result);
        } catch (Exception e) {
            //System.out.println("发送 POST 请求出现异常！"+e);
            e.printStackTrace();
        }
        //使用finally块来关闭输出流、输入流
        finally {
            try {
                if (out != null) {
                    out.close();
                }
                if (in != null) {
                    in.close();
                }
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
        return result;
    }


    public static String getJsonStringFromBytes(byte[] bytes, int jsonlength)
            throws Exception {
        if (bytes == null || 0 == bytes.length) {
            return "";
        }

        jsonlength = jsonlength <= 0 ? bytes.length : jsonlength;

        int len = bytes.length;

        String str = new String(bytes, "utf-8");
        //str = URLDecoder.decode(str, EncodeConst.currentencode);
        if (bytes.length >= jsonlength) {
            byte[] bjsons = new byte[jsonlength];
            System.arraycopy(bytes, 0, bjsons, 0, jsonlength);
            return new String(bjsons, ENCODECONST.currentencode);
        } else {
            throw new Exception("数据长度不正确");
        }
    }

    public static byte[] getFileFromBytes(byte[] bytes, int jsonlength)
            throws Exception {
        if (bytes == null || jsonlength <= 0) {
            return null;
        }

        int len = bytes.length;

        if (bytes.length >= jsonlength) {
            byte[] bfiles = new byte[bytes.length - jsonlength];
            System.arraycopy(bytes, jsonlength, bfiles, 0, bytes.length
                    - jsonlength);
            return bfiles;
        } else {
            throw new Exception("数据长度不正确");
        }
    }

    public static byte[] convertRequestStream2Bytes(HttpServletRequest request)
            throws IOException {
        //try {
        InputStream input = request.getInputStream();
        int size = 0;
        byte[] bytes = new byte[request.getContentLength()];
        byte[] buffer = new byte[1024];
        int j = 0;
        while ((size = input.read(buffer, 0, 1024)) != -1) {
            System.arraycopy(buffer, 0, bytes, j, size);
            j += size;
        }
        input.close();
        return bytes;
    }
}
