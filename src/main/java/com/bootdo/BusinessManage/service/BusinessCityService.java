package com.bootdo.BusinessManage.service;

import com.bootdo.BusinessManage.domain.BusinessCityDO;

import java.util.List;
import java.util.Map;

/**
 * 商家城市关联表
 * 
 * @author xgg
 * @email 641352220@qq.com
 * @date 2018-01-05 10:03:25
 */
public interface BusinessCityService {
	
	BusinessCityDO get(Integer businessId);
	
	List<BusinessCityDO> list(Map<String, Object> map);
	
	int count(Map<String, Object> map);
	
	int save(BusinessCityDO city);
	
	int update(BusinessCityDO city);
	
	int remove(Integer businessId);
	
	int batchRemove(Integer[] businessIds);

	BusinessCityDO getByBusinessIdAndCityId(Integer businessId, Integer cityId);
}
