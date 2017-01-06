package com.mjapp.action.dbaction;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import java.util.List;
import com.mjapp.dao.ActivityTbMapper;
import com.mjapp.model.ActivityTb;
@Controller
@RequestMapping(value = "/db/activityTb")
public class ActivityTbActionDB {
	@Autowired
	private ActivityTbMapper activityTbMapper;
	@RequestMapping(value = "save", method = {RequestMethod.POST,RequestMethod.GET})
	@ResponseBody
	public void savem (@RequestBody ActivityTb activityTb) {
		activityTbMapper.save(activityTb);
	}
	@RequestMapping(value = "update", method = {RequestMethod.POST,RequestMethod.GET})
	@ResponseBody
	public void updatem (@RequestBody ActivityTb activityTb) {
		if(activityTb.getId()==null){
			return;
		}
		activityTbMapper.update(activityTb);
	}
	@RequestMapping(value = "getBy", method = {RequestMethod.POST,RequestMethod.GET})
	@ResponseBody
	public ModelAndView getBym () {
		List<ActivityTb> list = activityTbMapper.getBy(new ActivityTb());
		ModelAndView mav = new ModelAndView("/jspdb/activityTb.jsp");
		mav.addObject("activityTb", list);
		return mav;
	}

}