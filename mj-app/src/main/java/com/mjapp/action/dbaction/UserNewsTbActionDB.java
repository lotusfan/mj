package com.mjapp.action.dbaction;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import java.util.List;
import com.mjapp.dao.UserNewsTbMapper;
import com.mjapp.model.UserNewsTb;
@Controller
@RequestMapping(value = "/db/userNewsTb")
public class UserNewsTbActionDB {
	@Autowired
	private UserNewsTbMapper userNewsTbMapper;
	@RequestMapping(value = "save", method = {RequestMethod.POST,RequestMethod.GET})
	@ResponseBody
	public void savem (@RequestBody UserNewsTb userNewsTb) {
		userNewsTbMapper.save(userNewsTb);
	}
	@RequestMapping(value = "update", method = {RequestMethod.POST,RequestMethod.GET})
	@ResponseBody
	public void updatem (@RequestBody UserNewsTb userNewsTb) {
		if(userNewsTb.getId()==null){
			return;
		}
		userNewsTbMapper.update(userNewsTb);
	}
	@RequestMapping(value = "getBy", method = {RequestMethod.POST,RequestMethod.GET})
	@ResponseBody
	public ModelAndView getBym () {
		List<UserNewsTb> list = userNewsTbMapper.getBy(new UserNewsTb());
		ModelAndView mav = new ModelAndView("/jspdb/userNewsTb.jsp");
		mav.addObject("userNewsTb", list);
		return mav;
	}

}