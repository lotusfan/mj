package com.mjapp.util;

import com.alibaba.fastjson.JSON;
import org.springframework.dao.DataAccessException;
import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.core.RedisCallback;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.RedisSerializer;

/**
 * @title: RedisCache
 * @description: Redis缓存基本方法
 * @author: zhangfan
 * @data: 2016年10月03日 20:44
 */
public class RedisCache {


    private static RedisTemplate redisTemplate;

    public static void setRedisTemplate(RedisTemplate rt) {
        redisTemplate = rt;
    }


    public static void putStr(String key, String value) {

        put(key, value);

    }

    public static void putObject(String key, Object o) {

        put(key, JSON.toJSONString(o));
    }


    public static String getStr(String key) {

        return get(key);
    }

    public static  <T> T getObject(String key, Class<T> c) {

        String str = getStr(key);
        return JSON.parseObject(str, c);

    }


    public static void put(final String key, final String value) {

        redisTemplate.execute(new RedisCallback() {
            @Override
            public Object doInRedis(RedisConnection redisConnection) throws DataAccessException {

                RedisSerializer<String> redisSerializer = redisTemplate.getStringSerializer();
                redisConnection.set(redisSerializer.serialize(key), redisSerializer.serialize(value));
                return null;
            }
        });
    }

    public static String get(final String key) {

        return (String) redisTemplate.execute(new RedisCallback() {
            @Override
            public Object doInRedis(RedisConnection redisConnection) throws DataAccessException {

                RedisSerializer<String> redisSerializer = redisTemplate.getStringSerializer();

                return redisSerializer.deserialize(redisConnection.get(redisSerializer.serialize(key)));
            }
        });

    }

}
