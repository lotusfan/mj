package com.mjapp.cache;

import com.mjapp.model.UserTb;
import com.mjapp.util.RedisCache;

/**
 * @title: LoginCache
 * @description: 用户登录cache
 * @author: zhangfan
 * @data: 2016年10月04日 14:34
 */
public class LoginCache {

    static final String type = "user-";


    public static void put(String token, UserTb userTb) {
        RedisCache.putObject(type + token, userTb);
    }

    public static UserTb get(String token) {

        return RedisCache.getObject(type + token, UserTb.class);
    }

}
