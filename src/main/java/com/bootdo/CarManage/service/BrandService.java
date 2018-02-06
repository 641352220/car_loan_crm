package com.bootdo.CarManage.service;

import com.bootdo.CarManage.domain.BrandDO;

import java.util.List;
import java.util.Map;

/**
 * 品牌
 * 
 * @author xgg
 * @email 641352220@qq.com
 * @date 2018-01-04 16:43:41
 */
public interface BrandService {
	
	BrandDO get(Integer brandId);
	
	List<BrandDO> list(Map<String, Object> map);
	
	int count(Map<String, Object> map);
	
	int save(BrandDO brand);
	
	int update(BrandDO brand);
	
	int remove(Integer brandId);
	
	int batchRemove(Integer[] brandIds);

	List<BrandDO> BrandDOList();

	List<BrandDO> listByBusinessId(Integer businessId);

	List<BrandDO> BrandDOListByFA();
}
