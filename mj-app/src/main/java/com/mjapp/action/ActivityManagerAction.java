package com.mjapp.action;

import com.jcabi.aspects.Loggable;
import com.mjapp.model.ActivityGroupTb;
import com.mjapp.model.ActivityTb;
import com.mjapp.model.CollectTb;
import com.mjapp.model.UserLifeLineTb;
import com.mjapp.model.constant.SERVICECODE;
import com.mjapp.model.view.RequestModel;
import com.mjapp.model.view.ResponseModel;
import com.mjapp.service.ActivityManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @title: ActivityManagerAction
 * @description: 活动相关Action
 * @author: zhangfan
 * @data: 2016年10月09日 21:20
 */
@Loggable(trim = false)
@Controller
@RequestMapping("activity")
public class ActivityManagerAction extends ActionParent {


    @Autowired
    private ActivityManagerService activityManagerService;

    /**
     * 用户发布活动
     *
     * @param requestModel
     * @return
     */

    @RequestMapping(value = "pub", method = RequestMethod.POST)
    @ResponseBody
    public ResponseModel publishActivity(@RequestBody RequestModel requestModel) {

        ActivityTb activityTb = transformJSONObjectToModel(requestModel, ActivityTb.class);

        activityTb = activityManagerService.publishActivityS(activityTb);
        if (activityTb == null) {
            return generateServerSuccess(SERVICECODE.INSERTERROR, null);
        }
        return generateServerSuccess(SERVICECODE.INSERTSUCCESS, activityTb.getQrcode());
    }

    /**
     * 获取活动详情
     *
     * @param requestModel
     * @return
     */
    @RequestMapping(value = "det", method = RequestMethod.POST)
    @ResponseBody
    public ResponseModel getActivityDetail(@RequestBody RequestModel requestModel) {

        ActivityTb activityTb = transformJSONObjectToModel(requestModel, ActivityTb.class);

        activityTb = activityManagerService.activityDetailS(activityTb);
        if (activityTb == null) {
            return generateServerSuccess(SERVICECODE.SELECTERROR, null);
        }

        return generateServerSuccess(SERVICECODE.SELECTSUCCESS, activityTb);
    }


    /**
     * 获取活动二维码列表
     *
     * @param requestModel
     * @return
     */

    @RequestMapping(value = "acl", method = RequestMethod.POST)
    @ResponseBody
    public ResponseModel getActivityQrcodeList(@RequestBody RequestModel requestModel) {

        List<ActivityTb> list = activityManagerService.getActivityQrcodeListS(requestModel.getUserId().intValue());

        if (list == null || list.size() < 1) {
            return generateServerSuccess(SERVICECODE.SELECTEMPTY, null);
        }

        return generateServerSuccess(SERVICECODE.SELECTSUCCESS, list);
    }

    /**
     * 获取用户发布活动列表(二维码列表同一个接口)
     *
     * @param requestModel
     * @return
     */
    public ResponseModel getPublishActivityList(@RequestBody RequestModel requestModel) {


        return null;

    }

    /**
     * 获取用户参加活动列表
     *
     * @param requestModel
     * @return
     */
    @RequestMapping(value = "jal", method = RequestMethod.POST)
    @ResponseBody
    public ResponseModel getJoinActivityList(@RequestBody RequestModel requestModel) {

        ActivityGroupTb activityGroupTb = transformJSONObjectToModel(requestModel, ActivityGroupTb.class);
        activityGroupTb.setJoinUserId(requestModel.getUserId());

        List<ActivityTb> list = activityManagerService.getJoinActivityListS(activityGroupTb);

        if (list == null || list.size() < 1) {
            return generateServerSuccess(SERVICECODE.SELECTEMPTY, null);
        }

        return generateServerSuccess(SERVICECODE.SELECTSUCCESS, list);
    }

    /**
     * 获取用户收藏活动列表
     *
     * @param requestModel
     * @return
     */
    @RequestMapping(value = "cal", method = RequestMethod.POST)
    @ResponseBody
    public ResponseModel getCollectActivityList(@RequestBody RequestModel requestModel) {

        CollectTb collectTb = transformJSONObjectToModel(requestModel, CollectTb.class);
        collectTb.setCollectUserId(requestModel.getUserId());

        List<ActivityTb> list = activityManagerService.getCollectActivityListS(collectTb);

        if (list == null || list.size() < 1) {
            return generateServerSuccess(SERVICECODE.SELECTEMPTY, null);
        }

        return generateServerSuccess(SERVICECODE.SELECTSUCCESS, list);
    }

    /**
     * 获取活动群组
     *
     * @param requestModel
     * @return
     */
    public ResponseModel getActivityGroup(@RequestBody RequestModel requestModel) {

        return null;
    }


    /**
     * 用户参加活动
     *
     * @param requestModel
     * @return
     */
    public ResponseModel partInActivity(@RequestBody RequestModel requestModel) {

        return null;
    }

    /**
     * 用户收藏活动
     *
     * @param requestModel
     * @return
     */
    @RequestMapping(value = "ca", method = RequestMethod.POST)
    @ResponseBody
    public ResponseModel collectActivity(@RequestBody RequestModel requestModel) {

        CollectTb collectTb = transformJSONObjectToModel(requestModel, CollectTb.class);
        collectTb.setCollectUserId(requestModel.getUserId());

        SERVICECODE servicecode = activityManagerService.collectActivityS(collectTb);
        return generateServerSuccess(servicecode, null);
    }

    /**
     * 个人页面 见TA 活动 发起的活动 收藏的活动 参加的活动
     *
     * @param requestModel
     * @return
     */
    @RequestMapping(value = "uall", method = RequestMethod.POST)
    @ResponseBody
    public ResponseModel userActivityLifeLine(@RequestBody RequestModel requestModel) {

        UserLifeLineTb userLifeLineTb = transformJSONObjectToModel(requestModel, UserLifeLineTb.class);
        userLifeLineTb.setUserId(requestModel.getUserId());

        List<ActivityTb> list = activityManagerService.userActivityLifeLineS(userLifeLineTb);
        if (list == null) {
            return generateServerSuccess(SERVICECODE.SELECTERROR, null);
        }

        return generateServerSuccess(SERVICECODE.SELECTSUCCESS, list);
    }

}
