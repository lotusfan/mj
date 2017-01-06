package com.mjapp.service.transactionmanager;

import com.mjapp.dao.GoodsTbMapper;
import com.mjapp.model.GoodsTb;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GoodsTbTransactionManager {



    @Autowired
    private GoodsTbMapper goodsTbMapper;


    public void saveGoodsTb(GoodsTb goodsTb) {

        goodsTbMapper.save(goodsTb);
    }

    public void saveGoodsTbs(List<GoodsTb> goodsTbs) {

        if (goodsTbs == null) {
            return;
        }
        for (int i = 0; i < goodsTbs.size(); i++) {
            goodsTbMapper.save(goodsTbs.get(i));
        }
    }

    public void updateGoodsTb(GoodsTb goodsTb) {
        goodsTbMapper.update(goodsTb);

    }

    public void updateGoodsTbs(List<GoodsTb> goodsTbs) {
        if (goodsTbs == null) {
            return;
        }
        for (int i = 0; i < goodsTbs.size(); i++) {
            goodsTbMapper.update(goodsTbs.get(i));
        }
    }

    public GoodsTb getUniqueBy(GoodsTb goodsTb) {

        return goodsTbMapper.getUniqueBy(goodsTb);
    }
    public List<GoodsTb> getConditionBy(GoodsTb goodsTb) {

        return goodsTbMapper.getConditionBy(goodsTb);
    }

    public List<GoodsTb> getBy(GoodsTb goodsTb) {

        return goodsTbMapper.getBy(goodsTb);
    }

    public Integer count(GoodsTb goodsTb) {

        return goodsTbMapper.count(goodsTb);
    }

}
