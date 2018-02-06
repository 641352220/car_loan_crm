package com.bootdo.AppManage.dao;

import com.bootdo.AppManage.domain.MarketingCarDO;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

/**
 * 首页营销关联汽车表
 * @author xgg
 * @email 641352220@qq.com
 * @date 2018-01-04 14:59:49
 */
@Mapper
public interface MarketingCarDao {

	MarketingCarDO get(Integer appMarketingCarId);
	
	List<MarketingCarDO> list(Map<String, Object> map);
	
	int count(Map<String, Object> map);
	
	int save(MarketingCarDO marketingCar);
	
	int update(MarketingCarDO marketingCar);
	
	int remove(Integer app_marketing_car_id);
	
	int batchRemove(Integer[] appMarketingCarIds);
}
