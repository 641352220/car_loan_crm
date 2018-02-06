package com.bootdo.IncrementManage.service;

import com.bootdo.IncrementManage.domain.IncrementProductDO;


import java.util.List;
import java.util.Map;

/**
 * 增值产品表
 * 
 * @author xgg
 * @email 641352220@qq.com
 * @date 2018-01-10 13:13:11
 */
public interface IncrementProductService {

	IncrementProductDO get(Integer productId);
	
	List<IncrementProductDO> list(Map<String, Object> map);
	
	int count(Map<String, Object> map);
	
	int save(IncrementProductDO product);
	
	int update(IncrementProductDO product);
	
	int remove(Integer productId);
	
	int batchRemove(Integer[] productIds);
}
