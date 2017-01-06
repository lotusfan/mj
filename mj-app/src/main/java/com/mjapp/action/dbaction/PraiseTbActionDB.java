package com.mjapp.action.dbaction;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import java.util.List;
import com.mjapp.dao.PraiseTbMapper;
import com.mjapp.model.PraiseTb;
@Controller
@RequestMapping(value = "/db/praiseTb")
public class PraiseTbActionDB {
	@Autowired
	private PraiseTbMapper praiseTbMapper;
	@RequestMapping(value = "save", method = {RequestMethod.POST,RequestMethod.GET})
	@ResponseBody
	public void savem (@RequestBody PraiseTb praiseTb) {
		praiseTbMapper.save(praiseTb);
	}
	@RequestMapping(value = "update", method = {RequestMethod.POST,RequestMethod.GET})
	@ResponseBody
	public void updatem (@RequestBody PraiseTb praiseTb) {
		if(praiseTb.getId()==null){
			return;
		}
		praiseTbMapper.update(praiseTb);
	}
	@RequestMapping(value = "getBy", method = {RequestMethod.POST,RequestMethod.GET})
	@ResponseBody
	public ModelAndView getBym () {
		List<PraiseTb> list = praiseTbMapper.getBy(new PraiseTb());
		ModelAndView mav = new ModelAndView("/jspdb/praiseTb.jsp");
		mav.addObject("praiseTb", list);
		return mav;
	}

}