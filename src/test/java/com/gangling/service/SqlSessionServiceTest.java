package com.gangling.service;

import junit.framework.TestCase;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

/**
 * created by liufeng
 * 2019/1/2
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring-context.xml"})
public class SqlSessionServiceTest extends TestCase {
    @Resource
    private SqlSessionService sqlSessionService;

    @Test
    public void testTestFind() {
        sqlSessionService.selectTest();
    }

    @Test
    public void testDemo(){
        char ch=getChar();
        System.out.println(String.valueOf(ch));
    }

    private char getChar(){
        long s=System.currentTimeMillis();
        char cha=0;
        String A="q1yw5er23tdd";
        char[] chars=A.toCharArray();
        for(int i=0;i<chars.length;i++){
            char ch=chars[i];
            for(int j=0;j<chars.length;j++){
                char chr=chars[j];
                if(i!=j&&ch==chr){
                    long s1=System.currentTimeMillis();
                    System.out.println("花费的时间："+(s1-s));
                    return ch;
                }
            }
        }
        return cha;
    }
}