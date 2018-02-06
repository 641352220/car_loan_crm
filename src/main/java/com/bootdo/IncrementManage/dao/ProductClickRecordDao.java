package com.bootdo.IncrementManage.dao;

import com.bootdo.IncrementManage.domain.ProductClickRecordDO;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

/**
 * 增值产品点击记录
 * @author xgg
 * @email 641352220@qq.com
 * @date 2018-01-10 13:13:12
 */
@Mapper
public interface ProductClickRecordDao {

	ProductClickRecordDO get(Integer incrementProductId);
	
	List<ProductClickRecordDO> list(Map<String, Object> map);
	
	int count(Map<String, Object> map);
	
	int save(ProductClickRecordDO productClickRecord);
	
	int update(ProductClickRecordDO productClickRecord);
	
	int remove(Integer increment_product_id);
	
	int batchRemove(Integer[] incrementProductIds);
}
