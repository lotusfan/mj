package com.mjapp.service.transactionmanager;

import com.mjapp.dao.UserTbMapper;
import com.mjapp.model.UserTb;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserTbTransactionManager {



    @Autowired
    private UserTbMapper userTbMapper;


    public void saveUserTb(UserTb userTb) {

        userTbMapper.save(userTb);
    }

    public void saveUserTbs(List<UserTb> userTbs) {

        if (userTbs == null) {
            return;
        }
        for (int i = 0; i < userTbs.size(); i++) {
            userTbMapper.save(userTbs.get(i));
        }
    }

    public void updateUserTb(UserTb userTb) {
        userTbMapper.update(userTb);

    }

    public void updateUserTbs(List<UserTb> userTbs) {
        if (userTbs == null) {
            return;
        }
        for (int i = 0; i < userTbs.size(); i++) {
            userTbMapper.update(userTbs.get(i));
        }
    }

    public UserTb getUniqueBy(UserTb userTb) {

        return userTbMapper.getUniqueBy(userTb);
    }
    public List<UserTb> getConditionBy(UserTb userTb) {

        return userTbMapper.getConditionBy(userTb);
    }

    public List<UserTb> getBy(UserTb userTb) {

        return userTbMapper.getBy(userTb);
    }

    public Integer count(UserTb userTb) {

        return userTbMapper.count(userTb);
    }

}
