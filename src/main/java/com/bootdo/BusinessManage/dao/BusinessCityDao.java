package com.bootdo.BusinessManage.dao;


import com.bootdo.BusinessManage.domain.BusinessCityDO;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * 商家城市关联表
 * @author xgg
 * @email 641352220@qq.com
 * @date 2018-01-05 10:03:25
 */
@Mapper
public interface BusinessCityDao {

	BusinessCityDO get(Integer businessId);
	
	List<BusinessCityDO> list(Map<String, Object> map);
	
	int count(Map<String, Object> map);
	
	int save(BusinessCityDO city);
	
	int update(BusinessCityDO city);
	
	int remove(Integer business_id);
	
	int batchRemove(Integer[] businessIds);

	BusinessCityDO getByBusinessIdAndCityId(@Param("businessId") Integer businessId,@Param("cityId") Integer cityId);
}
