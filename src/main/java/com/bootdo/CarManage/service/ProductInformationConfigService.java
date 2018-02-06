package com.bootdo.CarManage.service;

import com.bootdo.CarManage.domain.ProductInformationConfigDO;

import java.util.List;
import java.util.Map;

/**
 * 车贷报价方案期限利率详情表,一个方案可以有多条首付和期限
 * 
 * @author xgg
 * @email 641352220@qq.com
 * @date 2018-01-04 16:43:41
 */
public interface ProductInformationConfigService {
	
	ProductInformationConfigDO get(Integer carProductInformationId,Integer loanConfigId);
	
	List<ProductInformationConfigDO> list(Map<String, Object> map);
	
	int count(Map<String, Object> map);
	
	int save(ProductInformationConfigDO productInformationConfig);
	
	int update(ProductInformationConfigDO productInformationConfig);
	
	int remove(Integer carProductInformationId);
	
	int batchRemove(Integer[] carProductInformationIds);

	ProductInformationConfigDO getMinSF(Integer carProductInformationId);

	ProductInformationConfigDO getMaxTerm(Integer carProductInformationId);
}
