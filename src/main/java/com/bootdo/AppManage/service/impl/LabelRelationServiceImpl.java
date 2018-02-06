package com.bootdo.AppManage.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import com.bootdo.AppManage.dao.LabelRelationDao;
import com.bootdo.AppManage.domain.LabelRelationDO;
import com.bootdo.AppManage.service.LabelRelationService;



@Service
public class LabelRelationServiceImpl implements LabelRelationService {
	@Autowired
	private LabelRelationDao labelRelationDao;
	
	@Override
	public LabelRelationDO get(Integer relationId){
		return labelRelationDao.get(relationId);
	}
	
	@Override
	public List<LabelRelationDO> list(Map<String, Object> map){
		return labelRelationDao.list(map);
	}
	
	@Override
	public int count(Map<String, Object> map){
		return labelRelationDao.count(map);
	}
	
	@Override
	public int save(LabelRelationDO labelRelation){
		try{
			return labelRelationDao.save(labelRelation);
		}catch (Exception e){
			return 0;
		}
	}
	
	@Override
	public int update(LabelRelationDO labelRelation){
		return labelRelationDao.update(labelRelation);
	}
	
	@Override
	public int remove(Integer id,String type){
		return labelRelationDao.remove(id,type);
	}
	
	@Override
	public int batchRemove(Integer[] relationIds){
		return labelRelationDao.batchRemove(relationIds);
	}
	
}
