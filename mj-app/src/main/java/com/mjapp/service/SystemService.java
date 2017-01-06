package com.mjapp.service;

import com.mjapp.dao.HomePicTbMapper;
import com.mjapp.dao.UserFeedbackTbMapper;
import com.mjapp.dao.UserTbMapper;
import com.mjapp.model.HomePicTb;
import com.mjapp.model.UserFeedbackTb;
import com.mjapp.model.UserTb;
import com.mjapp.model.constant.SERVICECODE;
import com.mjapp.model.constant.UNIFYTYPE;
import com.mjapp.model.thirdparty.SmsModel;
import com.mjapp.util.PROPERTIESUTIL;
import com.mjapp.util.Random6Digit;
import com.mjapp.util.SmsUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.UnsupportedEncodingException;

/**
 * @title: SystemService
 * @description: APP系统相关操作Service
 * @author: zhangfan
 * @data: 2016年10月03日 14:28
 */
@Service
public class SystemService {

    @Autowired
    private UserTbMapper userTbMapper;
    @Autowired
    private UserFeedbackTbMapper userFeedbackTbMapper;
    @Autowired
    private HomePicTbMapper homePicTbMapper;

    /**
     * 用户登录
     *
     * @param userTb
     * @return
     */
    public UserTb loginS(UserTb userTb) {

        try {
            UserTb userTbNew = userTbMapper.getUniqueBy(userTb);

            if (userTbNew == null) return null;

            return userTbNew;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * 找回密码 更新用户密码
     *
     * @param userTb
     * @return
     */
    public SERVICECODE backPassWordS(UserTb userTb) {

        userTbMapper.updateByLoginName(userTb);
        return SERVICECODE.UPDATESUCCESS;
    }


    /**
     * 用户注册
     *
     * @param userTb
     * @return
     */
    public SERVICECODE registerS(UserTb userTb) {

        UserTb userTbC = new UserTb();
        userTbC.setLoginName(userTb.getLoginName());

        int count = userTbMapper.count(userTbC);
        if (count > 0) {
            return SERVICECODE.USEREXIST;
        }

        userTbMapper.save(userTb);
        return SERVICECODE.INSERTSUCCESS;
    }

    /**
     * 注册发送短信
     *
     * @param userTb
     * @return
     */
    public int sendSMSReg(UserTb userTb) {

        return sendSMS(userTb.getLoginName(), PROPERTIESUTIL.get("sms_register"));
    }

    /**
     * 忘记密码发送短信
     *
     * @param userTb
     * @return
     */
    public int sendSMSBpd(UserTb userTb) throws UnsupportedEncodingException {

        return sendSMS(userTb.getLoginName(), PROPERTIESUTIL.get("sms_backpd"));
    }


    /**
     * 短信发送
     *
     * @return
     */
    public int sendSMS(String phone, String content) {

        int codeSMS = Random6Digit.get();

        content = content.replaceAll("XXX", String.valueOf(codeSMS));

        SmsModel smsModel = new SmsModel();
        smsModel.setMobile(phone);
        smsModel.setMsg_content(content);
        SmsUtil.send(smsModel);

        return codeSMS;
    }


    /**
     * 用户反馈
     *
     * @param userFeedbackTb
     * @return
     */
    public SERVICECODE feedbackS(UserFeedbackTb userFeedbackTb) {

        try {
            userFeedbackTbMapper.save(userFeedbackTb);
            return SERVICECODE.INSERTSUCCESS;
        } catch (Exception e) {
            e.printStackTrace();
            return SERVICECODE.INSERTERROR;
        }
    }


    /**
     * 获取首页加载图
     *
     * @return
     */
    public HomePicTb getHomePicS() {

        try {
            HomePicTb homePicTb = new HomePicTb();
            homePicTb.setDeleteFlag(UNIFYTYPE.DELETE.NOT);
            return homePicTbMapper.getUniqueBy(homePicTb);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * 校验用户是否已注册
     *
     * @param user
     * @return
     */
    public boolean userVaildate(UserTb user) {

        if(userTbMapper.count(user) > 0){
            return true;
        }
        return false;

    }


}
