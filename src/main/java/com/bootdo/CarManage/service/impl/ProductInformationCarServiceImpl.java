package com.bootdo.CarManage.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.bootdo.CarManage.dao.ProductInformationCarDao;
import com.bootdo.CarManage.domain.ProductInformationCarDO;
import com.bootdo.CarManage.service.ProductInformationCarService;



@Service
public class ProductInformationCarServiceImpl implements ProductInformationCarService {
	@Autowired
	private ProductInformationCarDao productInformationCarDao;
	
	@Override
	public ProductInformationCarDO get(Integer carProductInformationId,Integer carId){
		return productInformationCarDao.get(carProductInformationId,carId);
	}
	
	@Override
	public List<ProductInformationCarDO> list(Map<String, Object> map){
		return productInformationCarDao.list(map);
	}
	
	@Override
	public int count(Map<String, Object> map){
		return productInformationCarDao.count(map);
	}
	
	@Override
	public int save(ProductInformationCarDO productInformationCar){
		try {
			return productInformationCarDao.save(productInformationCar);
		}catch (Exception e){
			return 0;
		}
	}
	
	@Override
	public int update(ProductInformationCarDO productInformationCar){
		return productInformationCarDao.update(productInformationCar);
	}
	
	@Override
	public int remove(Integer carProductInformationId){
		return productInformationCarDao.remove(carProductInformationId);
	}
	
	@Override
	public int batchRemove(Integer[] businessIds){
		return productInformationCarDao.batchRemove(businessIds);
	}

	@Override
	public int updateCarPrice(Map<String, Object> map) {
		return productInformationCarDao.updateCarPrice(map);
	}

	@Override
	public int updateDp(Map<String, Object> map) {
		return productInformationCarDao.updateDp(map);
	}

	@Override
	public int updateTerm(Map<String, Object> map) {
		return productInformationCarDao.updateTerm(map);
	}

}
