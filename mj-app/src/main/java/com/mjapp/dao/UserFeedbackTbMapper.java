package com.mjapp.dao;
import com.mjapp.model.UserFeedbackTb;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface UserFeedbackTbMapper{
	public void save (UserFeedbackTb userFeedbackTb);
	public void update (UserFeedbackTb userFeedbackTb);
	public List<UserFeedbackTb> getBy (UserFeedbackTb userFeedbackTb);
	public UserFeedbackTb getUniqueBy (UserFeedbackTb userFeedbackTb);
	public Integer count (UserFeedbackTb userFeedbackTb);
	public List<UserFeedbackTb> getConditionBy (UserFeedbackTb userFeedbackTb);
}