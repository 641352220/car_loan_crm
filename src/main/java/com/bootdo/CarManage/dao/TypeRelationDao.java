package com.bootdo.CarManage.dao;

import com.bootdo.CarManage.domain.TypeRelationDO;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * 汽车类型关联表
 * @author xgg
 * @email 641352220@qq.com
 * @date 2018-01-04 16:43:41
 */
@Mapper
public interface TypeRelationDao {

	TypeRelationDO get(@Param("carId") Integer carId,@Param("carTypeId") Integer carTypeId);
	
	List<TypeRelationDO> list(Map<String, Object> map);
	
	int count(Map<String, Object> map);
	
	int save(TypeRelationDO typeRelation);
	
	int update(TypeRelationDO typeRelation);
	
	int remove(Integer car_id);
	
	int batchRemove(Integer[] carIds);
}
