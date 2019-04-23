package com.gangling.service;

import com.alibaba.dubbo.common.json.JSON;
import com.gangling.model.Page;
import com.github.miemiedev.mybatis.paginator.domain.Order;
import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.github.miemiedev.mybatis.paginator.domain.PageList;
import junit.framework.TestCase;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * created by liufeng
 * 2019/1/11
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring-context.xml"})
public class UsermanageEnterpriseServiceTest extends TestCase {
    @Resource
    private UsermanageEnterpriseService usermanageEnterpriseService;

    @Test
    public void testQueryOne() {
        Map<String,Object> map=usermanageEnterpriseService.queryOne();
        System.out.println(map);
    }

    @Test
    public void findByPage() throws IOException {
        PageBounds pb = new PageBounds(8, 10,Order.formString("create_time.desc"));
        PageList<Map<String,Object>> pageList=usermanageEnterpriseService.page(new LinkedHashMap<String, Object>(),pb);
        Page page= Page.page(pageList);
        System.out.println(JSON.json(pageList));
        System.out.println(JSON.json(page));
    }
}