package com.bootdo.CarManage.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import com.bootdo.CarManage.dao.TypeRelationDao;
import com.bootdo.CarManage.domain.TypeRelationDO;
import com.bootdo.CarManage.service.TypeRelationService;



@Service
public class TypeRelationServiceImpl implements TypeRelationService {
	@Autowired
	private TypeRelationDao typeRelationDao;
	
	@Override
	public TypeRelationDO get(Integer carId,Integer carTypeId){
		return typeRelationDao.get(carId,carTypeId);
	}
	
	@Override
	public List<TypeRelationDO> list(Map<String, Object> map){
		return typeRelationDao.list(map);
	}
	
	@Override
	public int count(Map<String, Object> map){
		return typeRelationDao.count(map);
	}
	
	@Override
	public int save(TypeRelationDO typeRelation){
		return typeRelationDao.save(typeRelation);
	}
	
	@Override
	public int update(TypeRelationDO typeRelation){
		return typeRelationDao.update(typeRelation);
	}
	
	@Override
	public int remove(Integer carId){
		return typeRelationDao.remove(carId);
	}
	
	@Override
	public int batchRemove(Integer[] carIds){
		return typeRelationDao.batchRemove(carIds);
	}
	
}
