package com.bootdo.AppManage.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import com.bootdo.AppManage.dao.EditionDao;
import com.bootdo.AppManage.domain.EditionDO;
import com.bootdo.AppManage.service.EditionService;



@Service
public class EditionServiceImpl implements EditionService {
	@Autowired
	private EditionDao editionDao;
	
	@Override
	public EditionDO get(Integer id){
		return editionDao.get(id);
	}
	
	@Override
	public List<EditionDO> list(Map<String, Object> map){
		return editionDao.list(map);
	}
	
	@Override
	public int count(Map<String, Object> map){
		return editionDao.count(map);
	}
	
	@Override
	public int save(EditionDO edition){
		return editionDao.save(edition);
	}
	
	@Override
	public int update(EditionDO edition){
		return editionDao.update(edition);
	}
	
	@Override
	public int remove(Integer id){
		return editionDao.remove(id);
	}
	
	@Override
	public int batchRemove(Integer[] ids){
		return editionDao.batchRemove(ids);
	}
	
}
