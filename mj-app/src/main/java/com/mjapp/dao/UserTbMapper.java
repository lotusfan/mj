package com.mjapp.dao;
import com.mjapp.model.UserTb;
import com.mjapp.model.view.UserView;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserTbMapper{
	public void save (UserTb userTb);
	public void update (UserTb userTb);
	public void updateByLoginName (UserTb userTb);
	public List<UserTb> getBy (UserTb userTb);
	public UserTb getUniqueBy (UserTb userTb);
	public Integer count (UserTb userTb);
	public List<UserTb> getConditionBy (UserTb userTb);

	UserView getUniqueByUserView(UserTb userTb);

	List<UserView> getByUserView(UserTb userTb);
}