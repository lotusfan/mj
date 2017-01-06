package com.mjapp.dao;

import com.mjapp.model.ActivityGroupTb;
import com.mjapp.model.ActivityTb;
import com.mjapp.model.CollectTb;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ActivityTbMapper {
    public int save(ActivityTb activityTb);

    public void update(ActivityTb activityTb);

    public List<ActivityTb> getBy(ActivityTb activityTb);

    public ActivityTb getUniqueBy(ActivityTb activityTb);

    public Integer count(ActivityTb activityTb);

    public List<ActivityTb> getConditionBy(ActivityTb activityTb);

    public List<ActivityTb> getJoinActivityBy(ActivityGroupTb activityGroupTb);

    public List<ActivityTb> getCollectActivityBy(CollectTb collectTb);

}