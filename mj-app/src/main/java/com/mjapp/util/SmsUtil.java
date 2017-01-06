package com.mjapp.util;


import com.mjapp.model.thirdparty.SmsModel;
import org.apache.commons.lang3.StringUtils;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.nio.charset.Charset;

/**
 * @title: SmsUtil
 * @description: 第三方发送短信
 * @author: zhangfan
 * @data: 2016年10月20日 13:30
 */
public class SmsUtil {

    /*
    *
    账户ID：sc3636
    账户密码：523v2v
    业务代码：1069003256636
    *
    * */

    private static final String url = "http://sms.cloud.hbsmservice.com:8080/sms_send2.do";

    public static void send(SmsModel smsModel) {

        HttpClient httpClient = HttpClients.createDefault();

        HttpPost httpPost = new HttpPost(url);

        httpPost.addHeader("Content-Type", "application/x-www-form-urlencoded;charset=gbk");

        httpPost.setEntity(new StringEntity(smsModelToHttpCode(smsModel), "GB2312"));
        HttpResponse response = null;


        try {
            response = httpClient.execute(httpPost);
            HttpEntity httpEntity = response.getEntity();
            System.out.println(EntityUtils.toString(httpEntity, Charset.defaultCharset()));

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public static String smsModelToHttpCode(SmsModel smsModel) {

        StringBuffer sb = new StringBuffer();

        if (!StringUtils.isEmpty(smsModel.getCorp_id())) {
            sb.append("corp_id");
            sb.append("=");
            sb.append(smsModel.getCorp_id());
            sb.append("&");
        }
        if (!StringUtils.isEmpty(smsModel.getCorp_msg_id())) {
            sb.append("corp_msg_id");
            sb.append("=");
            sb.append(smsModel.getCorp_msg_id());
            sb.append("&");
        }
        if (!StringUtils.isEmpty(smsModel.getCorp_pwd())) {
            sb.append("corp_pwd");
            sb.append("=");
            sb.append(smsModel.getCorp_pwd());
            sb.append("&");
        }
        if (!StringUtils.isEmpty(smsModel.getCorp_service())) {
            sb.append("corp_service");
            sb.append("=");
            sb.append(smsModel.getCorp_service());
            sb.append("&");
        }
        if (!StringUtils.isEmpty(smsModel.getExt())) {
            sb.append("ext");
            sb.append("=");
            sb.append(smsModel.getExt());
            sb.append("&");
        }
        if (!StringUtils.isEmpty(smsModel.getMobile())) {
            sb.append("mobile");
            sb.append("=");
            sb.append(smsModel.getMobile());
            sb.append("&");
        }
        if (!StringUtils.isEmpty(smsModel.getMsg_content())) {
            sb.append("msg_content");
            sb.append("=");
            sb.append(smsModel.getMsg_content());
            sb.append("&");
        }

        return sb.substring(0, sb.length() - 1);
    }


}