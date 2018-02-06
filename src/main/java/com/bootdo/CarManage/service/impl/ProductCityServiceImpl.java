package com.bootdo.CarManage.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import com.bootdo.CarManage.dao.ProductCityDao;
import com.bootdo.CarManage.domain.ProductCityDO;
import com.bootdo.CarManage.service.ProductCityService;



@Service
public class ProductCityServiceImpl implements ProductCityService {
	@Autowired
	private ProductCityDao productCityDao;
	
	@Override
	public ProductCityDO get(Integer carProductId){
		return productCityDao.get(carProductId);
	}
	
	@Override
	public List<ProductCityDO> list(Map<String, Object> map){
		return productCityDao.list(map);
	}
	
	@Override
	public int count(Map<String, Object> map){
		return productCityDao.count(map);
	}
	
	@Override
	public int save(ProductCityDO productCity){
		try{
			return productCityDao.save(productCity);
		}catch (Exception e) {
			return 0;
		}
	}
	
	@Override
	public int update(ProductCityDO productCity){
		return productCityDao.update(productCity);
	}
	
	@Override
	public int remove(Integer carProductId){
		return productCityDao.remove(carProductId);
	}
	
	@Override
	public int batchRemove(Integer[] carProductIds){
		return productCityDao.batchRemove(carProductIds);
	}
	
}
