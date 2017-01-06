package com.mjapp.action.dbaction;

import com.mjapp.dao.HomePicTbMapper;
import com.mjapp.model.HomePicTb;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping(value = "/db/homePicTb")
public class HomePicTbActionDB {
	@Autowired
	private HomePicTbMapper homePicTbMapper;
	@RequestMapping(value = "save", method = {RequestMethod.POST,RequestMethod.GET})
	@ResponseBody
	public void savem (@RequestBody HomePicTb homePicTb) {
		homePicTbMapper.save(homePicTb);
	}
	@RequestMapping(value = "update", method = {RequestMethod.POST,RequestMethod.GET})
	@ResponseBody
	public void updatem (@RequestBody HomePicTb homePicTb) {
		if(homePicTb.getId()==null){
			return;
		}
		homePicTbMapper.update(homePicTb);
	}
	@RequestMapping(value = "getBy", method = {RequestMethod.POST,RequestMethod.GET})
	@ResponseBody
	public ModelAndView getBym () {
		List<HomePicTb> list = homePicTbMapper.getBy(new HomePicTb());
		ModelAndView mav = new ModelAndView("/jspdb/homePicTb.jsp");
		mav.addObject("homePicTb", list);
		return mav;
	}

}