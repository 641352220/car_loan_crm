package com.bootdo.CarManage.service;

import com.bootdo.CarManage.domain.DetailsDO;

import java.util.List;
import java.util.Map;

/**
 * 汽车详情(很多字段的那个)
 * 
 * @author xgg
 * @email 641352220@qq.com
 * @date 2018-01-04 16:43:41
 */
public interface DetailsService {
	
	DetailsDO get(Integer carDetailsId);
	
	List<DetailsDO> list(Map<String, Object> map);
	
	int count(Map<String, Object> map);
	
	int save(DetailsDO details);
	
	int update(DetailsDO details);
	
	int remove(Integer carDetailsId);
	
	int batchRemove(Integer[] carDetailsIds);
}
