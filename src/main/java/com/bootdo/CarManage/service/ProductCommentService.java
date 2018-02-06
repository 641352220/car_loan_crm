package com.bootdo.CarManage.service;

import com.bootdo.CarManage.domain.ProductCommentDO;

import java.util.List;
import java.util.Map;

/**
 * 车贷产品评价表
 * 
 * @author xgg
 * @email 641352220@qq.com
 * @date 2018-01-04 16:43:41
 */
public interface ProductCommentService {
	
	ProductCommentDO get(Integer carProductCommentId);
	
	List<ProductCommentDO> list(Map<String, Object> map);
	
	int count(Map<String, Object> map);
	
	int save(ProductCommentDO productComment);
	
	int update(ProductCommentDO productComment);
	
	int remove(Integer carProductCommentId);
	
	int batchRemove(Integer[] carProductCommentIds);

	Integer getPJF(Integer carProductId);
}
