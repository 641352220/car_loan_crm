package com.bootdo.CarManage.service;

import com.bootdo.CarManage.domain.TypeRelationDO;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * 汽车类型关联表
 * 
 * @author xgg
 * @email 641352220@qq.com
 * @date 2018-01-04 16:43:41
 */
public interface TypeRelationService {
	
	TypeRelationDO get(@Param("carId") Integer carId,@Param("carTypeId") Integer carTypeId);
	
	List<TypeRelationDO> list(Map<String, Object> map);
	
	int count(Map<String, Object> map);
	
	int save(TypeRelationDO typeRelation);
	
	int update(TypeRelationDO typeRelation);
	
	int remove(Integer carId);
	
	int batchRemove(Integer[] carIds);
}
