package com;

import com.alibaba.fastjson.JSON;
import com.mjapp.model.*;
import com.mjapp.model.view.BackPassWordVies;
import com.mjapp.model.view.RequestModel;
import com.mjapp.util.Base64Utils;
import com.sun.xml.internal.messaging.saaj.util.ByteOutputStream;

import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * @title: RequestModelToJson
 * @description: 请求参数生成器
 * @author: zhangfan
 * @data: 2016年10月13日 20:25
 */
public class RequestModelToJson {


    public static void main(String[] args) throws Exception {

        RequestModel requestModel = new RequestModel();
        requestModel.setUserId(1);
        requestModel.setUserName("用户名");
        requestModel.setTokenId("tokenId");
        requestModel.setClientType("android/ios");
        requestModel.setVersion("1.0");

        //用户数据
        UserTb userTb = new UserTb();
        userTb.setLoginName("zhangfan");
        userTb.setPassword("123456");

        print(requestModel, userTb);


        //找回密码
        BackPassWordVies backPassWordVies = new BackPassWordVies();
        backPassWordVies.setLoginName("zhangfan1");
        backPassWordVies.setCode("短信验证码");
        backPassWordVies.setNewWord("123456");

        print(requestModel, backPassWordVies);

        //意见反馈
        UserFeedbackTb userFeedbackTb = new UserFeedbackTb();
        userFeedbackTb.setContent("反馈内容");

        print(requestModel, userFeedbackTb);

        //店铺
        StoreTb storeTb = new StoreTb();
        storeTb.setPosition1("三里");

        print(requestModel, storeTb);

        //动态  带图片


        List<String> piclist = new ArrayList<>();
//        piclist.add(str);
//        piclist.add(new String(str));
        UserNewsTb userNewsTb = new UserNewsTb();
        userNewsTb.setContent("发表测试内容");
        userNewsTb.setUserId(1);
        userNewsTb.setPicJson(JSON.toJSONString(piclist));

        print(requestModel, userNewsTb);


        // 动态不带图片
        UserNewsTb userNewsTb1 = new UserNewsTb();
        userNewsTb1.setUserId(1);
        userNewsTb1.setForwardNewsId(2);
        userNewsTb1.setContent("转发");

        print(requestModel, userNewsTb1);


        //用户推荐
        RecommendUserTb recommendUserTb = new RecommendUserTb();
        recommendUserTb.setPageNum(10);
        recommendUserTb.setPages(1);

        print(requestModel, recommendUserTb);


        //为动态点赞
        PraiseTb praiseTb = new PraiseTb();
        praiseTb.setUserId(1);
        praiseTb.setNewsId(2);
        praiseTb.setUserNewsId(3);

        print(requestModel, praiseTb);

        //动态列表
        UserNewsTb userNewsTb2 = new UserNewsTb();
        userNewsTb2.setUserId(1);
        userNewsTb2.setPages(1);
        userNewsTb2.setPageNum(10);

        print(requestModel, userNewsTb2);

        //动态评论
        NewsCommentTb newsCommentTb = new NewsCommentTb();
        newsCommentTb.setNewsId(1);
        newsCommentTb.setUserId(1);
        newsCommentTb.setContent("评论内容");
        newsCommentTb.setReplyUserId(2);
        newsCommentTb.setNewsUserId(3);
        newsCommentTb.setParentCommentId(4);

        print(requestModel, newsCommentTb);

        //用户信息修改
        UserTb userTb1 = new UserTb();
        userTb1.setAge(3);
        userTb1.setCardNum("身份证号");
        userTb1.setCity("城市");
        userTb1.setJob("工作");
        userTb1.setJobTrade("工作圈");
        userTb1.setNickName("昵称");
        userTb1.setRealName("真实姓名");
        userTb1.setSchool("学校");
        userTb1.setSignature("个性签名");
        userTb1.setSex(1);

        print(requestModel, userTb1);

        //用户更换头像
        print(requestModel, getPicBase64Str());


        //关注的人列表
        UserFocusTb userFocusTb = new UserFocusTb();
        userFocusTb.setActiveUserId(1);
        userFocusTb.setPages(1);
        userFocusTb.setPageNum(10);

        print(requestModel, userFocusTb);

        //获取粉丝的列表
        UserFocusTb userFocusTb1 = new UserFocusTb();
        userFocusTb1.setPassiveUserId(2);
        userFocusTb1.setActiveUserId(1);
        userFocusTb1.setPages(1);
        userFocusTb1.setPageNum(10);

        print(requestModel, userFocusTb1);

        //发布活动
        ActivityTb activityTb = new ActivityTb();
        activityTb.setName("活动名称");
        activityTb.setPlace("活动地点");
        activityTb.setDetail("活动概述");
        activityTb.setTime("活动时间 (字符串形式)");
//        activityTb.setHeadPic(getPicBase64Str());
        activityTb.setCreateUserId(1);
        List<String> storeIdlist = new ArrayList<>();
        storeIdlist.add("店铺1的Id");
        storeIdlist.add("店铺2的Id");
        activityTb.setStoreJson(JSON.toJSONString(storeIdlist));

        print(requestModel, activityTb);

        //获取活动详情
        ActivityTb activityTb1 = new ActivityTb();
        activityTb1.setId(1);

        print(requestModel, activityTb1);

        //用户收藏活动
        CollectTb collectTb = new CollectTb();
        collectTb.setCollectActivityId(1);
        collectTb.setCollectUserId(1);

        print(requestModel, collectTb);

        //个人页面 见TA
        UserLifeLineTb userLifeLineTb = new UserLifeLineTb();
        userLifeLineTb.setPageNum(10);
        userLifeLineTb.setPages(1);
        userLifeLineTb.setUserId(1);

        print(requestModel, userLifeLineTb);
    }

    public static void print(RequestModel requestModel, Object o) {
        requestModel.setO(o);
        System.out.println(o.getClass().getSimpleName());
        System.out.println(JSON.toJSONString(requestModel) + "\n");
    }

    public static String getPicBase64Str() throws Exception {

        FileInputStream fileInputStream = new FileInputStream(new File("/Users/zhangfan/Documents/asd.jpg"));

        ByteOutputStream byteOutputStream = new ByteOutputStream();
        int i = 0;
        byte[] bytes = new byte[512];
        while ((i = fileInputStream.read(bytes)) > 0) {
            byteOutputStream.write(bytes, 0, i);
        }

        String str = Base64Utils.encode(byteOutputStream.getBytes());
        return str;
    }
}
