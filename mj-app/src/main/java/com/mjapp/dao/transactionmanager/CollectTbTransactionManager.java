package com.mjapp.service.transactionmanager;

import com.mjapp.dao.CollectTbMapper;
import com.mjapp.model.CollectTb;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CollectTbTransactionManager {



    @Autowired
    private CollectTbMapper collectTbMapper;


    public void saveCollectTb(CollectTb collectTb) {

        collectTbMapper.save(collectTb);
    }

    public void saveCollectTbs(List<CollectTb> collectTbs) {

        if (collectTbs == null) {
            return;
        }
        for (int i = 0; i < collectTbs.size(); i++) {
            collectTbMapper.save(collectTbs.get(i));
        }
    }

    public void updateCollectTb(CollectTb collectTb) {
        collectTbMapper.update(collectTb);

    }

    public void updateCollectTbs(List<CollectTb> collectTbs) {
        if (collectTbs == null) {
            return;
        }
        for (int i = 0; i < collectTbs.size(); i++) {
            collectTbMapper.update(collectTbs.get(i));
        }
    }

    public CollectTb getUniqueBy(CollectTb collectTb) {

        return collectTbMapper.getUniqueBy(collectTb);
    }
    public List<CollectTb> getConditionBy(CollectTb collectTb) {

        return collectTbMapper.getConditionBy(collectTb);
    }

    public List<CollectTb> getBy(CollectTb collectTb) {

        return collectTbMapper.getBy(collectTb);
    }

    public Integer count(CollectTb collectTb) {

        return collectTbMapper.count(collectTb);
    }

}
