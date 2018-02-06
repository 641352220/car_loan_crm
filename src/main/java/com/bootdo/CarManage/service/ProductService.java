package com.bootdo.CarManage.service;

import com.bootdo.CarManage.domain.ProductDO;

import java.util.List;
import java.util.Map;

/**
 * 车贷产品
 * 
 * @author xgg
 * @email 641352220@qq.com
 * @date 2018-01-04 16:43:41
 */
public interface ProductService {
	
	ProductDO get(Integer carProductId);
	
	List<ProductDO> list(Map<String, Object> map);
	
	int count(Map<String, Object> map);
	
	int save(ProductDO product);
	
	int update(ProductDO product);
	
	int remove(Integer carProductId);
	
	int batchRemove(Integer[] carProductIds);

	List<ProductDO> nameList(Integer businessId);

	int updateComment(Integer carProductId,Integer commentBranch);
}
