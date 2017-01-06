package com.mjapp.service.transactionmanager;

import com.mjapp.dao.ActivityTbMapper;
import com.mjapp.model.ActivityTb;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ActivityTbTransactionManager {



    @Autowired
    private ActivityTbMapper activityTbMapper;


    public void saveActivityTb(ActivityTb activityTb) {

        activityTbMapper.save(activityTb);
    }

    public void saveActivityTbs(List<ActivityTb> activityTbs) {

        if (activityTbs == null) {
            return;
        }
        for (int i = 0; i < activityTbs.size(); i++) {
            activityTbMapper.save(activityTbs.get(i));
        }
    }

    public void updateActivityTb(ActivityTb activityTb) {
        activityTbMapper.update(activityTb);

    }

    public void updateActivityTbs(List<ActivityTb> activityTbs) {
        if (activityTbs == null) {
            return;
        }
        for (int i = 0; i < activityTbs.size(); i++) {
            activityTbMapper.update(activityTbs.get(i));
        }
    }

    public ActivityTb getUniqueBy(ActivityTb activityTb) {

        return activityTbMapper.getUniqueBy(activityTb);
    }
    public List<ActivityTb> getConditionBy(ActivityTb activityTb) {

        return activityTbMapper.getConditionBy(activityTb);
    }

    public List<ActivityTb> getBy(ActivityTb activityTb) {

        return activityTbMapper.getBy(activityTb);
    }

    public Integer count(ActivityTb activityTb) {

        return activityTbMapper.count(activityTb);
    }

}
