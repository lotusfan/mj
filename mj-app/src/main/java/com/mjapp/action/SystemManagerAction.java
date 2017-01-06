package com.mjapp.action;

import com.jcabi.aspects.Loggable;
import com.mjapp.cache.LoginCache;
import com.mjapp.cache.SmsCache;
import com.mjapp.model.HomePicTb;
import com.mjapp.model.UserFeedbackTb;
import com.mjapp.model.UserTb;
import com.mjapp.model.constant.SERVICECODE;
import com.mjapp.model.view.BackPassWordVies;
import com.mjapp.model.view.RequestModel;
import com.mjapp.model.view.ResponseModel;
import com.mjapp.service.SystemService;
import com.mjapp.util.PROPERTIESUTIL;
import com.mjapp.util.Random6Digit;
import com.mjapp.util.UUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @title: SystemManagerAction
 * @description: APP系统相关操作Action
 * @author: zhangfan
 * @data: 2016年10月03日 14:16
 */
@Loggable(trim = false)
@Controller
@RequestMapping("/sys")
public class SystemManagerAction extends ActionParent {


    @Autowired
    private SystemService systemService;

    @Autowired
    private SmsVaildate smsVaildate;


    /**
     * 用户登录
     *
     * @param requestModel
     */
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    @ResponseBody
    public ResponseModel login(@RequestBody RequestModel requestModel) {

        UserTb userTb = transformJSONObjectToModel(requestModel, UserTb.class);
        //校验 用户名 和密码 合法性
        if (userTb.getLoginName() == null || userTb.getLoginName().length() < 1) {
            return generateServerSuccess(SERVICECODE.LOGINNAMEEMPTY, null);
        }
        if (userTb.getPassword() == null || userTb.getPassword().length() < 1) {
            return generateServerSuccess(SERVICECODE.LOGINPASSWORDEMPTY, null);
        }

        //Service 校验
        userTb = systemService.loginS(userTb);

        if (userTb == null) {
            return generateServerSuccess(SERVICECODE.LOGINUSERERROR, null);
        }

        userTb.setPassword("");

        String token = UUID.get();
        LoginCache.put(token, userTb);

        return generateServerSuccess(SERVICECODE.REQUESTSUCCESS, token, userTb);
    }

    /**
     * 用户找回密码
     *
     * @param requestModel
     */
    @RequestMapping(value = "/bpw", method = RequestMethod.POST)
    @ResponseBody
    public ResponseModel backPassWord(@RequestBody RequestModel requestModel) {

        BackPassWordVies backPassWordVies = transformJSONObjectToModel(requestModel, BackPassWordVies.class);

            if (!smsVaildate.vcodeBac(backPassWordVies.getLoginName(), backPassWordVies.getCode())) {
                return generateServerSuccess(SERVICECODE.SMSCODEERROR, null);
            }

        UserTb userTb = new UserTb();
        userTb.setLoginName(backPassWordVies.getLoginName());
        userTb.setPassword(backPassWordVies.getNewWord());
        return generateServerSuccess(systemService.backPassWordS(userTb), null);
    }

    /**
     * 用户找回密码发送短信
     *
     * @param requestModel
     * @return
     */
    @RequestMapping(value = "smsb", method = RequestMethod.POST)
    @ResponseBody
    public ResponseModel smsBac(@RequestBody RequestModel requestModel) throws Exception{

        UserTb userTb = transformJSONObjectToModel(requestModel, UserTb.class);

        //判断用户是否已注册
        if (!systemService.userVaildate(userTb)) {
            return generateServerSuccess(SERVICECODE.USERNOTEXIST, null);
        }


        //发送短信次数限制
        if (!smsVaildate.vsend(userTb.getLoginName())) {
            return generateServerSuccess(SERVICECODE.SMSNUMEXCEED, null);
        }
        //发送短信
        int codeSMS = systemService.sendSMSBpd(userTb);

        SmsCache.putBac(userTb.getLoginName(), String.valueOf(codeSMS));
        SmsCache.putNum(userTb.getLoginName());
        return generateServerSuccess(SERVICECODE.REQUESTSUCCESS, null);
    }


    /**
     * 用户注册
     *
     * @param requestModel
     */
    @RequestMapping(value = "/reg", method = RequestMethod.POST)
    @ResponseBody
    public ResponseModel register(@RequestBody RequestModel requestModel) {

        BackPassWordVies backPassWordVies = transformJSONObjectToModel(requestModel, BackPassWordVies.class);

        //验证短信验证码
        if(!smsVaildate.vcodeReg(backPassWordVies.getLoginName(), backPassWordVies.getCode())){
            return generateServerSuccess(SERVICECODE.SMSCODEERROR, null);
        }

        UserTb userTb = new UserTb();
        userTb.setLoginName(backPassWordVies.getLoginName());
        userTb.setPassword(backPassWordVies.getNewWord());
        userTb.setHeadPic(PROPERTIESUTIL.get("head_pic_default"));
        userTb.setMjCode(Random6Digit.get());

        return generateServerSuccess(systemService.registerS(userTb), null);
    }

    /**
     * 用户注册发送短信m
     *
     * @param requestModel
     * @return
     */
    @RequestMapping(value = "/smsr", method = RequestMethod.POST)
    @ResponseBody
    public ResponseModel smsReg(@RequestBody RequestModel requestModel) {

        UserTb userTb = transformJSONObjectToModel(requestModel, UserTb.class);

        //判断用户是否已注册
        if(systemService.userVaildate(userTb)){
            return generateServerSuccess(SERVICECODE.USEREXIST, null);
        }

        //发送短信次数限制
        if (!smsVaildate.vsend(userTb.getLoginName())) {
            return generateServerSuccess(SERVICECODE.SMSNUMEXCEED, null);
        }
        //发送短信
        int codeSMS = systemService.sendSMSReg(userTb);

        SmsCache.putReg(userTb.getLoginName(), String.valueOf(codeSMS));
        SmsCache.putNum(userTb.getLoginName());

        return generateServerSuccess(SERVICECODE.REQUESTSUCCESS, null);
    }


    /**
     * 用户反馈
     *
     * @param requestModel
     * @return
     */
    @RequestMapping(value = "fd", method = RequestMethod.POST)
    @ResponseBody
    public ResponseModel feedback(@RequestBody RequestModel requestModel) {

        UserFeedbackTb userFeedbackTb = transformJSONObjectToModel(requestModel, UserFeedbackTb.class);

        return generateServerSuccess(systemService.feedbackS(userFeedbackTb), null);
    }


    /**
     * 获取首页加载图片
     *
     * @return
     */
    @RequestMapping(value = "hp", method = RequestMethod.POST)
    @ResponseBody
    public ResponseModel getHomePic() {

        HomePicTb homePicTb = systemService.getHomePicS();

        if (homePicTb == null) {
            return generateServerSuccess(SERVICECODE.SELECTERROR, null);
        }

        return generateServerSuccess(SERVICECODE.SELECTSUCCESS, homePicTb);
    }


}

