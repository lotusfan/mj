package com.mjapp.action.dbaction;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import java.util.List;
import com.mjapp.dao.UserFeedbackTbMapper;
import com.mjapp.model.UserFeedbackTb;
@Controller
@RequestMapping(value = "/db/userFeedbackTb")
public class UserFeedbackTbActionDB {
	@Autowired
	private UserFeedbackTbMapper userFeedbackTbMapper;
	@RequestMapping(value = "save", method = {RequestMethod.POST,RequestMethod.GET})
	@ResponseBody
	public void savem (@RequestBody UserFeedbackTb userFeedbackTb) {
		userFeedbackTbMapper.save(userFeedbackTb);
	}
	@RequestMapping(value = "update", method = {RequestMethod.POST,RequestMethod.GET})
	@ResponseBody
	public void updatem (@RequestBody UserFeedbackTb userFeedbackTb) {
		if(userFeedbackTb.getId()==null){
			return;
		}
		userFeedbackTbMapper.update(userFeedbackTb);
	}
	@RequestMapping(value = "getBy", method = {RequestMethod.POST,RequestMethod.GET})
	@ResponseBody
	public ModelAndView getBym () {
		List<UserFeedbackTb> list = userFeedbackTbMapper.getBy(new UserFeedbackTb());
		ModelAndView mav = new ModelAndView("/jspdb/userFeedbackTb.jsp");
		mav.addObject("userFeedbackTb", list);
		return mav;
	}

}