package com.bootdo.AdverManage.service;

import com.bootdo.AdverManage.domain.AdverCarDO;

import java.util.List;
import java.util.Map;

/**
 * 爆款车辆
 * 
 * @author xgg
 * @email 641352220@qq.com
 * @date 2018-01-03 11:10:04
 */
public interface AdverCarService {
	
	AdverCarDO get(Integer adverCarId);
	
	List<AdverCarDO> list(Map<String, Object> map);
	
	int count(Map<String, Object> map);
	
	int save(AdverCarDO car);
	
	int update(AdverCarDO car);
	
	int remove(Integer adverCarId);
	
	int batchRemove(Integer[] adverCarIds);

	AdverCarDO getCarInfo(Integer adverCarId);
}
