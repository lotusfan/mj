package com.mjapp.service.transactionmanager;

import com.mjapp.dao.UserFeedbackTbMapper;
import com.mjapp.model.UserFeedbackTb;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserFeedbackTbTransactionManager {



    @Autowired
    private UserFeedbackTbMapper userFeedbackTbMapper;


    public void saveUserFeedbackTb(UserFeedbackTb userFeedbackTb) {

        userFeedbackTbMapper.save(userFeedbackTb);
    }

    public void saveUserFeedbackTbs(List<UserFeedbackTb> userFeedbackTbs) {

        if (userFeedbackTbs == null) {
            return;
        }
        for (int i = 0; i < userFeedbackTbs.size(); i++) {
            userFeedbackTbMapper.save(userFeedbackTbs.get(i));
        }
    }

    public void updateUserFeedbackTb(UserFeedbackTb userFeedbackTb) {
        userFeedbackTbMapper.update(userFeedbackTb);

    }

    public void updateUserFeedbackTbs(List<UserFeedbackTb> userFeedbackTbs) {
        if (userFeedbackTbs == null) {
            return;
        }
        for (int i = 0; i < userFeedbackTbs.size(); i++) {
            userFeedbackTbMapper.update(userFeedbackTbs.get(i));
        }
    }

    public UserFeedbackTb getUniqueBy(UserFeedbackTb userFeedbackTb) {

        return userFeedbackTbMapper.getUniqueBy(userFeedbackTb);
    }
    public List<UserFeedbackTb> getConditionBy(UserFeedbackTb userFeedbackTb) {

        return userFeedbackTbMapper.getConditionBy(userFeedbackTb);
    }

    public List<UserFeedbackTb> getBy(UserFeedbackTb userFeedbackTb) {

        return userFeedbackTbMapper.getBy(userFeedbackTb);
    }

    public Integer count(UserFeedbackTb userFeedbackTb) {

        return userFeedbackTbMapper.count(userFeedbackTb);
    }

}
