package com.gangling.dao;

import com.github.miemiedev.mybatis.paginator.domain.PageBounds;

import java.util.List;
import java.util.Map;

/**
 * created by liufeng
 * 2019/1/2
 */
public interface UsermanageEnterpriseMapper {

    List<Map<String,Object>> findAll();

    Map<String,Object> queryOne();

    List<Map<String,Object>> findByParam(Map<String,Object> param, PageBounds pageBounds);
}
