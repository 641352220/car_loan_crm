package com.bootdo.BusinessManage.dao;

import com.bootdo.BusinessManage.domain.RecommendDO;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * 商家推荐表
 * @author xgg
 * @email 641352220@qq.com
 * @date 2018-01-05 10:03:25
 */
@Mapper
public interface RecommendDao {

	RecommendDO get(Integer businessId);
	
	List<RecommendDO> list(Map<String, Object> map);
	
	int count(Map<String, Object> map);
	
	int save(RecommendDO recommend);
	
	int update(RecommendDO recommend);
	
	int remove(Integer business_id);
	
	int batchRemove(Integer[] businessIds);

	RecommendDO getByBusinessIdAndCarId(@Param("businessId") Integer businessId,@Param("carId") Integer carId);
}
