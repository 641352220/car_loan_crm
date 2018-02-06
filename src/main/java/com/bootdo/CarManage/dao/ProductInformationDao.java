package com.bootdo.CarManage.dao;

import com.bootdo.CarManage.domain.ProductInformationDO;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * 车贷产品补充表
 * @author xgg
 * @email 641352220@qq.com
 * @date 2018-01-04 16:43:41
 */
@Mapper
public interface ProductInformationDao {

	ProductInformationDO get(Integer carProductInformationId);
	
	List<ProductInformationDO> list(Map<String, Object> map);
	
	int count(Map<String, Object> map);
	
	int save(ProductInformationDO productInformation);
	
	int update(ProductInformationDO productInformation);
	
	int remove(Integer car_product_information_id);
	
	int batchRemove(Integer[] carProductInformationIds);

	List<Integer> getBrandIds(@Param("carProductInformationId") Integer carProductInformationId);

	List<Integer> getModelIds(@Param("carProductInformationId") Integer carProductInformationId);

	List<Integer> getCarIds(@Param("carProductInformationId") Integer carProductInformationId);

	List<ProductInformationDO> listByCarProductId(Integer carProductId);
}
