package com.gangling.service.impl;

import com.gangling.service.RedisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

/**
 * created by liufeng
 * 2018/9/6
 */
@Service
public class RedisServiceImpl implements RedisService {

    @Autowired
    private RedisTemplate redisTemplate;

    @Override
    public void saveInfo() {
        redisTemplate.opsForValue().set("username","answer",600,TimeUnit.SECONDS);
    }

    @Override
    public Object getInfo(String key) {
        return redisTemplate.opsForValue().get(key);
    }

    @Override
    public void login(String key, String value, Long expire) {
        //将登录信息保存n小时 key：sessionId
        redisTemplate.opsForValue().set(key,value,expire,TimeUnit.HOURS);
    }
}
