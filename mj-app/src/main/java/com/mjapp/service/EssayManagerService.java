package com.mjapp.service;

import com.alibaba.fastjson.JSON;
import com.mjapp.dao.NewsCommentTbMapper;
import com.mjapp.dao.PraiseTbMapper;
import com.mjapp.dao.UserNewsTbMapper;
import com.mjapp.dao.UserTbMapper;
import com.mjapp.model.NewsCommentTb;
import com.mjapp.model.PraiseTb;
import com.mjapp.model.UserNewsTb;
import com.mjapp.model.constant.SERVICECODE;
import com.mjapp.model.constant.UNIFYTYPE;
import com.mjapp.model.view.PicView;
import com.mjapp.model.view.UserView;
import com.mjapp.util.PicOlineUrl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @title: EssayManagerService
 * @description: 用户动态相关Service
 * @author: zhangfan
 * @data: 2016年10月11日 21:22
 */

@Service
public class EssayManagerService {

    @Autowired
    private PraiseTbMapper praiseTbMapper;
    @Autowired
    private NewsCommentTbMapper newsCommentTbMapper;
    @Autowired
    private PicFileServiceI picFileService;
    @Autowired
    private UserNewsTbMapper userNewsTbMapper;
    @Autowired
    private UserLifeLineService userLifeLineService;


    /**
     * 用户为动态点赞
     *
     * @param praiseTb
     * @return
     */
    public SERVICECODE praiseNewsS(PraiseTb praiseTb) {

        try {
            PraiseTb praiseTbDB = praiseTbMapper.getUniqueBy(praiseTb);

            if (praiseTbDB == null) {
                praiseTb.setDeleteFlag(UNIFYTYPE.DELETE.NOT);
                praiseTbMapper.save(praiseTb);
                return SERVICECODE.UPDATESUCCESS;

            }
            PraiseTb pt = new PraiseTb();
            pt.setId(praiseTbDB.getId());
            if (UNIFYTYPE.DELETE.YES == praiseTbDB.getDeleteFlag()) {
                pt.setDeleteFlag(UNIFYTYPE.DELETE.NOT);
            }
            if (UNIFYTYPE.DELETE.NOT == praiseTbDB.getDeleteFlag()) {
                pt.setDeleteFlag(UNIFYTYPE.DELETE.YES);
            }
            praiseTbMapper.update(pt);

            return SERVICECODE.UPDATESUCCESS;
        } catch (Exception e) {
            e.printStackTrace();
            return SERVICECODE.UPDATEERROR;
        }

    }

    /**
     * 用户取消动态的点赞   已弃用
     *
     * @param praiseTb
     * @return
     */
    public SERVICECODE canclePraiseNewsS(PraiseTb praiseTb) {
        try {
            praiseTb.setDeleteFlag(UNIFYTYPE.DELETE.YES);
            praiseTbMapper.updateBy(praiseTb);
            return SERVICECODE.UPDATESUCCESS;
        } catch (Exception e) {
            e.printStackTrace();
            return SERVICECODE.UPDATEERROR;
        }
    }


    /**
     * 用户为动态评论
     *
     * @param newsCommentTb
     * @return
     */
    public SERVICECODE commentNewsS(NewsCommentTb newsCommentTb) {

        try {
            newsCommentTb.setDeleteFlag(UNIFYTYPE.DELETE.NOT);
            newsCommentTbMapper.save(newsCommentTb);
            return SERVICECODE.INSERTSUCCESS;
        } catch (Exception e) {
            e.printStackTrace();
            return SERVICECODE.INSERTERROR;
        }
    }

    /**
     * 用户发表动态
     *
     * @param userNewsTb
     * @return
     */
    public SERVICECODE addNewsS(UserNewsTb userNewsTb) {

        try {
            if (userNewsTb.getPicJsonArray() != null) {
                List picList = new ArrayList();
                List<PicView> viewList = new ArrayList<>();

                for (int i = 0; i < userNewsTb.getPicJsonArray().size(); i++) {

                    String fileName = System.currentTimeMillis() + "-" + i;
                    PicView picView = new PicView();
                    picView.setName(fileName);
                    picView.setPicBase64Str(userNewsTb.getPicJsonArray().getString(i));

                    picList.add(PicOlineUrl.transform(fileName));
                    viewList.add(picView);
                }
                userNewsTb.setPicJson(JSON.toJSONString(picList));
                picFileService.savePic(viewList);
            }

            userNewsTb.setForwardFlag(UNIFYTYPE.FORWARD.NOT);
            userNewsTb.setDeleteFlag(UNIFYTYPE.DELETE.NOT);
            userNewsTbMapper.save(userNewsTb);

            //添加轨迹
            userLifeLineService.addUserNewsLifeLine(userNewsTb.getUserId(), userNewsTb.getId());

            return SERVICECODE.INSERTSUCCESS;
        } catch (Exception e) {
            e.printStackTrace();
            return SERVICECODE.INSERTERROR;
        }
    }


