package com.gangling.service;

import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.github.miemiedev.mybatis.paginator.domain.PageList;

import java.util.List;
import java.util.Map;

/**
 * created by liufeng
 * 2019/1/2
 */
public interface UsermanageEnterpriseService {

   Map<String,Object> queryOne();

    PageList<Map<String,Object>> page(Map<String,Object> param, PageBounds pageBounds);
}
