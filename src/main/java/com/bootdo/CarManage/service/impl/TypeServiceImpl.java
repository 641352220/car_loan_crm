package com.bootdo.CarManage.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import com.bootdo.CarManage.dao.TypeDao;
import com.bootdo.CarManage.domain.TypeDO;
import com.bootdo.CarManage.service.TypeService;



@Service
public class TypeServiceImpl implements TypeService {
	@Autowired
	private TypeDao typeDao;
	
	@Override
	public TypeDO get(Integer carTypeId){
		return typeDao.get(carTypeId);
	}
	
	@Override
	public List<TypeDO> list(Map<String, Object> map){
		return typeDao.list(map);
	}
	
	@Override
	public int count(Map<String, Object> map){
		return typeDao.count(map);
	}
	
	@Override
	public int save(TypeDO type){
		return typeDao.save(type);
	}
	
	@Override
	public int update(TypeDO type){
		return typeDao.update(type);
	}
	
	@Override
	public int remove(Integer carTypeId){
		return typeDao.remove(carTypeId);
	}
	
	@Override
	public int batchRemove(Integer[] carTypeIds){
		return typeDao.batchRemove(carTypeIds);
	}

	@Override
	public List<TypeDO> nameList() {
		return typeDao.nameList();
	}

}
