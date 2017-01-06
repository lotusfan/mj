package com.mjapp.cache;

import com.mjapp.dao.RecommendUserTbMapper;
import com.mjapp.model.RecommendUserTb;
import com.mjapp.model.constant.UNIFYTYPE;
import com.mjapp.model.view.UserView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @title: UserRecommendCache
 * @description: 推荐用户 缓存
 * @author: zhangfan
 * @data: 2016年10月29日 16:24
 */
@Component
public class UserRecommendCache implements DataCacheI<UserView>{


    @Autowired
    private RecommendUserTbMapper recommendUserTbMapper;


    @Override
    public void init() {

    }

    @Override
    public List<UserView> getAllList() {
        RecommendUserTb recommendUserTb = new RecommendUserTb();
        recommendUserTb.setDeleteFlag(UNIFYTYPE.DELETE.NOT);

        return recommendUserTbMapper.getUserViewBy(recommendUserTb);
    }

    @Override
    public boolean remove(UserView userView) {
        return false;
    }

    @Override
    public boolean refresh() {
        return false;
    }
}
