package com.bootdo.CarManage.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import com.bootdo.CarManage.dao.ProductInformationConfigDao;
import com.bootdo.CarManage.domain.ProductInformationConfigDO;
import com.bootdo.CarManage.service.ProductInformationConfigService;



@Service
public class ProductInformationConfigServiceImpl implements ProductInformationConfigService {
	@Autowired
	private ProductInformationConfigDao productInformationConfigDao;
	
	@Override
	public ProductInformationConfigDO get(Integer carProductInformationId,Integer loanConfigId){
		return productInformationConfigDao.get(carProductInformationId,loanConfigId);
	}
	
	@Override
	public List<ProductInformationConfigDO> list(Map<String, Object> map){
		return productInformationConfigDao.list(map);
	}
	
	@Override
	public int count(Map<String, Object> map){
		return productInformationConfigDao.count(map);
	}
	
	@Override
	public int save(ProductInformationConfigDO productInformationConfig){
		try {
			return productInformationConfigDao.save(productInformationConfig);
		}catch (Exception e) {
			return 0;
		}
	}
	
	@Override
	public int update(ProductInformationConfigDO productInformationConfig){
		return productInformationConfigDao.update(productInformationConfig);
	}
	
	@Override
	public int remove(Integer carProductInformationId){
		return productInformationConfigDao.remove(carProductInformationId);
	}
	
	@Override
	public int batchRemove(Integer[] carProductInformationIds){
		return productInformationConfigDao.batchRemove(carProductInformationIds);
	}

	@Override
	public ProductInformationConfigDO getMinSF(Integer carProductInformationId) {
		return productInformationConfigDao.getMinSF(carProductInformationId);
	}

	@Override
	public ProductInformationConfigDO getMaxTerm(Integer carProductInformationId) {
		return productInformationConfigDao.getMaxTerm(carProductInformationId);
	}

}
