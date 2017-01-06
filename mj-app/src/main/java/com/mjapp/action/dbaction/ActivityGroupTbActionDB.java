package com.mjapp.action.dbaction;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import java.util.List;
import com.mjapp.dao.ActivityGroupTbMapper;
import com.mjapp.model.ActivityGroupTb;
@Controller
@RequestMapping(value = "/db/activityGroupTb")
public class ActivityGroupTbActionDB {
	@Autowired
	private ActivityGroupTbMapper activityGroupTbMapper;
	@RequestMapping(value = "save", method = {RequestMethod.POST,RequestMethod.GET})
	@ResponseBody
	public void savem (@RequestBody ActivityGroupTb activityGroupTb) {
		activityGroupTbMapper.save(activityGroupTb);
	}
	@RequestMapping(value = "update", method = {RequestMethod.POST,RequestMethod.GET})
	@ResponseBody
	public void updatem (@RequestBody ActivityGroupTb activityGroupTb) {
		if(activityGroupTb.getId()==null){
			return;
		}
		activityGroupTbMapper.update(activityGroupTb);
	}
	@RequestMapping(value = "getBy", method = {RequestMethod.POST,RequestMethod.GET})
	@ResponseBody
	public ModelAndView getBym () {
		List<ActivityGroupTb> list = activityGroupTbMapper.getBy(new ActivityGroupTb());
		ModelAndView mav = new ModelAndView("/jspdb/activityGroupTb.jsp");
		mav.addObject("activityGroupTb", list);
		return mav;
	}

}