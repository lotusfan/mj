package com.mjapp.service;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.jcabi.aspects.Loggable;
import com.mjapp.dao.*;
import com.mjapp.model.*;
import com.mjapp.model.constant.LIFELINETYPE;
import com.mjapp.model.constant.SERVICECODE;
import com.mjapp.model.constant.UNIFYTYPE;
import com.mjapp.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @title: ActivityManagerService
 * @description: 活动相关Service
 * @author: zhangfan
 * @data: 2016年10月11日 20:58
 */
@Loggable(trim = false)
@Service
public class ActivityManagerService {


    @Autowired
    private ActivityTbMapper activityTbMapper;
    @Autowired
    private ActivityGroupTbMapper activityGroupTbMapper;
    @Autowired
    private CollectTbMapper collectTbMapper;
    @Autowired
    private UserLifeLineService userLifeLineService;
    @Autowired
    private StoreTbMapper storeTbMapper;
    @Autowired
    private ActivityQrcodeTbMapper activityQrcodeTbMapper;

    /**
     * 返回登录用户活动列表  包括二维码
     *
     * @param id
     * @return
     */
    public List<ActivityTb> getActivityQrcodeListS(int id) {

        try {
            ActivityTb activityTb = new ActivityTb();
            activityTb.setCreateUserId(id);

            return activityTbMapper.getBy(activityTb);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }


    /**
     * 返回登录用户参加已参加的活动列表
     *
     * @param activityGroupTb
     * @return
     */
    public List<ActivityTb> getJoinActivityListS(ActivityGroupTb activityGroupTb) {

        try {
            activityGroupTb.setSkipNum((activityGroupTb.getPages() - 1) * activityGroupTb.getPageNum());
            return activityTbMapper.getJoinActivityBy(activityGroupTb);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * 返回登录用户收藏的活动列表
     *
     * @param collectTb
     * @return
     */
    public List<ActivityTb> getCollectActivityListS(CollectTb collectTb) {

        try {
            collectTb.setDeleteFlag(UNIFYTYPE.DELETE.NOT);
            collectTb.setSkipNum((collectTb.getPages() - 1) * collectTb.getPageNum());

            return activityTbMapper.getCollectActivityBy(collectTb);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * 用户发布活动
     *
     * @param activityTb
     * @return
     */
    public ActivityTb publishActivityS(ActivityTb activityTb) {

        try {
            //活动图片处理
            String fileName = System.currentTimeMillis() + PROPERTIESUTIL.get("activity_pic_name_suffix");
            Base64PicUtils.savePicFile(activityTb.getHeadPic(), fileName, PROPERTIESUTIL.get("activity_pic_url"));
            //生成二维码
            String qrFileName = fileName + PROPERTIESUTIL.get("activity_qrcode_name_suffix");
            String qrcodeContent = Md5Encrypt.md5(activityTb.getName() + Random6Digit.get(), "UTF-8");
            QrcodeUtil.createQrcode(PROPERTIESUTIL.get("activity_qrcode_url"), qrFileName, transformQrcodeContent(qrcodeContent));

            activityTb.setQrcode(PicOlineUrl.transform(qrFileName));
            activityTb.setHeadPic(PicOlineUrl.transform(fileName));
            activityTb.setDeleteFlag(UNIFYTYPE.DELETE.NOT);
            activityTbMapper.save(activityTb);

            //保存二维码 关系(可优化为异步)
            ActivityQrcodeTb qrcodeTb = new ActivityQrcodeTb();
            qrcodeTb.setActivityId(activityTb.getId());
            qrcodeTb.setActivityMd5(qrcodeContent);
            qrcodeTb.setQrcodeUrl(activityTb.getQrcode());
            qrcodeTb.setDeleteFlag(UNIFYTYPE.DELETE.NOT);
            activityQrcodeTbMapper.save(qrcodeTb);

            //添加用户轨迹
            userLifeLineService.addActivityPubliseLifeLine(activityTb.getCreateUserId(), activityTb.getId());

            return activityTb;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * 获取活动详情
     *
     * @param activityTb
     * @return
     */
    public ActivityTb activityDetailS(ActivityTb activityTb) {

        try {
            activityTb = activityTbMapper.getUniqueBy(activityTb);

            //参加活动成员
            ActivityGroupTb activityGroupTb = new ActivityGroupTb();
            activityGroupTb.setActivityId(activityTb.getId());
            activityGroupTb.setDeleteFlag(UNIFYTYPE.DELETE.NOT);
            activityTb.setMembers(activityGroupTbMapper.getActivityGroupUserViewBy(activityGroupTb));

            //商家详情
            JSONArray storeJsonArray = JSON.parseArray(activityTb.getStoreJson());

            StoreTb storeTb = new StoreTb();
            List<StoreTb> storeTbs = new ArrayList<>();
            for (int i = 0; i < storeJsonArray.size(); i++) {
                storeTb.setId(storeJsonArray.getInteger(i));
                storeTbs.add(storeTbMapper.getUniqueBy(storeTb));
            }
            activityTb.setStoreTbs(storeTbs);

            return activityTb;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * 用户收藏活动
     *
     * @param collectTb
     * @return
     */
    public SERVICECODE collectActivityS(CollectTb collectTb) {

        try {
            collectTb.setDeleteFlag(UNIFYTYPE.DELETE.NOT);
            collectTbMapper.save(collectTb);

            //添加用户轨迹
            userLifeLineService.addActivityCollectLifeLine(collectTb.getCollectUserId(), collectTb.getCollectActivityId());

            return SERVICECODE.INSERTSUCCESS;
        } catch (Exception e) {
            e.printStackTrace();
            return SERVICECODE.INSERTERROR;
        }
    }

    /**
     * 个人页面 见TA 活动 发起的活动 收藏的活动 参加的活动
     *
     * @param userLifeLineTb
     * @return
     */
    public List<ActivityTb> userActivityLifeLineS(UserLifeLineTb userLifeLineTb) {

        try {
            userLifeLineTb.setSkipNum((userLifeLineTb.getPages() - 1) * userLifeLineTb.getPageNum());
            userLifeLineTb.setDeleteFlag(UNIFYTYPE.DELETE.NOT);
            userLifeLineTb.setType1(LIFELINETYPE.ACTIVITY);

            return userLifeLineService.getUserActivityLifeLine(userLifeLineTb);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * 二维码 内容生成
     *
     * @param str
     * @return
     */
    public String transformQrcodeContent(String str) {

        String template = PROPERTIESUTIL.get("qrcode_template");
        String md5Str = Md5Encrypt.md5(str, "UTF-8");
        template = template.replaceAll("\\{md5\\}", md5Str);

        return template;
    }

}
