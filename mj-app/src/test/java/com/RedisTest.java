package com;

import com.alibaba.fastjson.JSON;
import com.mjapp.cache.LoginCache;
import com.mjapp.model.UserTb;
import com.mjapp.util.RedisCache;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.omg.PortableInterceptor.LOCATION_FORWARD;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.core.RedisCallback;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @title: RedisTest
 * @description: Redis测试
 * @author: zhangfan
 * @data: 2016年10月03日 16:52
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:applicationContext.xml")
public class RedisTest {

    @Autowired
    private RedisTemplate redisTemplate;

    @Test
    public void redistest() {

        redisTemplate.execute(new RedisCallback() {
            @Override
            public Object doInRedis(RedisConnection redisConnection) throws DataAccessException {
                byte[] key = "zhangfan1".getBytes();
                byte[] value = "1111111".getBytes();

                RedisSerializer<String> serializer = redisTemplate.getStringSerializer();
                UserTb userTb = new UserTb();
                userTb.setLoginName("wosdkjfkdjf");

                redisConnection.set(key, serializer.serialize(JSON.toJSONString(userTb)));
                return null;
            }
        });
    }


    @Test
    public void utilRedis() {
        RedisCache.put("xiaofan", "33333");

        System.out.println(RedisCache.get("xiaofan"));
    }


    @Test
    public void loginCache() {
        UserTb userTb = new UserTb();
        userTb.setLoginName("zhangfan");
        LoginCache.put("123456", userTb );


        System.out.println(LoginCache.get("123456"));
    }

}
