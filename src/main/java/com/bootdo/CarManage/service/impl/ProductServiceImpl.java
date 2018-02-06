package com.bootdo.CarManage.service.impl;

import com.bootdo.common.config.AliyunOSS;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import com.bootdo.CarManage.dao.ProductDao;
import com.bootdo.CarManage.domain.ProductDO;
import com.bootdo.CarManage.service.ProductService;



@Service
public class ProductServiceImpl implements ProductService {
	@Autowired
	private ProductDao productDao;
	@Autowired
	private AliyunOSS aliyunOSS;
	
	@Override
	public ProductDO get(Integer carProductId){
		return productDao.get(carProductId);
	}
	
	@Override
	public List<ProductDO> list(Map<String, Object> map){
		List<ProductDO> list = productDao.list(map);
		for(ProductDO productDO : list){
			productDO.setLoanProcess(aliyunOSS.getCdn()+productDO.getLoanProcess());
			productDO.setLogo(aliyunOSS.getCdn()+productDO.getLogo());
		}
		return list;
	}
	
	@Override
	public int count(Map<String, Object> map){
		return productDao.count(map);
	}
	
	@Override
	public int save(ProductDO product){
		return productDao.save(product);
	}
	
	@Override
	public int update(ProductDO product){
		return productDao.update(product);
	}
	
	@Override
	public int remove(Integer carProductId){
		return productDao.remove(carProductId);
	}
	
	@Override
	public int batchRemove(Integer[] carProductIds){
		return productDao.batchRemove(carProductIds);
	}

	@Override
	public List<ProductDO> nameList(Integer businessId) {
		return productDao.nameList(businessId);
	}

	@Override
	public int updateComment(Integer carProductId, Integer commentBranch) {
		return productDao.updateComment(carProductId,commentBranch);
	}

}
