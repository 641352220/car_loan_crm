package com.bootdo.BusinessManage.dao;

import com.bootdo.BusinessManage.domain.BusinessCarDO;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * 商家支持的汽车(经销商)
 * @author xgg
 * @email 641352220@qq.com
 * @date 2018-01-05 10:03:25
 */
@Mapper
public interface BusinessCarDao {

	BusinessCarDO get(Integer businessId);
	
	List<BusinessCarDO> list(Map<String, Object> map);
	
	int count(Map<String, Object> map);
	
	int save(BusinessCarDO car);
	
	int update(BusinessCarDO car);
	
	int remove(Integer business_id);
	
	int batchRemove(Integer[] businessIds);

	BusinessCarDO getByBusinessIdAndBrandId(@Param("businessId") Integer businessId,@Param("brandId") Integer brandId);
}
