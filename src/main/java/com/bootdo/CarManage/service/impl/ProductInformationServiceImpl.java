package com.bootdo.CarManage.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import com.bootdo.CarManage.dao.ProductInformationDao;
import com.bootdo.CarManage.domain.ProductInformationDO;
import com.bootdo.CarManage.service.ProductInformationService;



@Service
public class ProductInformationServiceImpl implements ProductInformationService {
	@Autowired
	private ProductInformationDao productInformationDao;
	
	@Override
	public ProductInformationDO get(Integer carProductInformationId){
		return productInformationDao.get(carProductInformationId);
	}
	
	@Override
	public List<ProductInformationDO> list(Map<String, Object> map){
		return productInformationDao.list(map);
	}
	
	@Override
	public int count(Map<String, Object> map){
		return productInformationDao.count(map);
	}
	
	@Override
	public int save(ProductInformationDO productInformation){
		return productInformationDao.save(productInformation);
	}
	
	@Override
	public int update(ProductInformationDO productInformation){
		return productInformationDao.update(productInformation);
	}
	
	@Override
	public int remove(Integer carProductInformationId){
		return productInformationDao.remove(carProductInformationId);
	}
	
	@Override
	public int batchRemove(Integer[] carProductInformationIds){
		return productInformationDao.batchRemove(carProductInformationIds);
	}

	@Override
	public List<Integer> getModelIds(Integer carProductInformationId) {
		return productInformationDao.getModelIds(carProductInformationId);
	}

	@Override
	public List<Integer> getCarIds(Integer carProductInformationId) {
		return productInformationDao.getCarIds(carProductInformationId);
	}

	@Override
	public List<Integer> getBrandIds(Integer carProductInformationId) {
		return productInformationDao.getBrandIds(carProductInformationId);
	}

	@Override
	public List<ProductInformationDO> listByCarProductId(Integer carProductId) {
		return productInformationDao.listByCarProductId(carProductId);
	}

}
