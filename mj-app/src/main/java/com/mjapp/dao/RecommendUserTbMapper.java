package com.mjapp.dao;
import com.mjapp.model.RecommendUserTb;
import com.mjapp.model.view.UserView;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RecommendUserTbMapper{
	public void save (RecommendUserTb recommendUserTb);
	public void update (RecommendUserTb recommendUserTb);
	public List<RecommendUserTb> getBy (RecommendUserTb recommendUserTb);
	public RecommendUserTb getUniqueBy (RecommendUserTb recommendUserTb);
	public Integer count (RecommendUserTb recommendUserTb);
	public List<RecommendUserTb> getConditionBy (RecommendUserTb recommendUserTb);

	List<UserView> getUserViewBy(RecommendUserTb recommendUserTb);
}