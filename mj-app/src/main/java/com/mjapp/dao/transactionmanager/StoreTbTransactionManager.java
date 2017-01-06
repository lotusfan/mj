package com.mjapp.service.transactionmanager;

import com.mjapp.dao.StoreTbMapper;
import com.mjapp.model.StoreTb;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StoreTbTransactionManager {



    @Autowired
    private StoreTbMapper storeTbMapper;


    public void saveStoreTb(StoreTb storeTb) {

        storeTbMapper.save(storeTb);
    }

    public void saveStoreTbs(List<StoreTb> storeTbs) {

        if (storeTbs == null) {
            return;
        }
        for (int i = 0; i < storeTbs.size(); i++) {
            storeTbMapper.save(storeTbs.get(i));
        }
    }

    public void updateStoreTb(StoreTb storeTb) {
        storeTbMapper.update(storeTb);

    }

    public void updateStoreTbs(List<StoreTb> storeTbs) {
        if (storeTbs == null) {
            return;
        }
        for (int i = 0; i < storeTbs.size(); i++) {
            storeTbMapper.update(storeTbs.get(i));
        }
    }

    public StoreTb getUniqueBy(StoreTb storeTb) {

        return storeTbMapper.getUniqueBy(storeTb);
    }
    public List<StoreTb> getConditionBy(StoreTb storeTb) {

        return storeTbMapper.getConditionBy(storeTb);
    }

    public List<StoreTb> getBy(StoreTb storeTb) {

        return storeTbMapper.getBy(storeTb);
    }

    public Integer count(StoreTb storeTb) {

        return storeTbMapper.count(storeTb);
    }

}
