package com.gangling.service.impl;

import com.gangling.service.SqlSessionService;
import org.apache.ibatis.cursor.Cursor;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.Map;

/**
 * created by liufeng
 * 2019/1/2
 */
@Service
public class SqlSessionServiceImpl implements SqlSessionService {
    @Resource
    private SqlSessionTemplate sqlSession;

    @Transactional(rollbackFor = Exception.class)
    @Override
    public void selectTest() {
        Cursor<Map<String,String>> dataCursor=sqlSession.selectCursor("com.gangling.dao.UsermanageEnterpriseMapper.queryOne");
        for (Map<String, String> data : dataCursor) {
            System.out.println(data.get("enterprise_name"));
        }

    }
}
