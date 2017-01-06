package com.mjapp.action.dbaction;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import java.util.List;
import com.mjapp.dao.CollectTbMapper;
import com.mjapp.model.CollectTb;
@Controller
@RequestMapping(value = "/db/collectTb")
public class CollectTbActionDB {
	@Autowired
	private CollectTbMapper collectTbMapper;
	@RequestMapping(value = "save", method = {RequestMethod.POST,RequestMethod.GET})
	@ResponseBody
	public void savem (@RequestBody CollectTb collectTb) {
		collectTbMapper.save(collectTb);
	}
	@RequestMapping(value = "update", method = {RequestMethod.POST,RequestMethod.GET})
	@ResponseBody
	public void updatem (@RequestBody CollectTb collectTb) {
		if(collectTb.getId()==null){
			return;
		}
		collectTbMapper.update(collectTb);
	}
	@RequestMapping(value = "getBy", method = {RequestMethod.POST,RequestMethod.GET})
	@ResponseBody
	public ModelAndView getBym () {
		List<CollectTb> list = collectTbMapper.getBy(new CollectTb());
		ModelAndView mav = new ModelAndView("/jspdb/collectTb.jsp");
		mav.addObject("collectTb", list);
		return mav;
	}

}