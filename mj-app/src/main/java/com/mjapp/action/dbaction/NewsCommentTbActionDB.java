package com.mjapp.action.dbaction;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import java.util.List;
import com.mjapp.dao.NewsCommentTbMapper;
import com.mjapp.model.NewsCommentTb;
@Controller
@RequestMapping(value = "/db/newsCommentTb")
public class NewsCommentTbActionDB {
	@Autowired
	private NewsCommentTbMapper newsCommentTbMapper;
	@RequestMapping(value = "save", method = {RequestMethod.POST,RequestMethod.GET})
	@ResponseBody
	public void savem (@RequestBody NewsCommentTb newsCommentTb) {
		newsCommentTbMapper.save(newsCommentTb);
	}
	@RequestMapping(value = "update", method = {RequestMethod.POST,RequestMethod.GET})
	@ResponseBody
	public void updatem (@RequestBody NewsCommentTb newsCommentTb) {
		if(newsCommentTb.getId()==null){
			return;
		}
		newsCommentTbMapper.update(newsCommentTb);
	}
	@RequestMapping(value = "getBy", method = {RequestMethod.POST,RequestMethod.GET})
	@ResponseBody
	public ModelAndView getBym () {
		List<NewsCommentTb> list = newsCommentTbMapper.getBy(new NewsCommentTb());
		ModelAndView mav = new ModelAndView("/jspdb/newsCommentTb.jsp");
		mav.addObject("newsCommentTb", list);
		return mav;
	}

}