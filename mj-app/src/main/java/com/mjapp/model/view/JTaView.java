package com.mjapp.model.view;

import com.mjapp.model.ActivityTb;
import com.mjapp.model.UserNewsTb;

/**
 * @title: JTaView
 * @description: 见Ta 导航View
 * @author: zhangfan
 * @data: 2016年11月06日 16:13
 */
public class JTaView {

    private Integer type;
    private UserNewsTb userNewsTb;
    private ActivityTb activityTb;

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public UserNewsTb getUserNewsTb() {
        return userNewsTb;
    }

    public void setUserNewsTb(UserNewsTb userNewsTb) {
        this.userNewsTb = userNewsTb;
    }

    public ActivityTb getActivityTb() {
        return activityTb;
    }

    public void setActivityTb(ActivityTb activityTb) {
        this.activityTb = activityTb;
    }

    @Override
    public String toString() {
        return "JTaView{" +
                "type=" + type +
                ", userNewsTb=" + userNewsTb +
                ", activityTb=" + activityTb +
                '}';
    }
}
