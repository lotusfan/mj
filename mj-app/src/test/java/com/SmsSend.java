package com;

import com.mjapp.model.thirdparty.SmsModel;
import com.mjapp.util.SmsUtil;
import org.junit.Test;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @title: SmsSend
 * @description: 短信发送测试
 * @author: zhangfan
 * @data: 2016年10月20日 14:02
 */
public class SmsSend {


    @Test
    public void send() {

        SmsModel smsModel = new SmsModel();

        smsModel.setMobile("18210202686");
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:dd");
        smsModel.setMsg_content("MJ测试" + simpleDateFormat.format(new Date()));
        SmsUtil.send(smsModel);
    }

    @Test
    public void httpCode() {
        SmsModel model = new SmsModel();
        System.out.println(model);
    }

}
