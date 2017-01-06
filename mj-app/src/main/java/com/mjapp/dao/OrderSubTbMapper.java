package com.mjapp.dao;
import com.mjapp.model.OrderSubTb;
import java.util.List;
public interface OrderSubTbMapper{
	public void save(OrderSubTb orderSubTb);
	public void update(OrderSubTb orderSubTb);
	public List<OrderSubTb> getBy(OrderSubTb orderSubTb);
	public OrderSubTb getUniqueBy(OrderSubTb orderSubTb);
	public Integer count(OrderSubTb orderSubTb);
	public List<OrderSubTb> getConditionBy(OrderSubTb orderSubTb);
}