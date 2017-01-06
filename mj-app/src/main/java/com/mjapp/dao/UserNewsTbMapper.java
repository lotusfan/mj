package com.mjapp.dao;
import com.mjapp.model.UserNewsTb;
import com.mjapp.model.view.UserView;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserNewsTbMapper{
	public void save (UserNewsTb userNewsTb);
	public void update (UserNewsTb userNewsTb);
	public List<UserNewsTb> getBy (UserNewsTb userNewsTb);
	public UserNewsTb getUniqueBy (UserNewsTb userNewsTb);
	public Integer count (UserNewsTb userNewsTb);
	public List<UserNewsTb> getConditionBy (UserNewsTb userNewsTb);

	List<UserNewsTb> getByIncludeUserView(UserNewsTb userNewsTb);

	List<UserView> getNewsUserViewConditionBy(UserNewsTb userNewsTb);

	UserNewsTb getUniqueByIncludeUserView(UserNewsTb userNewsTb);

	void updateSign(UserNewsTb userNewsTb);
}