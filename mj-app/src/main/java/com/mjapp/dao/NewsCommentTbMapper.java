package com.mjapp.dao;
import com.mjapp.model.NewsCommentTb;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NewsCommentTbMapper{
	public void save (NewsCommentTb newsCommentTb);
	public void update (NewsCommentTb newsCommentTb);
	public List<NewsCommentTb> getBy (NewsCommentTb newsCommentTb);
	public NewsCommentTb getUniqueBy (NewsCommentTb newsCommentTb);
	public Integer count (NewsCommentTb newsCommentTb);
	public List<NewsCommentTb> getConditionBy (NewsCommentTb newsCommentTb);

	List<NewsCommentTb> getConditionByIncludeUserView(NewsCommentTb newsCommentTb);

	void updateSign(NewsCommentTb newsCommentTb);

}