package com.mjapp.service.transactionmanager;

import com.mjapp.dao.NewsCommentTbMapper;
import com.mjapp.model.NewsCommentTb;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NewsCommentTbTransactionManager {



    @Autowired
    private NewsCommentTbMapper newsCommentTbMapper;


    public void saveNewsCommentTb(NewsCommentTb newsCommentTb) {

        newsCommentTbMapper.save(newsCommentTb);
    }

    public void saveNewsCommentTbs(List<NewsCommentTb> newsCommentTbs) {

        if (newsCommentTbs == null) {
            return;
        }
        for (int i = 0; i < newsCommentTbs.size(); i++) {
            newsCommentTbMapper.save(newsCommentTbs.get(i));
        }
    }

    public void updateNewsCommentTb(NewsCommentTb newsCommentTb) {
        newsCommentTbMapper.update(newsCommentTb);

    }

    public void updateNewsCommentTbs(List<NewsCommentTb> newsCommentTbs) {
        if (newsCommentTbs == null) {
            return;
        }
        for (int i = 0; i < newsCommentTbs.size(); i++) {
            newsCommentTbMapper.update(newsCommentTbs.get(i));
        }
    }

    public NewsCommentTb getUniqueBy(NewsCommentTb newsCommentTb) {

        return newsCommentTbMapper.getUniqueBy(newsCommentTb);
    }
    public List<NewsCommentTb> getConditionBy(NewsCommentTb newsCommentTb) {

        return newsCommentTbMapper.getConditionBy(newsCommentTb);
    }

    public List<NewsCommentTb> getBy(NewsCommentTb newsCommentTb) {

        return newsCommentTbMapper.getBy(newsCommentTb);
    }

    public Integer count(NewsCommentTb newsCommentTb) {

        return newsCommentTbMapper.count(newsCommentTb);
    }

}
