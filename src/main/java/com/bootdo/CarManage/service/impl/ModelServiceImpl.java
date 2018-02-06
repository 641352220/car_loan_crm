package com.bootdo.CarManage.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import com.bootdo.CarManage.dao.ModelDao;
import com.bootdo.CarManage.domain.ModelDO;
import com.bootdo.CarManage.service.ModelService;



@Service
public class ModelServiceImpl implements ModelService {
	@Autowired
	private ModelDao modelDao;
	
	@Override
	public ModelDO get(Integer carModelId){
		return modelDao.get(carModelId);
	}
	
	@Override
	public List<ModelDO> list(Map<String, Object> map){
		return modelDao.list(map);
	}
	
	@Override
	public int count(Map<String, Object> map){
		return modelDao.count(map);
	}
	
	@Override
	public int save(ModelDO model){
		return modelDao.save(model);
	}
	
	@Override
	public int update(ModelDO model){
		return modelDao.update(model);
	}
	
	@Override
	public int remove(Integer carModelId){
		return modelDao.remove(carModelId);
	}
	
	@Override
	public int batchRemove(Integer[] carModelIds){
		return modelDao.batchRemove(carModelIds);
	}

	@Override
	public List<ModelDO> ModelDaoListByBrandId(Integer brandId) {
		return modelDao.ModelDaoListByBrandId(brandId);
	}

	@Override
	public List<ModelDO> ModelDaoListByBrandIds(String brandId) {
		return modelDao.ModelDaoListByBrandIds(brandId);
	}

}
