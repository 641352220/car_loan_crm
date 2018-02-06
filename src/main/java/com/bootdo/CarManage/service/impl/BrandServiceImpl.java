package com.bootdo.CarManage.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import com.bootdo.CarManage.dao.BrandDao;
import com.bootdo.CarManage.domain.BrandDO;
import com.bootdo.CarManage.service.BrandService;



@Service
public class BrandServiceImpl implements BrandService {
	@Autowired
	private BrandDao brandDao;
	
	@Override
	public BrandDO get(Integer brandId){
		return brandDao.get(brandId);
	}
	
	@Override
	public List<BrandDO> list(Map<String, Object> map){
		return brandDao.list(map);
	}
	
	@Override
	public int count(Map<String, Object> map){
		return brandDao.count(map);
	}
	
	@Override
	public int save(BrandDO brand){
		return brandDao.save(brand);
	}
	
	@Override
	public int update(BrandDO brand){
		return brandDao.update(brand);
	}
	
	@Override
	public int remove(Integer brandId){
		return brandDao.remove(brandId);
	}
	
	@Override
	public int batchRemove(Integer[] brandIds){
		return brandDao.batchRemove(brandIds);
	}

	@Override
	public List<BrandDO> BrandDOList() {
		return brandDao.BrandDOList();
	}

	@Override
	public List<BrandDO> listByBusinessId(Integer businessId) {
		return brandDao.listByBusinessId(businessId);
	}

	@Override
	public List<BrandDO> BrandDOListByFA() {
		return brandDao.BrandDOListByFA();
	}

}
