package com.mjapp.action.dbaction;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import java.util.List;
import com.mjapp.dao.GoodsTbMapper;
import com.mjapp.model.GoodsTb;
@Controller
@RequestMapping(value = "/db/goodsTb")
public class GoodsTbActionDB {
	@Autowired
	private GoodsTbMapper goodsTbMapper;
	@RequestMapping(value = "save", method = {RequestMethod.POST,RequestMethod.GET})
	@ResponseBody
	public void savem (@RequestBody GoodsTb goodsTb) {
		goodsTbMapper.save(goodsTb);
	}
	@RequestMapping(value = "update", method = {RequestMethod.POST,RequestMethod.GET})
	@ResponseBody
	public void updatem (@RequestBody GoodsTb goodsTb) {
		if(goodsTb.getId()==null){
			return;
		}
		goodsTbMapper.update(goodsTb);
	}
	@RequestMapping(value = "getBy", method = {RequestMethod.POST,RequestMethod.GET})
	@ResponseBody
	public ModelAndView getBym () {
		List<GoodsTb> list = goodsTbMapper.getBy(new GoodsTb());
		ModelAndView mav = new ModelAndView("/jspdb/goodsTb.jsp");
		mav.addObject("goodsTb", list);
		return mav;
	}

}