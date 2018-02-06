package com.bootdo.CarManage.dao;

import com.bootdo.CarManage.domain.ProductDO;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * 车贷产品
 * @author xgg
 * @email 641352220@qq.com
 * @date 2018-01-04 16:43:41
 */
@Mapper
public interface ProductDao {

	ProductDO get(Integer carProductId);
	
	List<ProductDO> list(Map<String, Object> map);
	
	int count(Map<String, Object> map);
	
	int save(ProductDO product);
	
	int update(ProductDO product);
	
	int remove(Integer car_product_id);
	
	int batchRemove(Integer[] carProductIds);

	List<ProductDO> nameList(@Param("businessId") Integer businessId);

	int updateComment(@Param("carProductId") Integer carProductId,@Param("commentBranch") Integer commentBranch);
}
