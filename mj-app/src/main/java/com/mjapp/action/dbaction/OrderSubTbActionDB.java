package com.mjapp.action.dbaction;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import java.util.List;
import com.mjapp.dao.OrderSubTbMapper;
import com.mjapp.model.OrderSubTb;
@Controller
@RequestMapping(value = "/db/orderSubTb")
public class OrderSubTbActionDB {
	@Autowired
	private OrderSubTbMapper orderSubTbMapper;
	@RequestMapping(value = "save", method = {RequestMethod.POST,RequestMethod.GET})
	@ResponseBody
	public void savem (@RequestBody OrderSubTb orderSubTb) {
		orderSubTbMapper.save(orderSubTb);
	}
	@RequestMapping(value = "update", method = {RequestMethod.POST,RequestMethod.GET})
	@ResponseBody
	public void updatem (@RequestBody OrderSubTb orderSubTb) {
		if(orderSubTb.getId()==null){
			return;
		}
		orderSubTbMapper.update(orderSubTb);
	}
	@RequestMapping(value = "getBy", method = {RequestMethod.POST,RequestMethod.GET})
	@ResponseBody
	public ModelAndView getBym () {
		List<OrderSubTb> list = orderSubTbMapper.getBy(new OrderSubTb());
		ModelAndView mav = new ModelAndView("/jspdb/orderSubTb.jsp");
		mav.addObject("orderSubTb", list);
		return mav;
	}

}