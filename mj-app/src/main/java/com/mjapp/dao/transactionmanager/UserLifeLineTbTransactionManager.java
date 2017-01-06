package com.mjapp.dao.transactionmanager;


import com.mjapp.dao.UserLifeLineTbMapper;
import com.mjapp.model.UserLifeLineTb;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserLifeLineTbTransactionManager {



    @Autowired
    private UserLifeLineTbMapper userLifeLineTbMapper;


    public void saveUserLifeLineTb(UserLifeLineTb userLifeLineTb) {

        userLifeLineTbMapper.save(userLifeLineTb);
    }

    public void saveUserLifeLineTbs(List<UserLifeLineTb> userLifeLineTbs) {

        if (userLifeLineTbs == null) {
            return;
        }
        for (int i = 0; i < userLifeLineTbs.size(); i++) {
            userLifeLineTbMapper.save(userLifeLineTbs.get(i));
        }
    }

    public void updateUserLifeLineTb(UserLifeLineTb userLifeLineTb) {
        userLifeLineTbMapper.update(userLifeLineTb);

    }

    public void updateUserLifeLineTbs(List<UserLifeLineTb> userLifeLineTbs) {
        if (userLifeLineTbs == null) {
            return;
        }
        for (int i = 0; i < userLifeLineTbs.size(); i++) {
            userLifeLineTbMapper.update(userLifeLineTbs.get(i));
        }
    }

    public UserLifeLineTb getUniqueBy(UserLifeLineTb userLifeLineTb) {

        return userLifeLineTbMapper.getUniqueBy(userLifeLineTb);
    }
    public List<UserLifeLineTb> getConditionBy(UserLifeLineTb userLifeLineTb) {

        return userLifeLineTbMapper.getConditionBy(userLifeLineTb);
    }

    public List<UserLifeLineTb> getBy(UserLifeLineTb userLifeLineTb) {

        return userLifeLineTbMapper.getBy(userLifeLineTb);
    }

    public Integer count(UserLifeLineTb userLifeLineTb) {

        return userLifeLineTbMapper.count(userLifeLineTb);
    }

}
