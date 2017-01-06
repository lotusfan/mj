package com.mjapp.service.transactionmanager;

import com.mjapp.dao.PraiseTbMapper;
import com.mjapp.model.PraiseTb;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PraiseTbTransactionManager {



    @Autowired
    private PraiseTbMapper praiseTbMapper;


    public void savePraiseTb(PraiseTb praiseTb) {

        praiseTbMapper.save(praiseTb);
    }

    public void savePraiseTbs(List<PraiseTb> praiseTbs) {

        if (praiseTbs == null) {
            return;
        }
        for (int i = 0; i < praiseTbs.size(); i++) {
            praiseTbMapper.save(praiseTbs.get(i));
        }
    }

    public void updatePraiseTb(PraiseTb praiseTb) {
        praiseTbMapper.update(praiseTb);

    }

    public void updatePraiseTbs(List<PraiseTb> praiseTbs) {
        if (praiseTbs == null) {
            return;
        }
        for (int i = 0; i < praiseTbs.size(); i++) {
            praiseTbMapper.update(praiseTbs.get(i));
        }
    }

    public PraiseTb getUniqueBy(PraiseTb praiseTb) {

        return praiseTbMapper.getUniqueBy(praiseTb);
    }
    public List<PraiseTb> getConditionBy(PraiseTb praiseTb) {

        return praiseTbMapper.getConditionBy(praiseTb);
    }

    public List<PraiseTb> getBy(PraiseTb praiseTb) {

        return praiseTbMapper.getBy(praiseTb);
    }

    public Integer count(PraiseTb praiseTb) {

        return praiseTbMapper.count(praiseTb);
    }

}
