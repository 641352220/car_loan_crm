package com.bootdo.BusinessManage.service;

import com.bootdo.BusinessManage.domain.BusinessCarDO;

import java.util.List;
import java.util.Map;

/**
 * 商家支持的汽车(经销商)
 * 
 * @author xgg
 * @email 641352220@qq.com
 * @date 2018-01-05 10:03:25
 */
public interface BusinessCarService {
	
	BusinessCarDO get(Integer businessId);
	
	List<BusinessCarDO> list(Map<String, Object> map);
	
	int count(Map<String, Object> map);
	
	int save(BusinessCarDO car);
	
	int update(BusinessCarDO car);
	
	int remove(Integer businessId);
	
	int batchRemove(Integer[] businessIds);
}
