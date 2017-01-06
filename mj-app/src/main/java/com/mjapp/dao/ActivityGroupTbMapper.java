package com.mjapp.dao;

import com.mjapp.model.ActivityGroupTb;
import com.mjapp.model.ActivityTb;
import com.mjapp.model.view.UserView;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ActivityGroupTbMapper {
    public void save(ActivityGroupTb activityGroupTb);

    public void update(ActivityGroupTb activityGroupTb);

    public List<ActivityGroupTb> getBy(ActivityGroupTb activityGroupTb);

    public ActivityGroupTb getUniqueBy(ActivityGroupTb activityGroupTb);

    public Integer count(ActivityGroupTb activityGroupTb);

    public List<ActivityGroupTb> getConditionBy(ActivityGroupTb activityGroupTb);

    List<UserView> getActivityGroupUserViewBy(ActivityGroupTb activityGroupTb);
}