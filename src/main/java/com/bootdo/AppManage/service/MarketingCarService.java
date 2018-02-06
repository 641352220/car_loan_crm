package com.bootdo.AppManage.service;

import com.bootdo.AppManage.domain.MarketingCarDO;

import java.util.List;
import java.util.Map;

/**
 * 首页营销关联汽车表
 * 
 * @author xgg
 * @email 641352220@qq.com
 * @date 2018-01-04 14:59:49
 */
public interface MarketingCarService {
	
	MarketingCarDO get(Integer appMarketingCarId);
	
	List<MarketingCarDO> list(Map<String, Object> map);
	
	int count(Map<String, Object> map);
	
	int save(MarketingCarDO marketingCar);
	
	int update(MarketingCarDO marketingCar);
	
	int remove(Integer appMarketingCarId);
	
	int batchRemove(Integer[] appMarketingCarIds);
}
