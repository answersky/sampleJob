package com.gangling.service;

/**
 * created by liufeng
 * 2018/9/6
 */
public interface RedisService {

    void saveInfo();

    Object getInfo(String key);

    /**
     * 登录
     * @param key
     * @param value
     * @param expire
     */
    void login(String key,String value,Long expire);
}
