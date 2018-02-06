package com.bootdo.IncrementManage.service.impl;

import com.bootdo.common.config.AliyunOSS;
import com.bootdo.common.service.DictService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import com.bootdo.IncrementManage.dao.IncrementProductDao;
import com.bootdo.IncrementManage.domain.IncrementProductDO;
import com.bootdo.IncrementManage.service.IncrementProductService;



@Service
public class IncrementProductServiceImpl implements IncrementProductService {
	@Autowired
	private IncrementProductDao incrementProductDao;
	@Autowired
	private DictService dictService;
	@Autowired
	private AliyunOSS aliyunOSS;
	
	@Override
	public IncrementProductDO get(Integer productId){
		return incrementProductDao.get(productId);
	}
	
	@Override
	public List<IncrementProductDO> list(Map<String, Object> map){
		List<IncrementProductDO> productDOS = incrementProductDao.list(map);
		for (IncrementProductDO productDO : productDOS) {
			productDO.setType(dictService.getName("increment_product_type", productDO.getType()) );
			productDO.setLogo(aliyunOSS.getCdn()+productDO.getLogo());
		}
		return productDOS;
	}
	
	@Override
	public int count(Map<String, Object> map){
		return incrementProductDao.count(map);
	}
	
	@Override
	public int save(IncrementProductDO product){
		return incrementProductDao.save(product);
	}
	
	@Override
	public int update(IncrementProductDO product){
		return incrementProductDao.update(product);
	}
	
	@Override
	public int remove(Integer productId){
		return incrementProductDao.remove(productId);
	}
	
	@Override
	public int batchRemove(Integer[] productIds){
		return incrementProductDao.batchRemove(productIds);
	}
	
}
