package com.bootdo.BusinessManage.service;

import com.bootdo.BusinessManage.domain.RecommendDO;

import java.util.List;
import java.util.Map;

/**
 * 商家推荐表
 * 
 * @author xgg
 * @email 641352220@qq.com
 * @date 2018-01-05 10:03:25
 */
public interface RecommendService {
	
	RecommendDO get(Integer businessId);
	
	List<RecommendDO> list(Map<String, Object> map);
	
	int count(Map<String, Object> map);
	
	int save(RecommendDO recommend);
	
	int update(RecommendDO recommend);
	
	int remove(Integer businessId);
	
	int batchRemove(Integer[] businessIds);

	RecommendDO getByBusinessIdAndCarId(Integer businessId,Integer carId);
}