    /**
     * 用户转发动态
     *
     * @param userNewsTb
     * @return
     */
    public SERVICECODE forwardNewsS(UserNewsTb userNewsTb) {

        try {
            userNewsTb.setForwardFlag(UNIFYTYPE.FORWARD.YES);
            userNewsTb.setDeleteFlag(UNIFYTYPE.DELETE.NOT);
            userNewsTbMapper.save(userNewsTb);

            //添加轨迹
            userLifeLineService.addUserNewsForwardLifeLine(userNewsTb.getUserId(), userNewsTb.getId());
            return SERVICECODE.INSERTSUCCESS;
        } catch (Exception e) {
            e.printStackTrace();
            return SERVICECODE.INSERTERROR;
        }
    }

    /**
     * 用户动态列表
     *
     * @param userNewsTb
     * @return
     */
    public List<UserNewsTb> userNewsListS(UserNewsTb userNewsTb) {


        try {
            userNewsTb.setDeleteFlag(UNIFYTYPE.DELETE.NOT);
            userNewsTb.setSkipNum((userNewsTb.getPages() - 1) * userNewsTb.getPageNum());
            userNewsTb.setSequence1("create_time");
            userNewsTb.setSequence1Type("desc");
            List<UserNewsTb> userNewsTbs = userNewsTbMapper.getByIncludeUserView(userNewsTb);
            if (userNewsTbs == null || userNewsTbs.size() < 1) return null;

            for (UserNewsTb unt : userNewsTbs) {

                //添加转发动态详情
                if (unt.getForwardFlag() == UNIFYTYPE.FORWARD.YES) {

                    UserNewsTb funt = new UserNewsTb();
                    funt.setId(unt.getForwardNewsId());
                    unt.setForwardUserNewsTb(userNewsTbMapper.getByIncludeUserView(funt).get(0));
                }

                //获取点赞数
                unt.setPraiseNum(getNewsPraiseNum(unt.getId()));

                //获取评论数
                int commentNum = getNewsCommentNum(unt.getId());
                unt.setCommentNum(commentNum);
            }

            return userNewsTbs;
        } catch (NumberFormatException e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * 用户动态详情
     *
     * @param userNewsTb
     * @return
     */
    public UserNewsTb detailNewsS(UserNewsTb userNewsTb) {


        try {
            UserNewsTb unt = new UserNewsTb();
            unt.setId(userNewsTb.getId());
            unt.setUserId(userNewsTb.getUserId());
            unt.setDeleteFlag(UNIFYTYPE.DELETE.NOT);

            List<UserNewsTb> list = userNewsTbMapper.getByIncludeUserView(unt);
            if (list == null || list.size() < 1) return null;
            unt = list.get(0);

            //添加转发动态详情
            if (unt.getForwardFlag() == UNIFYTYPE.FORWARD.YES) {
                UserNewsTb funt = new UserNewsTb();
                funt.setId(unt.getForwardNewsId());
                unt.setForwardUserNewsTb(userNewsTbMapper.getByIncludeUserView(funt).get(0));
            }

            //添加点赞数
            unt.setPraiseNum(getNewsPraiseNum(unt.getId()));
            //添加点赞用户列表
            if (unt.getPraiseNum() > 0)
                unt.setPraiseUserViews(getNewsPraiseUserViewList(unt.getId()));

            //添加转发数
            unt.setForwardNum(getNewsForwardNum(unt.getId()));
            //添加转发用户的动态列表
            if (unt.getForwardNum() > 0)
                unt.setForwardUserNewss(getNewsForwardList(unt.getId()));

            //添加评论数
            unt.setCommentNum(getNewsCommentNum(unt.getId()));
            //添加评论列表
            if (unt.getCommentNum() > 0)
                unt.setNewsCommentTbs(getNewsCommentList(unt.getId()));

            return unt;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }


    /**
     * 获取动态点赞数
     *
     * @param newsId
     * @return
     */
    public int getNewsPraiseNum(Integer newsId) {
        PraiseTb praiseTb = new PraiseTb();
        praiseTb.setDeleteFlag(UNIFYTYPE.DELETE.NOT);
        praiseTb.setNewsId(newsId);
        return praiseTbMapper.count(praiseTb);
    }

    /**
     * 获取动态点赞用户的列表
     *
     * @param newsId
     * @return
     */
    public List<UserView> getNewsPraiseUserViewList(Integer newsId) {

        PraiseTb praiseTb = new PraiseTb();
        praiseTb.setNewsId(newsId);
        praiseTb.setDeleteFlag(UNIFYTYPE.DELETE.NOT);
        praiseTb.setSequence1("id");
        praiseTb.setSequence1Type("desc");
        return praiseTbMapper.getPraiseUserViewConditionBy(praiseTb);
    }


    /**
     * 获取动态评论数
     *
     * @param newsId
     * @return
     */
    public int getNewsCommentNum(Integer newsId) {

        NewsCommentTb newsCommentTb = new NewsCommentTb();
        newsCommentTb.setDeleteFlag(UNIFYTYPE.DELETE.NOT);
        newsCommentTb.setNewsId(newsId);
        return newsCommentTbMapper.count(newsCommentTb);
    }

    /**
     * 获取动态评论列表
     *
     * @param newsId
     * @return
     */
    public List<NewsCommentTb> getNewsCommentList(Integer newsId) {

        NewsCommentTb newsCommentTb = new NewsCommentTb();
        newsCommentTb.setDeleteFlag(UNIFYTYPE.DELETE.NOT);
        newsCommentTb.setNewsId(newsId);
        newsCommentTb.setSequence1("id");
        newsCommentTb.setSequence1Type("desc");
        return newsCommentTbMapper.getConditionByIncludeUserView(newsCommentTb);
    }

    /**
     * 获取动态被转发数
     *
     * @param newsId
     * @return
     */
    public int getNewsForwardNum(Integer newsId) {

        UserNewsTb userNewsTb = new UserNewsTb();
        userNewsTb.setForwardNewsId(newsId);
        userNewsTb.setForwardFlag(UNIFYTYPE.FORWARD.YES);
        userNewsTb.setDeleteFlag(UNIFYTYPE.DELETE.NOT);

        return userNewsTbMapper.count(userNewsTb);
    }

    /**
     * 获取动态被转发用户列表
     *
     * @param newsId
     * @return
     */
    public List<UserView> getNewsForwardUserViewList(Integer newsId) {

        UserNewsTb userNewsTb = new UserNewsTb();
        userNewsTb.setForwardNewsId(newsId);
        userNewsTb.setForwardFlag(UNIFYTYPE.FORWARD.YES);
        userNewsTb.setDeleteFlag(UNIFYTYPE.DELETE.NOT);
        userNewsTb.setSequence1("id");
        userNewsTb.setSequence1Type("desc");

        return userNewsTbMapper.getNewsUserViewConditionBy(userNewsTb);
    }

    /**
     * 获取被转发动态列表
     *
     * @param newsId
     * @return
     */
    public List<UserNewsTb> getNewsForwardList(Integer newsId) {
        UserNewsTb userNewsTb = new UserNewsTb();
        userNewsTb.setForwardNewsId(newsId);
        userNewsTb.setForwardFlag(UNIFYTYPE.FORWARD.YES);
        userNewsTb.setDeleteFlag(UNIFYTYPE.DELETE.NOT);
        userNewsTb.setSequence1("id");
        userNewsTb.setSequence1Type("desc");

        return userNewsTbMapper.getByIncludeUserView(userNewsTb);
    }

    /**
     * 用户删除动态
     *
     * @param userNewsTb
     * @return
     */
    public SERVICECODE deleteNewsS(UserNewsTb userNewsTb) {

        try {
            UserNewsTb unt = new UserNewsTb();
            unt.setUserId(userNewsTb.getUserId());
            unt.setId(userNewsTb.getId());
            unt.setDeleteFlag(UNIFYTYPE.DELETE.YES);

            userNewsTbMapper.updateSign(unt);

            //删除用户动态的轨迹
            userLifeLineService.deleteUserNewsForwardLifeLine(unt.getUserId(), unt.getId());

            return SERVICECODE.UPDATESUCCESS;
        } catch (Exception e) {
            e.printStackTrace();
            return SERVICECODE.UPDATEERROR;
        }
    }

    /**
     * 删除动态评论
     *
     * @param newsCommentTb
     * @return
     */
    public SERVICECODE deleteCommentNewsS(NewsCommentTb newsCommentTb) {
        try {
            NewsCommentTb nct = new NewsCommentTb();
            nct.setDeleteFlag(UNIFYTYPE.DELETE.YES);
            nct.setUserId(newsCommentTb.getUserId());
            nct.setId(newsCommentTb.getId());

            newsCommentTbMapper.updateSign(nct);
            return SERVICECODE.UPDATESUCCESS;
        } catch (Exception e) {
            e.printStackTrace();
            return SERVICECODE.UPDATEERROR;
        }
    }

}
