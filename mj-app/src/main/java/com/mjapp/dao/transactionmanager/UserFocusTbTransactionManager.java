package com.mjapp.service.transactionmanager;

import com.mjapp.dao.UserFocusTbMapper;
import com.mjapp.model.UserFocusTb;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserFocusTbTransactionManager {



    @Autowired
    private UserFocusTbMapper userFocusTbMapper;


    public void saveUserFocusTb(UserFocusTb userFocusTb) {

        userFocusTbMapper.save(userFocusTb);
    }

    public void saveUserFocusTbs(List<UserFocusTb> userFocusTbs) {

        if (userFocusTbs == null) {
            return;
        }
        for (int i = 0; i < userFocusTbs.size(); i++) {
            userFocusTbMapper.save(userFocusTbs.get(i));
        }
    }

    public void updateUserFocusTb(UserFocusTb userFocusTb) {
        userFocusTbMapper.update(userFocusTb);

    }

    public void updateUserFocusTbs(List<UserFocusTb> userFocusTbs) {
        if (userFocusTbs == null) {
            return;
        }
        for (int i = 0; i < userFocusTbs.size(); i++) {
            userFocusTbMapper.update(userFocusTbs.get(i));
        }
    }

    public UserFocusTb getUniqueBy(UserFocusTb userFocusTb) {

        return userFocusTbMapper.getUniqueBy(userFocusTb);
    }
    public List<UserFocusTb> getConditionBy(UserFocusTb userFocusTb) {

        return userFocusTbMapper.getConditionBy(userFocusTb);
    }

    public List<UserFocusTb> getBy(UserFocusTb userFocusTb) {

        return userFocusTbMapper.getBy(userFocusTb);
    }

    public Integer count(UserFocusTb userFocusTb) {

        return userFocusTbMapper.count(userFocusTb);
    }

}
