package com.mjapp.action;

import com.jcabi.aspects.Loggable;
import com.mjapp.model.ActivityTb;
import com.mjapp.model.RecommendActivityTb;
import com.mjapp.model.RecommendUserTb;
import com.mjapp.model.UserLifeLineTb;
import com.mjapp.model.constant.SERVICECODE;
import com.mjapp.model.view.*;
import com.mjapp.service.MJAdvancedQueryService;
import com.mjapp.util.PROPERTIESUTIL;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;

/**
 * @title: MJAdvancedSelectAction
 * @description: MJ APP  高级复合查寻接口(主页  导航)
 * @author: zhangfan
 * @data: 2016年10月11日 21:48
 */
@Loggable(trim = false)
@Controller
@RequestMapping("mj")
public class MJAdvancedQueryAction extends ActionParent{

    @Autowired
    private MJAdvancedQueryService mjAdvancedQueryService;


    /**
     * 首页推荐
     *
     * @param requestModel
     * @return
     */
    @RequestMapping(value = "home", method = RequestMethod.POST)
    @ResponseBody
    public ResponseModel homeRecommend(@RequestBody RequestModel requestModel) {


        RecommendUserTb recommendUserTb = transformJSONObjectToModel(requestModel, RecommendUserTb.class);
        if(recommendUserTb == null){
            recommendUserTb = new RecommendUserTb();
            recommendUserTb.setPages(1);
            recommendUserTb.setPageNum(Integer.valueOf(PROPERTIESUTIL.get("per_page")));
        }

        recommendUserTb.setUserId(requestModel.getUserId());


        HomeQueryView homeQueryView = mjAdvancedQueryService.homeRecommendS(recommendUserTb);
        if (homeQueryView == null) {
            return generateServerSuccess(SERVICECODE.SELECTERROR, null);
        }

        return generateServerSuccess(SERVICECODE.SELECTSUCCESS, homeQueryView);
    }


    /**
     * 获取平台推荐活动
     *
     * @param requestModel
     * @return
     */
    @RequestMapping(value = "ral", method = RequestMethod.POST)
    @ResponseBody
    public ResponseModel recommendActivityList(@RequestBody RequestModel requestModel) {

        RecommendActivityTb recommendActivityTb = transformJSONObjectToModel(requestModel, RecommendActivityTb.class);

        List<ActivityTb> list = mjAdvancedQueryService.recommendActivityListS(recommendActivityTb);
        if (list == null) {
            return generateServerSuccess(SERVICECODE.SELECTERROR, null);
        }

        return generateServerSuccess(SERVICECODE.SELECTSUCCESS, list);
    }

    /**
     * 获取平台推荐用户
     *
     * @param requestModel
     * @return
     */
    @RequestMapping(value = "rul", method = RequestMethod.POST)
    @ResponseBody
    public ResponseModel recommendUserList(@RequestBody RequestModel requestModel) {

        RecommendUserTb recommendUserTb = transformJSONObjectToModel(requestModel, RecommendUserTb.class);

        recommendUserTb.setUserId(requestModel.getUserId());
        List<UserView> list = mjAdvancedQueryService.recommendUserListS(recommendUserTb);
        if (list == null) {
            return generateServerSuccess(SERVICECODE.SELECTERROR, null);
        }

        return generateServerSuccess(SERVICECODE.SELECTSUCCESS, list);
    }



    /**
     * 首页搜索
     *
     * @param requestModel
     * @return
     */
    @RequestMapping(value = "homeq", method = RequestMethod.POST)
    @ResponseBody
    public ResponseModel homeQuery(@RequestBody RequestModel requestModel) {


        String str = transformJSONObjectToModel(requestModel, String.class);

        HomeQueryView homeQueryView = mjAdvancedQueryService.homeQueryS(str, requestModel.getUserId());

        if (homeQueryView == null) {
            return generateServerSuccess(SERVICECODE.SELECTEMPTY, null);
        }

        return generateServerSuccess(SERVICECODE.SELECTSUCCESS, homeQueryView);
    }


    /**
     * 见Ta导航
     *
     * @param requestModel
     * @return
     */
    @RequestMapping(value = "jta", method = RequestMethod.POST)
    @ResponseBody
    public ResponseModel jTa(@RequestBody RequestModel requestModel) {

        UserLifeLineTb userLifeLineTb = transformJSONObjectToModel(requestModel, UserLifeLineTb.class);
        userLifeLineTb.setUserId(requestModel.getUserId());

        List<JTaView> list = mjAdvancedQueryService.jTaS(userLifeLineTb);
        if (list == null || list.size() < 1) {
            return generateServerSuccess(SERVICECODE.SELECTEMPTY, null);
        }
        return generateServerSuccess(SERVICECODE.SELECTSUCCESS, list);
    }

}
