package com.gangling.service;

import junit.framework.TestCase;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * created by liufeng
 * 2018/9/6
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring-context.xml"})
public class RedisServiceTest extends TestCase {

    @Autowired
    private RedisService redisService;

    @Test
    public void testSaveInfo() {
        redisService.saveInfo();
    }

    @Test
    public void find(){
        Object obj=redisService.getInfo("username");
        System.out.println(obj);
    }
}