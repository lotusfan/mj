package com.mjapp.service;

import com.mjapp.dao.*;
import com.mjapp.model.*;
import com.mjapp.model.constant.LIFELINETYPE;
import com.mjapp.model.constant.UNIFYTYPE;
import com.mjapp.model.view.HomeQueryView;
import com.mjapp.model.view.JTaView;
import com.mjapp.model.view.UserView;
import com.mjapp.util.MjCodeUitl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @title: MJAdvancedSelectService
 * @description: MJ APP 高级复合查寻Service
 * @author: zhangfan
 * @data: 2016年10月11日 21:50
 */
@Service
public class MJAdvancedQueryService {

    @Autowired
    private UserTbMapper userTbMapper;
    @Autowired
    private UserFocusTbMapper userFocusTbMapper;
    @Autowired
    private ActivityTbMapper activityTbMapper;
    @Autowired
    private UserNewsTbMapper userNewsTbMapper;
    @Autowired
    private MJAdvanceQueryMapper mjAdvanceQueryMapper;
    @Autowired
    private UserBasicInfoService userBasicInfoService;

    /**
     * 首页搜索
     *
     * @param str
     * @return
     */
    public HomeQueryView homeQueryS(String str, Integer userId) {

        try {
            HomeQueryView homeQueryView = new HomeQueryView();

            UserTb userTb = new UserTb();
            //验证是否为用户ID号
            if (MjCodeUitl.validate(str)) {
                userTb.setMjCode(Integer.valueOf(str));
                homeQueryView.setUserViews(userTbMapper.getByUserView(userTb));
                return homeQueryView;
            }

            //按用户姓名 模糊查寻
            homeQueryView.setUserViews(mjAdvanceQueryMapper.queryUserLikeNickName(str));
            userBasicInfoService.setUserViewFocusFlag(homeQueryView.getUserViews(), userId);

            //按用户活动名称和活动发布人姓名 模糊查寻
            homeQueryView.setActivityTbs(mjAdvanceQueryMapper.queryActivityLikeUserNameAndLikeActivityName(str));

            return homeQueryView;
        } catch (NumberFormatException e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * 已登录用户推荐感兴趣的人(去除已关注用户)
     *
     * @param recommendUserTb
     * @return
     */
    public HomeQueryView homeRecommendS(RecommendUserTb recommendUserTb) {

        try {
            HomeQueryView homeQueryView = new HomeQueryView();

            homeQueryView.setUserViews(recommendUserListS(recommendUserTb));
            RecommendActivityTb recommendActivityTb = new RecommendActivityTb();
            recommendActivityTb.setPageNum(recommendUserTb.getPageNum());
            recommendActivityTb.setPages(recommendUserTb.getPages());
            homeQueryView.setActivityTbs(recommendActivityListS(recommendActivityTb));

            return homeQueryView;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * 推荐活动列表
     *
     * @param recommendActivityTb
     * @return
     */
    public List<ActivityTb> recommendActivityListS(RecommendActivityTb recommendActivityTb) {

        try {
            recommendActivityTb.setSkipNum((recommendActivityTb.getPages() - 1) * recommendActivityTb.getPageNum());

            return mjAdvanceQueryMapper.queryRecommendActivity(recommendActivityTb);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

    }

    /**
     * 推荐用户列表
     *
     * @param recommendUserTb
     * @return
     */
    public List<UserView> recommendUserListS(RecommendUserTb recommendUserTb) {

        try {
            recommendUserTb.setSkipNum((recommendUserTb.getPages() - 1) * recommendUserTb.getPageNum());
            List<UserView> list = mjAdvanceQueryMapper.queryRecommendUser(recommendUserTb);
            userBasicInfoService.setUserViewFocusFlag(list, recommendUserTb.getUserId());

            return list;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * 见Ta导航返回
     *
     * @param userLifeLineTb
     * @return
     */
    public List<JTaView> jTaS(UserLifeLineTb userLifeLineTb) {

        try {
            userLifeLineTb.setSkipNum((userLifeLineTb.getPages() - 1) * userLifeLineTb.getPageNum());

            //获取关注用户的Ids
            UserFocusTb userFocusTb = new UserFocusTb();
            userFocusTb.setActiveUserId(userLifeLineTb.getUserId());
            userFocusTb.setDeleteFlag(UNIFYTYPE.DELETE.NOT);
            List<Integer> focusUserIds = userFocusTbMapper.getFocusUserIdByactiveUserId(userFocusTb);
            if(focusUserIds == null || focusUserIds.size() < 1) return null;

            userLifeLineTb.setDeleteFlag(UNIFYTYPE.DELETE.NOT);
            userLifeLineTb.setIds(focusUserIds);
            List<UserLifeLineTb> userLifeLineTbs = mjAdvanceQueryMapper.queryUserLifeByUserIds(userLifeLineTb);

            if(userLifeLineTbs == null || userLifeLineTbs.size() < 1) return null;

            List<JTaView> list = new ArrayList<>();
            for (UserLifeLineTb ull : userLifeLineTbs) {

                JTaView jTaView = new JTaView();

                if (ull.getType1().equals(LIFELINETYPE.ACTIVITY)) {

                    ActivityTb activityTb = new ActivityTb();
                    activityTb.setId(ull.getRelationId());
                    jTaView.setType(LIFELINETYPE.ACTIVITY);
                    jTaView.setActivityTb(activityTbMapper.getUniqueBy(activityTb));
                }
                if (ull.getType1().equals(LIFELINETYPE.NEWS)) {

                    UserNewsTb userNewsTb = new UserNewsTb();
                    userNewsTb.setId(ull.getRelationId());
                    userNewsTb = userNewsTbMapper.getUniqueByIncludeUserView(userNewsTb);
                    if (userNewsTb.getForwardFlag() == UNIFYTYPE.FORWARD.YES) {
                        UserNewsTb unt = new UserNewsTb();
                        unt.setId(userNewsTb.getForwardNewsId());
                        userNewsTb.setForwardUserNewsTb(userNewsTbMapper.getUniqueByIncludeUserView(unt));
                    }
                    jTaView.setType(LIFELINETYPE.NEWS);
                    jTaView.setUserNewsTb(userNewsTb);
                }
                list.add(jTaView);
            }

            return list;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * 未登录用户推荐感兴趣的人
     *
     * @return
     */
//    public HomeQueryView homeRecommendNotLoginedS() {
//        return null;
//    }


    /**
     * 去除UserViews中  focusList
     *
     * @param userViews
     * @param userFocusTbs
     * @return
     */
//    public List<UserView> removeUserFocus(List<UserView> userViews, List<UserFocusTb> userFocusTbs) {
//
//        List<UserView> uvs = new ArrayList<>();
//
//        for (UserView uv : userViews) {
//            boolean flag = false;
//            for (UserFocusTb uf : userFocusTbs) {
//
//                if (uv.getId().equals(uf.getPassiveUserId())) {
//                    flag = true;
//                    break;
//                }
//            }
//            if (!flag) {
//                uvs.add(uv);
//            }
//        }
//
//        return uvs;
//    }


}
