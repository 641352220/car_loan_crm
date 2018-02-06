package com.bootdo.AppManage.service;

import com.bootdo.AppManage.domain.HomePageModeDO;

import java.util.List;
import java.util.Map;

/**
 * 模块表
 * 
 * @author xgg
 * @email 641352220@qq.com
 * @date 2018-01-04 14:59:49
 */
public interface HomePageModeService {
	
	HomePageModeDO get(Integer homePageModeId);
	
	List<HomePageModeDO> list(Map<String, Object> map);
	
	int count(Map<String, Object> map);
	
	int save(HomePageModeDO homePageMode);
	
	int update(HomePageModeDO homePageMode);
	
	int remove(Integer homePageModeId);
	
	int batchRemove(Integer[] homePageModeIds);
}
