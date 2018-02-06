package com.bootdo.CarManage.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import com.bootdo.CarManage.dao.DetailsDao;
import com.bootdo.CarManage.domain.DetailsDO;
import com.bootdo.CarManage.service.DetailsService;



@Service
public class DetailsServiceImpl implements DetailsService {
	@Autowired
	private DetailsDao detailsDao;
	
	@Override
	public DetailsDO get(Integer carDetailsId){
		return detailsDao.get(carDetailsId);
	}
	
	@Override
	public List<DetailsDO> list(Map<String, Object> map){
		return detailsDao.list(map);
	}
	
	@Override
	public int count(Map<String, Object> map){
		return detailsDao.count(map);
	}
	
	@Override
	public int save(DetailsDO details){
		return detailsDao.save(details);
	}
	
	@Override
	public int update(DetailsDO details){
		return detailsDao.update(details);
	}
	
	@Override
	public int remove(Integer carDetailsId){
		return detailsDao.remove(carDetailsId);
	}
	
	@Override
	public int batchRemove(Integer[] carDetailsIds){
		return detailsDao.batchRemove(carDetailsIds);
	}
	
}
