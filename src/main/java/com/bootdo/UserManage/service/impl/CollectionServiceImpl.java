package com.bootdo.UserManage.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import com.bootdo.UserManage.dao.CollectionDao;
import com.bootdo.UserManage.domain.CollectionDO;
import com.bootdo.UserManage.service.CollectionService;



@Service
public class CollectionServiceImpl implements CollectionService {
	@Autowired
	private CollectionDao collectionDao;
	
	@Override
	public CollectionDO get(Integer collectionId){
		return collectionDao.get(collectionId);
	}
	
	@Override
	public List<CollectionDO> list(Map<String, Object> map){
		return collectionDao.list(map);
	}
	
	@Override
	public int count(Map<String, Object> map){
		return collectionDao.count(map);
	}
	
	@Override
	public int save(CollectionDO collection){
		return collectionDao.save(collection);
	}
	
	@Override
	public int update(CollectionDO collection){
		return collectionDao.update(collection);
	}
	
	@Override
	public int remove(Integer collectionId){
		return collectionDao.remove(collectionId);
	}
	
	@Override
	public int batchRemove(Integer[] collectionIds){
		return collectionDao.batchRemove(collectionIds);
	}
	
}
