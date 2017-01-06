package com.mjapp.action.dbaction;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import java.util.List;
import com.mjapp.dao.OrderTbMapper;
import com.mjapp.model.OrderTb;
@Controller
@RequestMapping(value = "/db/orderTb")
public class OrderTbActionDB {
	@Autowired
	private OrderTbMapper orderTbMapper;
	@RequestMapping(value = "save", method = {RequestMethod.POST,RequestMethod.GET})
	@ResponseBody
	public void savem (@RequestBody OrderTb orderTb) {
		orderTbMapper.save(orderTb);
	}
	@RequestMapping(value = "update", method = {RequestMethod.POST,RequestMethod.GET})
	@ResponseBody
	public void updatem (@RequestBody OrderTb orderTb) {
		if(orderTb.getId()==null){
			return;
		}
		orderTbMapper.update(orderTb);
	}
	@RequestMapping(value = "getBy", method = {RequestMethod.POST,RequestMethod.GET})
	@ResponseBody
	public ModelAndView getBym () {
		List<OrderTb> list = orderTbMapper.getBy(new OrderTb());
		ModelAndView mav = new ModelAndView("/jspdb/orderTb.jsp");
		mav.addObject("orderTb", list);
		return mav;
	}

}