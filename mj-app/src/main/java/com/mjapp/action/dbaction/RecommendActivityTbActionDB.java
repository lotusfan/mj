package com.mjapp.action.dbaction;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import java.util.List;
import com.mjapp.dao.RecommendActivityTbMapper;
import com.mjapp.model.RecommendActivityTb;
@Controller
@RequestMapping(value = "/db/recommendActivityTb")
public class RecommendActivityTbActionDB {
	@Autowired
	private RecommendActivityTbMapper recommendActivityTbMapper;
	@RequestMapping(value = "save", method = {RequestMethod.POST,RequestMethod.GET})
	@ResponseBody
	public void savem (@RequestBody RecommendActivityTb recommendActivityTb) {
		recommendActivityTbMapper.save(recommendActivityTb);
	}
	@RequestMapping(value = "update", method = {RequestMethod.POST,RequestMethod.GET})
	@ResponseBody
	public void updatem (@RequestBody RecommendActivityTb recommendActivityTb) {
		if(recommendActivityTb.getId()==null){
			return;
		}
		recommendActivityTbMapper.update(recommendActivityTb);
	}
	@RequestMapping(value = "getBy", method = {RequestMethod.POST,RequestMethod.GET})
	@ResponseBody
	public ModelAndView getBym () {
		List<RecommendActivityTb> list = recommendActivityTbMapper.getBy(new RecommendActivityTb());
		ModelAndView mav = new ModelAndView("/jspdb/recommendActivityTb.jsp");
		mav.addObject("recommendActivityTb", list);
		return mav;
	}

}