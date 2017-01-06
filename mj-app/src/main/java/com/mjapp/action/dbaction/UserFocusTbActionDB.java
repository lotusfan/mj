package com.mjapp.action.dbaction;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import java.util.List;
import com.mjapp.dao.UserFocusTbMapper;
import com.mjapp.model.UserFocusTb;
@Controller
@RequestMapping(value = "/db/userFocusTb")
public class UserFocusTbActionDB {
	@Autowired
	private UserFocusTbMapper userFocusTbMapper;
	@RequestMapping(value = "save", method = {RequestMethod.POST,RequestMethod.GET})
	@ResponseBody
	public void savem (@RequestBody UserFocusTb userFocusTb) {
		userFocusTbMapper.save(userFocusTb);
	}
	@RequestMapping(value = "update", method = {RequestMethod.POST,RequestMethod.GET})
	@ResponseBody
	public void updatem (@RequestBody UserFocusTb userFocusTb) {
		if(userFocusTb.getId()==null){
			return;
		}
		userFocusTbMapper.update(userFocusTb);
	}
	@RequestMapping(value = "getBy", method = {RequestMethod.POST,RequestMethod.GET})
	@ResponseBody
	public ModelAndView getBym () {
		List<UserFocusTb> list = userFocusTbMapper.getBy(new UserFocusTb());
		ModelAndView mav = new ModelAndView("/jspdb/userFocusTb.jsp");
		mav.addObject("userFocusTb", list);
		return mav;
	}

}