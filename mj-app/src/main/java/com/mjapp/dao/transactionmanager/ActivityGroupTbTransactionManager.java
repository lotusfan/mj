package com.mjapp.service.transactionmanager;

import com.mjapp.dao.ActivityGroupTbMapper;
import com.mjapp.model.ActivityGroupTb;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ActivityGroupTbTransactionManager {



    @Autowired
    private ActivityGroupTbMapper activityGroupTbMapper;


    public void saveActivityGroupTb(ActivityGroupTb activityGroupTb) {

        activityGroupTbMapper.save(activityGroupTb);
    }

    public void saveActivityGroupTbs(List<ActivityGroupTb> activityGroupTbs) {

        if (activityGroupTbs == null) {
            return;
        }
        for (int i = 0; i < activityGroupTbs.size(); i++) {
            activityGroupTbMapper.save(activityGroupTbs.get(i));
        }
    }

    public void updateActivityGroupTb(ActivityGroupTb activityGroupTb) {
        activityGroupTbMapper.update(activityGroupTb);

    }

    public void updateActivityGroupTbs(List<ActivityGroupTb> activityGroupTbs) {
        if (activityGroupTbs == null) {
            return;
        }
        for (int i = 0; i < activityGroupTbs.size(); i++) {
            activityGroupTbMapper.update(activityGroupTbs.get(i));
        }
    }

    public ActivityGroupTb getUniqueBy(ActivityGroupTb activityGroupTb) {

        return activityGroupTbMapper.getUniqueBy(activityGroupTb);
    }
    public List<ActivityGroupTb> getConditionBy(ActivityGroupTb activityGroupTb) {

        return activityGroupTbMapper.getConditionBy(activityGroupTb);
    }

    public List<ActivityGroupTb> getBy(ActivityGroupTb activityGroupTb) {

        return activityGroupTbMapper.getBy(activityGroupTb);
    }

    public Integer count(ActivityGroupTb activityGroupTb) {

        return activityGroupTbMapper.count(activityGroupTb);
    }

}
