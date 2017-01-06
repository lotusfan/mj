package com.mjapp.action.dbaction;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import java.util.List;
import com.mjapp.dao.UserTbMapper;
import com.mjapp.model.UserTb;
@Controller
@RequestMapping(value = "/db/userTb")
public class UserTbActionDB {
	@Autowired
	private UserTbMapper userTbMapper;
	@RequestMapping(value = "save", method = {RequestMethod.POST,RequestMethod.GET})
	@ResponseBody
	public void savem (@RequestBody UserTb userTb) {
		userTbMapper.save(userTb);
	}
	@RequestMapping(value = "update", method = {RequestMethod.POST,RequestMethod.GET})
	@ResponseBody
	public void updatem (@RequestBody UserTb userTb) {
		if(userTb.getId()==null){
			return;
		}
		userTbMapper.update(userTb);
	}
	@RequestMapping(value = "getBy", method = {RequestMethod.POST,RequestMethod.GET})
	@ResponseBody
	public ModelAndView getBym () {
		List<UserTb> list = userTbMapper.getBy(new UserTb());
		ModelAndView mav = new ModelAndView("/jspdb/userTb.jsp");
		mav.addObject("userTb", list);
		return mav;
	}

}