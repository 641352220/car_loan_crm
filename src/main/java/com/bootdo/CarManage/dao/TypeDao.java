package com.bootdo.CarManage.dao;

import com.bootdo.CarManage.domain.TypeDO;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

/**
 * 汽车类型表
 * @author xgg
 * @email 641352220@qq.com
 * @date 2018-01-04 16:43:41
 */
@Mapper
public interface TypeDao {

	TypeDO get(Integer carTypeId);
	
	List<TypeDO> list(Map<String, Object> map);
	
	int count(Map<String, Object> map);
	
	int save(TypeDO type);
	
	int update(TypeDO type);
	
	int remove(Integer car_type_id);
	
	int batchRemove(Integer[] carTypeIds);

	List<TypeDO> nameList();
}
