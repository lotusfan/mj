package com.mjapp.dao;

import com.mjapp.model.UserFocusTb;
import com.mjapp.model.view.UserView;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserFocusTbMapper {
    public void save(UserFocusTb userFocusTb);

    public void update(UserFocusTb userFocusTb);

    public List<UserFocusTb> getBy(UserFocusTb userFocusTb);

    public UserFocusTb getUniqueBy(UserFocusTb userFocusTb);

    public Integer count(UserFocusTb userFocusTb);

    public List<UserFocusTb> getConditionBy(UserFocusTb userFocusTb);

    List<UserView> getFocusUserViewBy(UserFocusTb userFocusTb);

    List<UserView> getFocusedUserViewBy(UserFocusTb userFocusTb);

    List<Integer> getFocusUserIdByactiveUserId(UserFocusTb userFocusTb);
}