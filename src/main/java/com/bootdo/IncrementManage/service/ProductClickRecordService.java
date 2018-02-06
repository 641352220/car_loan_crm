package com.bootdo.IncrementManage.service;

import com.bootdo.IncrementManage.domain.ProductClickRecordDO;

import java.util.List;
import java.util.Map;

/**
 * 增值产品点击记录
 * 
 * @author xgg
 * @email 641352220@qq.com
 * @date 2018-01-10 13:13:12
 */
public interface ProductClickRecordService {
	
	ProductClickRecordDO get(Integer incrementProductId);
	
	List<ProductClickRecordDO> list(Map<String, Object> map);
	
	int count(Map<String, Object> map);
	
	int save(ProductClickRecordDO productClickRecord);
	
	int update(ProductClickRecordDO productClickRecord);
	
	int remove(Integer incrementProductId);
	
	int batchRemove(Integer[] incrementProductIds);
}
