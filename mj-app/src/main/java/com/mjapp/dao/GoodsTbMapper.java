package com.mjapp.dao;
import com.mjapp.model.GoodsTb;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface GoodsTbMapper{
	public void save (GoodsTb goodsTb);
	public void update (GoodsTb goodsTb);
	public List<GoodsTb> getBy (GoodsTb goodsTb);
	public GoodsTb getUniqueBy (GoodsTb goodsTb);
	public Integer count (GoodsTb goodsTb);
	public List<GoodsTb> getConditionBy (GoodsTb goodsTb);
}