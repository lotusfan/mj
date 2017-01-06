package com.mjapp.action;

import com.jcabi.aspects.Loggable;
import com.mjapp.model.ActivityTb;
import com.mjapp.model.UserFocusTb;
import com.mjapp.model.UserTb;
import com.mjapp.model.constant.SERVICECODE;
import com.mjapp.model.view.RequestModel;
import com.mjapp.model.view.ResponseModel;
import com.mjapp.model.view.UserView;
import com.mjapp.service.UserBasicInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @title: UserBasicInfoManagerAction
 * @description: 用户相关接口Action
 * @author: zhangfan
 * @data: 2016年09月30日 13:42
 */
@Loggable(trim = false)
@RequestMapping("user")
@Controller
public class UserBasicInfoManagerAction extends ActionParent {

    @Autowired
    private UserBasicInfoService userBasicInfoService;

    /**
     * 个人信息修改
     *
     * @param requestModel
     * @return
     */
    @RequestMapping(value = "up", method = RequestMethod.POST)
    @ResponseBody
    public ResponseModel updateUser(@RequestBody RequestModel requestModel) {


        UserTb userTb = transformJSONObjectToModel(requestModel, UserTb.class);

        SERVICECODE servicecode = userBasicInfoService.updateUserS(userTb);

        return generateServerSuccess(servicecode, null);
    }

    /**
     * 获取用户简介
     *
     * @param requestModel
     * @return
     */
    @RequestMapping(value = "uv", method = RequestMethod.POST)
    @ResponseBody
    public ResponseModel getUserView(@RequestBody RequestModel requestModel) {


        UserTb userTb = transformJSONObjectToModel(requestModel, UserTb.class);

        UserView userView = userBasicInfoService.getUserViewS(userTb);

        if (userView == null) {
            return generateServerSuccess(SERVICECODE.SELECTERROR, null);
        }

        return generateServerSuccess(SERVICECODE.SELECTSUCCESS, userView);
    }


    /**
     * 更换头像
     *
     * @param requestModel
     * @return
     */
    @RequestMapping(value = "uphp", method = RequestMethod.POST)
    @ResponseBody
    public ResponseModel updateUserHeadPic(@RequestBody RequestModel requestModel) {


        SERVICECODE servicecode = userBasicInfoService.updateUserHeadPicS(requestModel.getUserId().intValue(),
                String.valueOf(requestModel.getO()));

        return generateServerSuccess(servicecode, null);
    }

    /**
     * 更换背景图片
     *
     * @param requestModel
     * @return
     */
    @RequestMapping(value = "upbp", method = RequestMethod.POST)
    @ResponseBody
    public ResponseModel updateUserBackgroundPic(@RequestBody RequestModel requestModel) {

        SERVICECODE servicecode = userBasicInfoService.updateUserBackgroundPicS(requestModel.getUserId().intValue(),
                String.valueOf(requestModel.getO()));

        return generateServerSuccess(servicecode, null);
    }


    /**
     * 获取用户评论和赞未阅读数量
     *
     * @param requestModel
     * @return
     */
    public ResponseModel getNotReadPraiseAndCommentNum(@RequestBody RequestModel requestModel) {

        return null;
    }

    /**
     * 获取用户评论和点赞的时间列表
     *
     * @param requestModel
     * @return
     */
    public ResponseModel getPraiseAndCommentList(@RequestBody RequestModel requestModel) {

        return null;
    }


    /**
     * 获取关注的人列表
     *
     * @param requestModel
     * @return
     */
    @RequestMapping(value = "fol", method = RequestMethod.POST)
    @ResponseBody
    public ResponseModel getFocusList(@RequestBody RequestModel requestModel) {

        UserFocusTb userFocusTb = transformJSONObjectToModel(requestModel, UserFocusTb.class);
//        userFocusTb.setActiveUserId(requestModel.getUserId());

        List<UserView> list = userBasicInfoService.focusListS(userFocusTb);

        if (list == null) {
            return generateServerSuccess(SERVICECODE.SELECTEMPTY, null);
        }
        return generateServerSuccess(SERVICECODE.SELECTSUCCESS, list);
    }

    /**
     * 获取粉丝列表
     *
     * @param requestModel
     * @return
     */
    @RequestMapping(value = "fl", method = RequestMethod.POST)
    @ResponseBody
    public ResponseModel getFansList(@RequestBody RequestModel requestModel) throws Exception {

        UserFocusTb userFocusTb = transformJSONObjectToModel(requestModel, UserFocusTb.class);
//        userFocusTb.setPassiveUserId(requestModel.getUserId());

        List<UserView> list = userBasicInfoService.fansListS(userFocusTb);

        if (list == null) {
            return generateServerSuccess(SERVICECODE.SELECTEMPTY, null);
        }
        return generateServerSuccess(SERVICECODE.SELECTSUCCESS, list);
    }


    /**
     * 关注他人
     *
     * @param requestModel
     * @return
     */
    @RequestMapping(value = "fu", method = RequestMethod.POST)
    @ResponseBody
    public ResponseModel focusUser(@RequestBody RequestModel requestModel) {

        UserFocusTb userFocusTb = transformJSONObjectToModel(requestModel, UserFocusTb.class);

        SERVICECODE servicecode = userBasicInfoService.focusUserS(userFocusTb);

        return generateServerSuccess(servicecode, null);
    }

    /**
     * 取消关注他人
     *
     * @param requestModel
     * @return
     */
    @RequestMapping(value = "fuc", method = RequestMethod.POST)
    @ResponseBody
    public ResponseModel cancelFocusUser(@RequestBody RequestModel requestModel) {

        UserFocusTb userFocusTb = transformJSONObjectToModel(requestModel, UserFocusTb.class);

        SERVICECODE servicecode = userBasicInfoService.cancelFocusUserS(userFocusTb);

        return generateServerSuccess(servicecode, null);
    }

}
