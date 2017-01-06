package com.mjapp.service;

import com.mjapp.dao.UserLifeLineTbMapper;
import com.mjapp.model.ActivityTb;
import com.mjapp.model.UserLifeLineTb;
import com.mjapp.model.constant.LIFELINETYPE;
import com.mjapp.model.constant.UNIFYTYPE;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @title: UserLifeLineService
 * @description: 用户添加轨迹Service
 * @author: zhangfan
 * @data: 2016年10月22日 15:29
 */
@Service
public class UserLifeLineService {

    @Autowired
    private UserLifeLineTbMapper userLifeLineTbMapper;

    /**
     * 添加用户发布活动轨迹
     *
     * @param userId
     * @param activityId
     * @return
     */
    public void addActivityPubliseLifeLine(Integer userId, Integer activityId) {

        UserLifeLineTb userLifeLineTb = new UserLifeLineTb();
        userLifeLineTb.setRelationId(activityId);
        userLifeLineTb.setUserId(userId);
        userLifeLineTb.setType1(LIFELINETYPE.ACTIVITY);
        userLifeLineTb.setType2(LIFELINETYPE.ACTIVITYPUBLISH);
        userLifeLineTb.setDeleteFlag(UNIFYTYPE.DELETE.NOT);

        userLifeLineTbMapper.save(userLifeLineTb);
    }

    /**
     * 添加用户收藏活动轨迹
     *
     * @param userId
     * @param activityId
     */
    public void addActivityCollectLifeLine(Integer userId, Integer activityId) {

        UserLifeLineTb userLifeLineTb = new UserLifeLineTb();
        userLifeLineTb.setRelationId(activityId);
        userLifeLineTb.setUserId(userId);
        userLifeLineTb.setType1(LIFELINETYPE.ACTIVITY);
        userLifeLineTb.setType2(LIFELINETYPE.ACTIVITYCOLLECT);
        userLifeLineTb.setDeleteFlag(UNIFYTYPE.DELETE.NOT);

        userLifeLineTbMapper.save(userLifeLineTb);
    }

    /**
     * 添加用户发表动态轨迹
     *
     * @param userId
     * @param newsId
     */
    public void addUserNewsLifeLine(Integer userId, Integer newsId) {

        UserLifeLineTb userLifeLineTb = new UserLifeLineTb();
        userLifeLineTb.setRelationId(newsId);
        userLifeLineTb.setUserId(userId);
        userLifeLineTb.setType1(LIFELINETYPE.NEWS);
        userLifeLineTb.setType2(LIFELINETYPE.NEWSPUBLISH);
        userLifeLineTb.setDeleteFlag(UNIFYTYPE.DELETE.NOT);

        userLifeLineTbMapper.save(userLifeLineTb);
    }

    /**
     * 添加用户转发动态轨迹
     *
     * @param userId
     * @param newsId
     */
    public void addUserNewsForwardLifeLine(Integer userId, Integer newsId) {

        UserLifeLineTb userLifeLineTb = new UserLifeLineTb();
        userLifeLineTb.setRelationId(newsId);
        userLifeLineTb.setUserId(userId);
        userLifeLineTb.setType1(LIFELINETYPE.NEWS);
        userLifeLineTb.setType2(LIFELINETYPE.NEWSFORWARD);
        userLifeLineTb.setDeleteFlag(UNIFYTYPE.DELETE.NOT);

        userLifeLineTbMapper.save(userLifeLineTb);
    }

    /**
     * 删除用户动态轨迹
     *
     * @param userId
     * @param newsId
     */
    public void deleteUserNewsForwardLifeLine(Integer userId, Integer newsId) {

        UserLifeLineTb userLifeLineTb = new UserLifeLineTb();
        userLifeLineTb.setUserId(userId);
        userLifeLineTb.setType1(LIFELINETYPE.NEWS);
        userLifeLineTb.setDeleteFlag(UNIFYTYPE.DELETE.YES);
        userLifeLineTb.setRelationId(newsId);

        userLifeLineTbMapper.updateSign(userLifeLineTb);
    }



    /**
     * 获取用户 发起的活动 收藏的活动 参加的活动 所有相关活动的轨迹
     *
     * @param userLifeLineTb
     * @return
     */
    public List<ActivityTb> getUserActivityLifeLine(UserLifeLineTb userLifeLineTb) {

        userLifeLineTb.setType1(LIFELINETYPE.ACTIVITY);
        userLifeLineTb.setDeleteFlag(UNIFYTYPE.DELETE.NOT);
        return userLifeLineTbMapper.getUserActivityLifeLineBy(userLifeLineTb);
    }


}
