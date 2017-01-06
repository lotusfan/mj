package com.mjapp.action.dbaction;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import java.util.List;
import com.mjapp.dao.StoreTbMapper;
import com.mjapp.model.StoreTb;
@Controller
@RequestMapping(value = "/db/storeTb")
public class StoreTbActionDB {
	@Autowired
	private StoreTbMapper storeTbMapper;
	@RequestMapping(value = "save", method = {RequestMethod.POST,RequestMethod.GET})
	@ResponseBody
	public void savem (@RequestBody StoreTb storeTb) {
		storeTbMapper.save(storeTb);
	}
	@RequestMapping(value = "update", method = {RequestMethod.POST,RequestMethod.GET})
	@ResponseBody
	public void updatem (@RequestBody StoreTb storeTb) {
		if(storeTb.getId()==null){
			return;
		}
		storeTbMapper.update(storeTb);
	}
	@RequestMapping(value = "getBy", method = {RequestMethod.POST,RequestMethod.GET})
	@ResponseBody
	public ModelAndView getBym () {
		List<StoreTb> list = storeTbMapper.getBy(new StoreTb());
		ModelAndView mav = new ModelAndView("/jspdb/storeTb.jsp");
		mav.addObject("storeTb", list);
		return mav;
	}

}