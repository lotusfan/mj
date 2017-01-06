package com.mjapp.dao;
import com.mjapp.model.ActivityTb;
import com.mjapp.model.UserLifeLineTb;

import java.util.List;
public interface UserLifeLineTbMapper{
	public void save(UserLifeLineTb userLifeLineTb);
	public void update(UserLifeLineTb userLifeLineTb);
	public List<UserLifeLineTb> getBy(UserLifeLineTb userLifeLineTb);
	public UserLifeLineTb getUniqueBy(UserLifeLineTb userLifeLineTb);
	public Integer count(UserLifeLineTb userLifeLineTb);
	public List<UserLifeLineTb> getConditionBy(UserLifeLineTb userLifeLineTb);
	List<ActivityTb> getUserActivityLifeLineBy(UserLifeLineTb userLifeLineTb);

	void updateSign(UserLifeLineTb userLifeLineTb);
}