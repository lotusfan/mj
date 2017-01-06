package com.mjapp.dao;
import com.mjapp.model.StoreTb;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface StoreTbMapper{
	public void save (StoreTb storeTb);
	public void update (StoreTb storeTb);
	public List<StoreTb> getBy (StoreTb storeTb);
	public StoreTb getUniqueBy (StoreTb storeTb);
	public Integer count (StoreTb storeTb);
	public List<StoreTb> getConditionBy (StoreTb storeTb);

	List<StoreTb> storeListByCycle(StoreTb storeTb);
}