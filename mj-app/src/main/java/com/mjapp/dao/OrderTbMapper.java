package com.mjapp.dao;
import com.mjapp.model.OrderTb;
import java.util.List;
public interface OrderTbMapper{
	public void save(OrderTb orderTb);
	public void update(OrderTb orderTb);
	public List<OrderTb> getBy(OrderTb orderTb);
	public OrderTb getUniqueBy(OrderTb orderTb);
	public Integer count(OrderTb orderTb);
	public List<OrderTb> getConditionBy(OrderTb orderTb);
}