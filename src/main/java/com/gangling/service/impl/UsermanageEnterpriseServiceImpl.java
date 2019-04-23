package com.gangling.service.impl;

import com.gangling.dao.UsermanageEnterpriseMapper;
import com.gangling.service.UsermanageEnterpriseService;
import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.github.miemiedev.mybatis.paginator.domain.PageList;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * created by liufeng
 * 2019/1/11
 */
@Service(value = "usermanageEnterpriseService")
public class UsermanageEnterpriseServiceImpl implements UsermanageEnterpriseService {
    @Resource
    private UsermanageEnterpriseMapper usermanageEnterpriseMapper;

    @Override
    public Map<String, Object> queryOne() {
        return usermanageEnterpriseMapper.queryOne();
    }

    @Override
    public PageList<Map<String, Object>> page(Map<String, Object> param, PageBounds pageBounds) {
        return (PageList<Map<String, Object>>) usermanageEnterpriseMapper.findByParam(param,pageBounds);
    }
}
