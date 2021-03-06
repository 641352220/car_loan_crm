package com.bootdo.CarManage.dao;

import com.bootdo.CarManage.domain.ProductInformationCarDO;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * 汽车产品补充表关联汽车表,一个方案支持多款车
 * @author xgg
 * @email 641352220@qq.com
 * @date 2018-01-04 16:43:41
 */
@Mapper
public interface ProductInformationCarDao {

	ProductInformationCarDO get(@Param("carProductInformationId") Integer carProductInformationId,
								@Param("carId") Integer carId);
	
	List<ProductInformationCarDO> list(Map<String, Object> map);
	
	int count(Map<String, Object> map);
	
	int save(ProductInformationCarDO productInformationCar);
	
	int update(ProductInformationCarDO productInformationCar);
	
	int remove(Integer carProductInformationId);
	
	int batchRemove(Integer[] businessIds);

	int updateCarPrice(Map<String,Object> map);
	int updateDp(Map<String,Object> map);
	int updateTerm(Map<String,Object> map);

}
