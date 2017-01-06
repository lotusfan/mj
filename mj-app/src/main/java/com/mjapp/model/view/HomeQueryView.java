package com.mjapp.model.view;


import com.mjapp.model.ActivityTb;
import com.mjapp.model.UserTb;

import java.util.List;

/**
 * @title: HomeQueryView
 * @description: 首页搜索查询结果View
 * @author: zhangfan
 * @data: 2016年10月23日 21:21
 */
public class HomeQueryView {

    private List<UserView> userViews;
    private List<ActivityTb> activityTbs;

    public List<ActivityTb> getActivityTbs() {
        return activityTbs;
    }

    public void setActivityTbs(List<ActivityTb> activityTbs) {
        this.activityTbs = activityTbs;
    }

    public List<UserView> getUserViews() {
        return userViews;
    }

    public void setUserViews(List<UserView> userViews) {
        this.userViews = userViews;
    }

    @Override
    public String toString() {
        return "HomeQueryView{" +
                ", userViews=" + userViews +
                ", activityTbs=" + activityTbs +
                '}';
    }
}
