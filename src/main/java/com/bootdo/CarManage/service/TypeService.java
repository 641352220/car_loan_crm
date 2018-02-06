package com.bootdo.CarManage.service;

import com.bootdo.CarManage.domain.TypeDO;

import java.util.List;
import java.util.Map;

/**
 * 汽车类型表
 * 
 * @author xgg
 * @email 641352220@qq.com
 * @date 2018-01-04 16:43:41
 */
public interface TypeService {
	
	TypeDO get(Integer carTypeId);
	
	List<TypeDO> list(Map<String, Object> map);
	
	int count(Map<String, Object> map);
	
	int save(TypeDO type);
	
	int update(TypeDO type);
	
	int remove(Integer carTypeId);
	
	int batchRemove(Integer[] carTypeIds);

	List<TypeDO> nameList();
}
