package com.mjapp.action;

import com.alibaba.fastjson.JSON;
import com.jcabi.aspects.Loggable;
import com.mjapp.model.NewsCommentTb;
import com.mjapp.model.PraiseTb;
import com.mjapp.model.UserNewsTb;
import com.mjapp.model.constant.SERVICECODE;
import com.mjapp.model.view.RequestModel;
import com.mjapp.model.view.ResponseModel;
import com.mjapp.service.EssayManagerService;
import com.mjapp.util.PROPERTIESUTIL;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @title: EssayManagerAction
 * @description: 用户动态相关Action
 * @author: zhangfan
 * @data: 2016年10月09日 21:21
 */
@Loggable(trim = false)
@Controller
@RequestMapping("essay")
public class EssayManagerAction extends ActionParent {

    @Autowired
    private EssayManagerService essayManagerService;


    /**
     * 用户发表动态
     *
     * @param requestModel
     * @return
     */
    @RequestMapping(value = "ae", method = RequestMethod.POST)
    @ResponseBody
    public ResponseModel addNews(@RequestBody RequestModel requestModel) {

        UserNewsTb userNewsTb = transformJSONObjectToModel(requestModel, UserNewsTb.class);
        if(!StringUtils.isEmpty(userNewsTb.getPicJson())){
            userNewsTb.setPicJsonArray(JSON.parseArray(userNewsTb.getPicJson()));
        }

        userNewsTb.setPicJson(null);
        userNewsTb.setUserId(requestModel.getUserId());
        SERVICECODE servicecode = essayManagerService.addNewsS(userNewsTb);

        return generateServerSuccess(servicecode, null);
    }


    /**
     * 用户删除动态
     *
     * @param requestModel
     * @return
     */

    @RequestMapping(value = "del", method = RequestMethod.POST)
    @ResponseBody
    public ResponseModel deleteNews(@RequestBody RequestModel requestModel) {

        UserNewsTb userNewsTb = transformJSONObjectToModel(requestModel, UserNewsTb.class);
        userNewsTb.setUserId(requestModel.getUserId());
        SERVICECODE servicecode = essayManagerService.deleteNewsS(userNewsTb);

        return generateServerSuccess(servicecode, null);
    }



    /**
     * 用户转发动态
     *
     * @param requestModel
     * @return
     */
    @RequestMapping(value = "fn", method = RequestMethod.POST)
    @ResponseBody
    public ResponseModel forwardNews(@RequestBody RequestModel requestModel) {

        UserNewsTb userNewsTb = transformJSONObjectToModel(requestModel, UserNewsTb.class);
        userNewsTb.setUserId(requestModel.getUserId());

        SERVICECODE servicecode = essayManagerService.forwardNewsS(userNewsTb);

        return generateServerSuccess(servicecode, null);
    }


    /**
     * 用户为动态点赞
     *
     * @param requestModel
     * @return
     */
    @RequestMapping(value = "pn", method = RequestMethod.POST)
    @ResponseBody
    public ResponseModel praiseNews(@RequestBody RequestModel requestModel) {

            PraiseTb praiseTb = transformJSONObjectToModel(requestModel, PraiseTb.class);
            praiseTb.setUserId(requestModel.getUserId());
            SERVICECODE servicecode = essayManagerService.praiseNewsS(praiseTb);

            return generateServerSuccess(servicecode, null);
    }

    /**
     * 用户动态列表
     *
     * @param requestModel
     * @return
     */
    @RequestMapping(value = "unl", method = RequestMethod.POST)
    @ResponseBody
    public ResponseModel userNewsList(@RequestBody RequestModel requestModel) {

        UserNewsTb userNewsTb = transformJSONObjectToModel(requestModel, UserNewsTb.class);
        if(userNewsTb.getPageNum() == null || userNewsTb.getPageNum() < 1) userNewsTb.setPageNum(Integer.valueOf(PROPERTIESUTIL.get("per_page")));
        if(userNewsTb.getPages() == null || userNewsTb.getPages() < 1) userNewsTb.setPages(1);


        List<UserNewsTb> list = essayManagerService.userNewsListS(userNewsTb);
        if (list == null || list.size() < 1) {
            return generateServerSuccess(SERVICECODE.SELECTEMPTY, null);
        }

        return generateServerSuccess(SERVICECODE.SELECTSUCCESS, list);
    }



    /**
     * 用户取消动态的点赞   弃用
     *
     * @param requestModel
     * @return
     */
    @RequestMapping(value = "cpn", method = RequestMethod.POST)
    @ResponseBody
    public ResponseModel canclePraiseNews(@RequestBody RequestModel requestModel) {

            PraiseTb praiseTb = transformJSONObjectToModel(requestModel, PraiseTb.class);
            praiseTb.setUserId(requestModel.getUserId());
            SERVICECODE servicecode = essayManagerService.canclePraiseNewsS(praiseTb);

            return generateServerSuccess(servicecode, null);
    }


    /**
     * 用户为动态评论
     *
     * @param requestModel
     * @return
     */
    @RequestMapping(value = "cn", method = RequestMethod.POST)
    @ResponseBody
    public ResponseModel commentNews(@RequestBody RequestModel requestModel) {

            NewsCommentTb newsCommentTb = transformJSONObjectToModel(requestModel, NewsCommentTb.class);
            newsCommentTb.setUserId(requestModel.getUserId());
            SERVICECODE servicecode = essayManagerService.commentNewsS(newsCommentTb);

            return generateServerSuccess(servicecode, null);
    }

    /**
     * 删除动态的评论
     *
     * @param requestModel
     * @return
     */
    @RequestMapping(value = "dcn", method = RequestMethod.POST)
    @ResponseBody
    public ResponseModel deleteCommentNews(@RequestBody RequestModel requestModel) {

        NewsCommentTb newsCommentTb = transformJSONObjectToModel(requestModel, NewsCommentTb.class);
        newsCommentTb.setUserId(requestModel.getUserId());
        SERVICECODE servicecode = essayManagerService.deleteCommentNewsS(newsCommentTb);

        return generateServerSuccess(servicecode, null);
    }

    /**
     * 用户动态详情
     *
     * @param requestModel
     * @return
     */
    @RequestMapping(value = "det", method = RequestMethod.POST)
    @ResponseBody
    public ResponseModel detailNews(@RequestBody RequestModel requestModel) {

        UserNewsTb userNewsTb = transformJSONObjectToModel(requestModel, UserNewsTb.class);
        userNewsTb = essayManagerService.detailNewsS(userNewsTb);

        if (userNewsTb == null) {
            return generateServerSuccess(SERVICECODE.SELECTEMPTY, null);
        }
        return generateServerSuccess(SERVICECODE.SELECTSUCCESS, userNewsTb);
    }



}
