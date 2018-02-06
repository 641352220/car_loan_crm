package com.bootdo.CarManage.service;

import com.bootdo.CarManage.domain.ProductInformationDO;

import java.util.List;
import java.util.Map;

/**
 * 车贷产品补充表
 * 
 * @author xgg
 * @email 641352220@qq.com
 * @date 2018-01-04 16:43:41
 */
public interface ProductInformationService {
	
	ProductInformationDO get(Integer carProductInformationId);
	
	List<ProductInformationDO> list(Map<String, Object> map);
	
	int count(Map<String, Object> map);
	
	int save(ProductInformationDO productInformation);
	
	int update(ProductInformationDO productInformation);
	
	int remove(Integer carProductInformationId);
	
	int batchRemove(Integer[] carProductInformationIds);

	List<Integer> getModelIds(Integer carProductInformationId);

	List<Integer> getCarIds(Integer carProductInformationId);

	List<Integer> getBrandIds(Integer carProductInformationId);

	List<ProductInformationDO> listByCarProductId(Integer carProductId);
}
