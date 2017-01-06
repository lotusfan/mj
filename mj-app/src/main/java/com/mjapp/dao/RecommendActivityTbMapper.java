package com.mjapp.dao;
import com.mjapp.model.RecommendActivityTb;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RecommendActivityTbMapper{
	public void save (RecommendActivityTb recommendActivityTb);
	public void update (RecommendActivityTb recommendActivityTb);
	public List<RecommendActivityTb> getBy (RecommendActivityTb recommendActivityTb);
	public RecommendActivityTb getUniqueBy (RecommendActivityTb recommendActivityTb);
	public Integer count (RecommendActivityTb recommendActivityTb);
	public List<RecommendActivityTb> getConditionBy (RecommendActivityTb recommendActivityTb);
}