package com.bootdo.CarManage.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import com.bootdo.CarManage.dao.SubsidiaryDao;
import com.bootdo.CarManage.domain.SubsidiaryDO;
import com.bootdo.CarManage.service.SubsidiaryService;



@Service
public class SubsidiaryServiceImpl implements SubsidiaryService {
	@Autowired
	private SubsidiaryDao subsidiaryDao;
	
	@Override
	public SubsidiaryDO get(Integer subsidiaryId){
		return subsidiaryDao.get(subsidiaryId);
	}
	
	@Override
	public List<SubsidiaryDO> list(Map<String, Object> map){
		return subsidiaryDao.list(map);
	}
	
	@Override
	public int count(Map<String, Object> map){
		return subsidiaryDao.count(map);
	}
	
	@Override
	public int save(SubsidiaryDO subsidiary){
		return subsidiaryDao.save(subsidiary);
	}
	
	@Override
	public int update(SubsidiaryDO subsidiary){
		return subsidiaryDao.update(subsidiary);
	}
	
	@Override
	public int remove(Integer subsidiaryId){
		return subsidiaryDao.remove(subsidiaryId);
	}
	
	@Override
	public int batchRemove(Integer[] subsidiaryIds){
		return subsidiaryDao.batchRemove(subsidiaryIds);
	}
	
}
