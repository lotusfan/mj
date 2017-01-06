package com.mjapp.dao;

import com.mjapp.model.ActivityTb;
import com.mjapp.model.RecommendActivityTb;
import com.mjapp.model.RecommendUserTb;
import com.mjapp.model.UserLifeLineTb;
import com.mjapp.model.view.UserView;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @title: MJAdvanceQueryMapper
 * @description: mj 多关键字复杂查寻
 * @author: zhangfan
 * @data: 2016年10月23日 21:31
 */
@Repository
public interface MJAdvanceQueryMapper {

    List<UserView> queryUserLikeNickName(String str);

    List<ActivityTb> queryActivityLikeUserNameAndLikeActivityName(String str);

    List<UserView> queryRecommendUser(RecommendUserTb recommendUserTb);

    List<ActivityTb> queryRecommendActivity(RecommendActivityTb recommendActivityTb);

    List<UserLifeLineTb> queryUserLifeByUserIds(UserLifeLineTb userLifeLineTb);
}
