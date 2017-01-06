package com.mjapp.action.dbaction;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import java.util.List;
import com.mjapp.dao.RecommendUserTbMapper;
import com.mjapp.model.RecommendUserTb;
@Controller
@RequestMapping(value = "/db/recommendUserTb")
public class RecommendUserTbActionDB {
	@Autowired
	private RecommendUserTbMapper recommendUserTbMapper;
	@RequestMapping(value = "save", method = {RequestMethod.POST,RequestMethod.GET})
	@ResponseBody
	public void savem (@RequestBody RecommendUserTb recommendUserTb) {
		recommendUserTbMapper.save(recommendUserTb);
	}
	@RequestMapping(value = "update", method = {RequestMethod.POST,RequestMethod.GET})
	@ResponseBody
	public void updatem (@RequestBody RecommendUserTb recommendUserTb) {
		if(recommendUserTb.getId()==null){
			return;
		}
		recommendUserTbMapper.update(recommendUserTb);
	}
	@RequestMapping(value = "getBy", method = {RequestMethod.POST,RequestMethod.GET})
	@ResponseBody
	public ModelAndView getBym () {
		List<RecommendUserTb> list = recommendUserTbMapper.getBy(new RecommendUserTb());
		ModelAndView mav = new ModelAndView("/jspdb/recommendUserTb.jsp");
		mav.addObject("recommendUserTb", list);
		return mav;
	}

}