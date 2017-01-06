package com.mjapp.service.transactionmanager;

import com.mjapp.dao.RecommendUserTbMapper;
import com.mjapp.model.RecommendUserTb;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RecommendUserTbTransactionManager {



    @Autowired
    private RecommendUserTbMapper recommendUserTbMapper;


    public void saveRecommendUserTb(RecommendUserTb recommendUserTb) {

        recommendUserTbMapper.save(recommendUserTb);
    }

    public void saveRecommendUserTbs(List<RecommendUserTb> recommendUserTbs) {

        if (recommendUserTbs == null) {
            return;
        }
        for (int i = 0; i < recommendUserTbs.size(); i++) {
            recommendUserTbMapper.save(recommendUserTbs.get(i));
        }
    }

    public void updateRecommendUserTb(RecommendUserTb recommendUserTb) {
        recommendUserTbMapper.update(recommendUserTb);

    }

    public void updateRecommendUserTbs(List<RecommendUserTb> recommendUserTbs) {
        if (recommendUserTbs == null) {
            return;
        }
        for (int i = 0; i < recommendUserTbs.size(); i++) {
            recommendUserTbMapper.update(recommendUserTbs.get(i));
        }
    }

    public RecommendUserTb getUniqueBy(RecommendUserTb recommendUserTb) {

        return recommendUserTbMapper.getUniqueBy(recommendUserTb);
    }
    public List<RecommendUserTb> getConditionBy(RecommendUserTb recommendUserTb) {

        return recommendUserTbMapper.getConditionBy(recommendUserTb);
    }

    public List<RecommendUserTb> getBy(RecommendUserTb recommendUserTb) {

        return recommendUserTbMapper.getBy(recommendUserTb);
    }

    public Integer count(RecommendUserTb recommendUserTb) {

        return recommendUserTbMapper.count(recommendUserTb);
    }

}
