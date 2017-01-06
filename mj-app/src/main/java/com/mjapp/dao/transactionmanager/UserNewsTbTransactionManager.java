package com.mjapp.service.transactionmanager;

import com.mjapp.dao.UserNewsTbMapper;
import com.mjapp.model.UserNewsTb;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserNewsTbTransactionManager {



    @Autowired
    private UserNewsTbMapper userNewsTbMapper;


    public void saveUserNewsTb(UserNewsTb userNewsTb) {

        userNewsTbMapper.save(userNewsTb);
    }

    public void saveUserNewsTbs(List<UserNewsTb> userNewsTbs) {

        if (userNewsTbs == null) {
            return;
        }
        for (int i = 0; i < userNewsTbs.size(); i++) {
            userNewsTbMapper.save(userNewsTbs.get(i));
        }
    }

    public void updateUserNewsTb(UserNewsTb userNewsTb) {
        userNewsTbMapper.update(userNewsTb);

    }

    public void updateUserNewsTbs(List<UserNewsTb> userNewsTbs) {
        if (userNewsTbs == null) {
            return;
        }
        for (int i = 0; i < userNewsTbs.size(); i++) {
            userNewsTbMapper.update(userNewsTbs.get(i));
        }
    }

    public UserNewsTb getUniqueBy(UserNewsTb userNewsTb) {

        return userNewsTbMapper.getUniqueBy(userNewsTb);
    }
    public List<UserNewsTb> getConditionBy(UserNewsTb userNewsTb) {

        return userNewsTbMapper.getConditionBy(userNewsTb);
    }

    public List<UserNewsTb> getBy(UserNewsTb userNewsTb) {

        return userNewsTbMapper.getBy(userNewsTb);
    }

    public Integer count(UserNewsTb userNewsTb) {

        return userNewsTbMapper.count(userNewsTb);
    }

}
