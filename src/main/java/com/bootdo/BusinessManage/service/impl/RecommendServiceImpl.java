package com.bootdo.BusinessManage.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import com.bootdo.BusinessManage.dao.RecommendDao;
import com.bootdo.BusinessManage.domain.RecommendDO;
import com.bootdo.BusinessManage.service.RecommendService;



@Service
public class RecommendServiceImpl implements RecommendService {
	@Autowired
	private RecommendDao recommendDao;
	
	@Override
	public RecommendDO get(Integer businessId){
		return recommendDao.get(businessId);
	}
	
	@Override
	public List<RecommendDO> list(Map<String, Object> map){
		return recommendDao.list(map);
	}
	
	@Override
	public int count(Map<String, Object> map){
		return recommendDao.count(map);
	}
	
	@Override
	public int save(RecommendDO recommend){
		return recommendDao.save(recommend);
	}
	
	@Override
	public int update(RecommendDO recommend){
		return recommendDao.update(recommend);
	}
	
	@Override
	public int remove(Integer businessId){
		return recommendDao.remove(businessId);
	}
	
	@Override
	public int batchRemove(Integer[] businessIds){
		return recommendDao.batchRemove(businessIds);
	}

	@Override
	public RecommendDO getByBusinessIdAndCarId(Integer businessId, Integer carId) {
		return recommendDao.getByBusinessIdAndCarId(businessId,carId);
	}

}
