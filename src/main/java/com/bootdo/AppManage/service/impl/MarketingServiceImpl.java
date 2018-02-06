package com.bootdo.AppManage.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import com.bootdo.AppManage.dao.MarketingDao;
import com.bootdo.AppManage.domain.MarketingDO;
import com.bootdo.AppManage.service.MarketingService;



@Service
public class MarketingServiceImpl implements MarketingService {
	@Autowired
	private MarketingDao marketingDao;
	
	@Override
	public MarketingDO get(Integer marketingId){
		return marketingDao.get(marketingId);
	}
	
	@Override
	public List<MarketingDO> list(Map<String, Object> map){
		return marketingDao.list(map);
	}
	
	@Override
	public int count(Map<String, Object> map){
		return marketingDao.count(map);
	}
	
	@Override
	public int save(MarketingDO marketing){
		return marketingDao.save(marketing);
	}
	
	@Override
	public int update(MarketingDO marketing){
		return marketingDao.update(marketing);
	}
	
	@Override
	public int remove(Integer marketingId){
		return marketingDao.remove(marketingId);
	}
	
	@Override
	public int batchRemove(Integer[] marketingIds){
		return marketingDao.batchRemove(marketingIds);
	}

	@Override
	public List<MarketingDO> nameList() {
		return marketingDao.nameList();
	}

}
