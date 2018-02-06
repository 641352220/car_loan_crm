package com.bootdo.AppManage.dao;

import com.bootdo.AppManage.domain.HomePageModeDO;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

/**
 * 模块表
 * @author xgg
 * @email 641352220@qq.com
 * @date 2018-01-04 14:59:49
 */
@Mapper
public interface HomePageModeDao {

	HomePageModeDO get(Integer homePageModeId);
	
	List<HomePageModeDO> list(Map<String, Object> map);
	
	int count(Map<String, Object> map);
	
	int save(HomePageModeDO homePageMode);
	
	int update(HomePageModeDO homePageMode);
	
	int remove(Integer home_page_mode_id);
	
	int batchRemove(Integer[] homePageModeIds);
}
