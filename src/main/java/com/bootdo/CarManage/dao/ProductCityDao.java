package com.bootdo.CarManage.dao;

import com.bootdo.CarManage.domain.ProductCityDO;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

/**
 * 车贷产品城市关联表
 * @author xgg
 * @email 641352220@qq.com
 * @date 2018-01-04 16:43:41
 */
@Mapper
public interface ProductCityDao {

	ProductCityDO get(Integer carProductId);
	
	List<ProductCityDO> list(Map<String, Object> map);
	
	int count(Map<String, Object> map);
	
	int save(ProductCityDO productCity);
	
	int update(ProductCityDO productCity);
	
	int remove(Integer car_product_id);
	
	int batchRemove(Integer[] carProductIds);
}
