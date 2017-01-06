package com.mjapp.dao;


import com.mjapp.model.StoreCycleTb;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface StoreCycleTbMapper{
	public void save (StoreCycleTb storeCycleTb);
	public void update (StoreCycleTb storeCycleTb);
	public List<StoreCycleTb> getBy (StoreCycleTb storeCycleTb);
	public StoreCycleTb getUniqueBy (StoreCycleTb storeCycleTb);
	public Integer count (StoreCycleTb storeCycleTb);
	public List<StoreCycleTb> getConditionBy (StoreCycleTb storeCycleTb);
}