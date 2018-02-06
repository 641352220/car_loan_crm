package com.bootdo.IncrementManage.service.impl;

import com.bootdo.common.service.DictService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import com.bootdo.IncrementManage.dao.ProductClickRecordDao;
import com.bootdo.IncrementManage.domain.ProductClickRecordDO;
import com.bootdo.IncrementManage.service.ProductClickRecordService;



@Service
public class ProductClickRecordServiceImpl implements ProductClickRecordService {
	@Autowired
	private ProductClickRecordDao productClickRecordDao;
	@Autowired
	private DictService dictService;
	
	@Override
	public ProductClickRecordDO get(Integer incrementProductId){
		return productClickRecordDao.get(incrementProductId);
	}
	
	@Override
	public List<ProductClickRecordDO> list(Map<String, Object> map){
		List<ProductClickRecordDO> productClickRecordDOS = productClickRecordDao.list(map);
		for (ProductClickRecordDO productClickRecordDO : productClickRecordDOS) {
			productClickRecordDO.setType(dictService.getName("increment_product_type", productClickRecordDO.getType()) );
		}
		return productClickRecordDOS;
	}
	
	@Override
	public int count(Map<String, Object> map){
		return productClickRecordDao.count(map);
	}
	
	@Override
	public int save(ProductClickRecordDO productClickRecord){
		return productClickRecordDao.save(productClickRecord);
	}
	
	@Override
	public int update(ProductClickRecordDO productClickRecord){
		return productClickRecordDao.update(productClickRecord);
	}
	
	@Override
	public int remove(Integer incrementProductId){
		return productClickRecordDao.remove(incrementProductId);
	}
	
	@Override
	public int batchRemove(Integer[] incrementProductIds){
		return productClickRecordDao.batchRemove(incrementProductIds);
	}
	
}
