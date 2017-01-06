package com.mjapp.action.dbaction;

import com.mjapp.dao.UserLifeLineTbMapper;
import com.mjapp.model.UserLifeLineTb;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import java.util.List;
@Controller
@RequestMapping(value = "/db/userLifeLineTb")
public class UserLifeLineTbActionDB {
	@Autowired
	private UserLifeLineTbMapper userLifeLineTbMapper;
	@RequestMapping(value = "save", method = {RequestMethod.POST,RequestMethod.GET})
	@ResponseBody
	public void savem (@RequestBody UserLifeLineTb userLifeLineTb) {
		userLifeLineTbMapper.save(userLifeLineTb);
	}
	@RequestMapping(value = "update", method = {RequestMethod.POST,RequestMethod.GET})
	@ResponseBody
	public void updatem (@RequestBody UserLifeLineTb userLifeLineTb) {
		if(userLifeLineTb.getId()==null){
			return;
		}
		userLifeLineTbMapper.update(userLifeLineTb);
	}
	@RequestMapping(value = "getBy", method = {RequestMethod.POST,RequestMethod.GET})
	@ResponseBody
	public ModelAndView getBym () {
		List<UserLifeLineTb> list = userLifeLineTbMapper.getBy(new UserLifeLineTb());
		ModelAndView mav = new ModelAndView("/jspdb/userLifeLineTb.jsp");
		mav.addObject("userLifeLineTb", list);
		return mav;
	}

}