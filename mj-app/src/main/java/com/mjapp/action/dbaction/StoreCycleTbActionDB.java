package com.mjapp.action.dbaction;

import com.mjapp.dao.StoreCycleTbMapper;
import com.mjapp.model.StoreCycleTb;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import java.util.List;
@Controller
@RequestMapping(value = "/db/storeCycleTb")
public class StoreCycleTbActionDB {
	@Autowired
	private StoreCycleTbMapper storeCycleTbMapper;
	@RequestMapping(value = "save", method = {RequestMethod.POST,RequestMethod.GET})
	@ResponseBody
	public void savem (@RequestBody StoreCycleTb storeCycleTb) {
		storeCycleTbMapper.save(storeCycleTb);
	}
	@RequestMapping(value = "update", method = {RequestMethod.POST,RequestMethod.GET})
	@ResponseBody
	public void updatem (@RequestBody StoreCycleTb storeCycleTb) {
		if(storeCycleTb.getId()==null){
			return;
		}
		storeCycleTbMapper.update(storeCycleTb);
	}
	@RequestMapping(value = "getBy", method = {RequestMethod.POST,RequestMethod.GET})
	@ResponseBody
	public ModelAndView getBym () {
		List<StoreCycleTb> list = storeCycleTbMapper.getBy(new StoreCycleTb());
		ModelAndView mav = new ModelAndView("/jspdb/storeCycleTb.jsp");
		mav.addObject("storeCycleTb", list);
		return mav;
	}

}