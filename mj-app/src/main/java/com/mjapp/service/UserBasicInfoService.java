package com.mjapp.service;

import com.mjapp.dao.*;
import com.mjapp.model.*;
import com.mjapp.model.constant.SERVICECODE;
import com.mjapp.model.constant.UNIFYTYPE;
import com.mjapp.model.view.UserView;
import com.mjapp.util.Base64PicUtils;
import com.mjapp.util.Base64Utils;
import com.mjapp.util.PROPERTIESUTIL;
import com.mjapp.util.PicOlineUrl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @title: UserService
 * @description: 用户相关Service
 * @author: zhangfan
 * @data: 2016年10月08日 20:29
 */
@Service
public class UserBasicInfoService {

    @Autowired
    private UserTbMapper userTbMapper;

    @Autowired
    private UserFocusTbMapper userFocusTbMapper;


    /**
     * 用户个人信息修改成功
     *
     * @param userTb
     * @return
     */
    public SERVICECODE updateUserS(UserTb userTb) {

        try {
            userTbMapper.update(userTb);
            return SERVICECODE.UPDATESUCCESS;
        } catch (Exception e) {
            e.printStackTrace();
            return SERVICECODE.UPDATEERROR;
        }

    }


    /**
     * 用户更换头像
     *
     * @param picStr
     * @return
     */
    public SERVICECODE updateUserHeadPicS(int id, String picStr) {


        try {
            String fileName = System.currentTimeMillis() + PROPERTIESUTIL.get("head_pic_name_suffix");
            Base64PicUtils.savePicFile(picStr, fileName, PROPERTIESUTIL.get("head_pic_url"));

            UserTb userTb = new UserTb();
            userTb.setId(id);
            userTb.setHeadPic(PicOlineUrl.transform(fileName));
            userTbMapper.update(userTb);

            return SERVICECODE.UPDATESUCCESS;
        } catch (Exception e) {
            e.printStackTrace();
            return SERVICECODE.UPDATEERROR;
        }

    }

    /**
     * 用户更换背景图片
     *
     * @param picStr
     * @return
     */
    public SERVICECODE updateUserBackgroundPicS(int id, String picStr) {


        try {
            String fileName = System.currentTimeMillis() + PROPERTIESUTIL.get("background_pic_name_suffix");
            Base64PicUtils.savePicFile(picStr, fileName, PROPERTIESUTIL.get("background_pic_url"));

            UserTb userTb = new UserTb();
            userTb.setId(id);
            userTb.setBackgroundPic(PicOlineUrl.transform(fileName));
            userTbMapper.update(userTb);

            return SERVICECODE.UPDATESUCCESS;
        } catch (Exception e) {
            e.printStackTrace();
            return SERVICECODE.UPDATEERROR;
        }

    }


    /**
     * 关注他人
     *
     * @param userFocusTb
     * @return
     */
    public SERVICECODE focusUserS(UserFocusTb userFocusTb) {

        try {

            UserFocusTb userFocusTbDB = userFocusTbMapper.getUniqueBy(userFocusTb);
            if (userFocusTbDB == null) {
                userFocusTb.setDeleteFlag(UNIFYTYPE.DELETE.NOT);
                userFocusTbMapper.save(userFocusTb);
                return SERVICECODE.INSERTSUCCESS;
            }

            UserFocusTb uf = new UserFocusTb();
            uf.setId(userFocusTbDB.getId());
            if (UNIFYTYPE.DELETE.YES == userFocusTbDB.getDeleteFlag()) {
                uf.setDeleteFlag(UNIFYTYPE.DELETE.NOT);
            }
            if (UNIFYTYPE.DELETE.NOT == userFocusTbDB.getDeleteFlag()) {
                uf.setDeleteFlag(UNIFYTYPE.DELETE.YES);
            }

            userFocusTbMapper.update(uf);
            return SERVICECODE.INSERTSUCCESS;
        } catch (Exception e) {
            e.printStackTrace();
            return SERVICECODE.INSERTERROR;
        }
    }


    /**
     * 获取粉丝列表
     *
     * @param userFocusTb
     * @return
     */
    public List<UserView> fansListS(UserFocusTb userFocusTb) {

        try {
            userFocusTb.setDeleteFlag(UNIFYTYPE.DELETE.YES);

            List<UserView> list = userFocusTbMapper.getFocusUserViewBy(userFocusTb);
            setUserViewFocusFlag(list, userFocusTb.getPassiveUserId());
            return list;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

    }

    /**
     * 获取关注的人列表
     *
     * @param userFocusTb
     * @return
     */
    public List<UserView> focusListS(UserFocusTb userFocusTb) {

        try {
            userFocusTb.setDeleteFlag(UNIFYTYPE.FOCUS.ON);
            userFocusTb.setSkipNum((userFocusTb.getPages() - 1) * userFocusTb.getPageNum());
            List<UserView> list = userFocusTbMapper.getFocusedUserViewBy(userFocusTb);
            for (UserView uv : list) { //将关注状态置为已关注
                uv.setFocusFlag(UNIFYTYPE.FOCUS.ON);
            }

            return list;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * 取消关注某人  已弃用,   和关注接口 合为一个
     *
     * @param userFocusTb
     * @return
     */
    public SERVICECODE cancelFocusUserS(UserFocusTb userFocusTb) {
        try {
            userFocusTb.setDeleteFlag(UNIFYTYPE.FOCUS.OFF);
            userFocusTbMapper.update(userFocusTb);
            return SERVICECODE.INSERTSUCCESS;
        } catch (Exception e) {
            e.printStackTrace();
            return SERVICECODE.INSERTERROR;
        }
    }

    /**
     * 获取用户简介
     *
     * @param userTb
     * @return
     */
    public UserView getUserViewS(UserTb userTb) {

        try {
            UserTb ut = new UserTb();
            ut.setId(userTb.getId());
            UserView uv = userTbMapper.getUniqueByUserView(ut);

            UserFocusTb userFocusTb = new UserFocusTb();
            userFocusTb.setActiveUserId(uv.getId());
            uv.setFocusedNum(userFocusTbMapper.count(userFocusTb));
            userFocusTb.setActiveUserId(null);
            userFocusTb.setPassiveUserId(uv.getId());
            uv.setFansNum(userFocusTbMapper.count(userFocusTb));
            setUserViewFocusFlag(uv, userTb.getId());

            return uv;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * 注入  用户列表 和 请求者的 关注状态
     *
     * @param list
     * @param relUserId
     */
    public void setUserViewFocusFlag(List<UserView> list, Integer relUserId) {

        for (UserView uv : list) {
            setUserViewFocusFlag(uv, relUserId);
        }

    }

    public void setUserViewFocusFlag(UserView uv, Integer relUserId) {

        if (relUserId == null) {
            uv.setFocusFlag(UNIFYTYPE.FOCUS.OFF);
            return;
        }
        UserFocusTb userFocusTb = new UserFocusTb();
        userFocusTb.setActiveUserId(relUserId);
        userFocusTb.setPassiveUserId(uv.getId());
        if (userFocusTbMapper.count(userFocusTb) > 0) {
            uv.setFocusFlag(UNIFYTYPE.FOCUS.ON);
        }else {
            uv.setFocusFlag(UNIFYTYPE.FOCUS.OFF);
        }

    }

}





















