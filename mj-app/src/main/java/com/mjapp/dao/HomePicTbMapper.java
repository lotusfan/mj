package com.mjapp.dao;

import com.mjapp.model.HomePicTb;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface HomePicTbMapper{
	public void save(HomePicTb homePicTb);
	public void update(HomePicTb homePicTb);
	public List<HomePicTb> getBy(HomePicTb homePicTb);
	public HomePicTb getUniqueBy(HomePicTb homePicTb);
	public Integer count(HomePicTb homePicTb);
	public List<HomePicTb> getConditionBy(HomePicTb homePicTb);
}