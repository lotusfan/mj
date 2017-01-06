package com.mjapp.dao.transactionmanager;

import com.mjapp.dao.StoreCycleTbMapper;
import com.mjapp.model.StoreCycleTb;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StoreCycleTbTransactionManager {



    @Autowired
    private StoreCycleTbMapper storeCycleTbMapper;


    public void saveStoreCycleTb(StoreCycleTb storeCycleTb) {

        storeCycleTbMapper.save(storeCycleTb);
    }

    public void saveStoreCycleTbs(List<StoreCycleTb> storeCycleTbs) {

        if (storeCycleTbs == null) {
            return;
        }
        for (int i = 0; i < storeCycleTbs.size(); i++) {
            storeCycleTbMapper.save(storeCycleTbs.get(i));
        }
    }

    public void updateStoreCycleTb(StoreCycleTb storeCycleTb) {
        storeCycleTbMapper.update(storeCycleTb);

    }

    public void updateStoreCycleTbs(List<StoreCycleTb> storeCycleTbs) {
        if (storeCycleTbs == null) {
            return;
        }
        for (int i = 0; i < storeCycleTbs.size(); i++) {
            storeCycleTbMapper.update(storeCycleTbs.get(i));
        }
    }

    public StoreCycleTb getUniqueBy(StoreCycleTb storeCycleTb) {

        return storeCycleTbMapper.getUniqueBy(storeCycleTb);
    }
    public List<StoreCycleTb> getConditionBy(StoreCycleTb storeCycleTb) {

        return storeCycleTbMapper.getConditionBy(storeCycleTb);
    }

    public List<StoreCycleTb> getBy(StoreCycleTb storeCycleTb) {

        return storeCycleTbMapper.getBy(storeCycleTb);
    }

    public Integer count(StoreCycleTb storeCycleTb) {

        return storeCycleTbMapper.count(storeCycleTb);
    }

}
