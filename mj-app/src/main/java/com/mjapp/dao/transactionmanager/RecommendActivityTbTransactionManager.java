package com.mjapp.service.transactionmanager;

import com.mjapp.dao.RecommendActivityTbMapper;
import com.mjapp.model.RecommendActivityTb;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RecommendActivityTbTransactionManager {



    @Autowired
    private RecommendActivityTbMapper recommendActivityTbMapper;


    public void saveRecommendActivityTb(RecommendActivityTb recommendActivityTb) {

        recommendActivityTbMapper.save(recommendActivityTb);
    }

    public void saveRecommendActivityTbs(List<RecommendActivityTb> recommendActivityTbs) {

        if (recommendActivityTbs == null) {
            return;
        }
        for (int i = 0; i < recommendActivityTbs.size(); i++) {
            recommendActivityTbMapper.save(recommendActivityTbs.get(i));
        }
    }

    public void updateRecommendActivityTb(RecommendActivityTb recommendActivityTb) {
        recommendActivityTbMapper.update(recommendActivityTb);

    }

    public void updateRecommendActivityTbs(List<RecommendActivityTb> recommendActivityTbs) {
        if (recommendActivityTbs == null) {
            return;
        }
        for (int i = 0; i < recommendActivityTbs.size(); i++) {
            recommendActivityTbMapper.update(recommendActivityTbs.get(i));
        }
    }

    public RecommendActivityTb getUniqueBy(RecommendActivityTb recommendActivityTb) {

        return recommendActivityTbMapper.getUniqueBy(recommendActivityTb);
    }
    public List<RecommendActivityTb> getConditionBy(RecommendActivityTb recommendActivityTb) {

        return recommendActivityTbMapper.getConditionBy(recommendActivityTb);
    }

    public List<RecommendActivityTb> getBy(RecommendActivityTb recommendActivityTb) {

        return recommendActivityTbMapper.getBy(recommendActivityTb);
    }

    public Integer count(RecommendActivityTb recommendActivityTb) {

        return recommendActivityTbMapper.count(recommendActivityTb);
    }

}
