package com.bootdo.CarManage.dao;

import com.bootdo.CarManage.domain.DetailsDO;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

/**
 * 汽车详情(很多字段的那个)
 * @author xgg
 * @email 641352220@qq.com
 * @date 2018-01-04 16:43:41
 */
@Mapper
public interface DetailsDao {

	DetailsDO get(Integer carDetailsId);
	
	List<DetailsDO> list(Map<String, Object> map);
	
	int count(Map<String, Object> map);
	
	int save(DetailsDO details);
	
	int update(DetailsDO details);
	
	int remove(Integer car_details_id);
	
	int batchRemove(Integer[] carDetailsIds);
}
