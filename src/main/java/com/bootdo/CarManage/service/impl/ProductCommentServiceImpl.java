package com.bootdo.CarManage.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import com.bootdo.CarManage.dao.ProductCommentDao;
import com.bootdo.CarManage.domain.ProductCommentDO;
import com.bootdo.CarManage.service.ProductCommentService;



@Service
public class ProductCommentServiceImpl implements ProductCommentService {
	@Autowired
	private ProductCommentDao productCommentDao;
	
	@Override
	public ProductCommentDO get(Integer carProductCommentId){
		return productCommentDao.get(carProductCommentId);
	}
	
	@Override
	public List<ProductCommentDO> list(Map<String, Object> map){
		return productCommentDao.list(map);
	}
	
	@Override
	public int count(Map<String, Object> map){
		return productCommentDao.count(map);
	}
	
	@Override
	public int save(ProductCommentDO productComment){
		return productCommentDao.save(productComment);
	}
	
	@Override
	public int update(ProductCommentDO productComment){
		return productCommentDao.update(productComment);
	}
	
	@Override
	public int remove(Integer carProductCommentId){
		return productCommentDao.remove(carProductCommentId);
	}
	
	@Override
	public int batchRemove(Integer[] carProductCommentIds){
		return productCommentDao.batchRemove(carProductCommentIds);
	}

	@Override
	public Integer getPJF(Integer carProductId) {
		return productCommentDao.getPJF(carProductId);
	}

}
