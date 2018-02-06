package com.bootdo.CarManage.dao;

import com.bootdo.CarManage.domain.ProductCommentDO;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

/**
 * 车贷产品评价表
 * @author xgg
 * @email 641352220@qq.com
 * @date 2018-01-04 16:43:41
 */
@Mapper
public interface ProductCommentDao {

	ProductCommentDO get(Integer carProductCommentId);
	
	List<ProductCommentDO> list(Map<String, Object> map);
	
	int count(Map<String, Object> map);
	
	int save(ProductCommentDO productComment);
	
	int update(ProductCommentDO productComment);
	
	int remove(Integer car_product_comment_id);
	
	int batchRemove(Integer[] carProductCommentIds);

	Integer getPJF(Integer carProductId);
}
