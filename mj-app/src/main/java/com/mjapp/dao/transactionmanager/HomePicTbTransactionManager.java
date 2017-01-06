package com.mjapp.dao.transactionmanager;

import com.mjapp.dao.HomePicTbMapper;
import com.mjapp.model.HomePicTb;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HomePicTbTransactionManager {



    @Autowired
    private HomePicTbMapper homePicTbMapper;


    public void saveHomePicTb(HomePicTb homePicTb) {

        homePicTbMapper.save(homePicTb);
    }

    public void saveHomePicTbs(List<HomePicTb> homePicTbs) {

        if (homePicTbs == null) {
            return;
        }
        for (int i = 0; i < homePicTbs.size(); i++) {
            homePicTbMapper.save(homePicTbs.get(i));
        }
    }

    public void updateHomePicTb(HomePicTb homePicTb) {
        homePicTbMapper.update(homePicTb);

    }

    public void updateHomePicTbs(List<HomePicTb> homePicTbs) {
        if (homePicTbs == null) {
            return;
        }
        for (int i = 0; i < homePicTbs.size(); i++) {
            homePicTbMapper.update(homePicTbs.get(i));
        }
    }

    public HomePicTb getUniqueBy(HomePicTb homePicTb) {

        return homePicTbMapper.getUniqueBy(homePicTb);
    }
    public List<HomePicTb> getConditionBy(HomePicTb homePicTb) {

        return homePicTbMapper.getConditionBy(homePicTb);
    }

    public List<HomePicTb> getBy(HomePicTb homePicTb) {

        return homePicTbMapper.getBy(homePicTb);
    }

    public Integer count(HomePicTb homePicTb) {

        return homePicTbMapper.count(homePicTb);
    }

}
