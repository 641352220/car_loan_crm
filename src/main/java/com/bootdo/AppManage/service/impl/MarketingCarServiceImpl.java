package com.bootdo.AppManage.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import com.bootdo.AppManage.dao.MarketingCarDao;
import com.bootdo.AppManage.domain.MarketingCarDO;
import com.bootdo.AppManage.service.MarketingCarService;



@Service
public class MarketingCarServiceImpl implements MarketingCarService {
	@Autowired
	private MarketingCarDao marketingCarDao;
	
	@Override
	public MarketingCarDO get(Integer appMarketingCarId){
		return marketingCarDao.get(appMarketingCarId);
	}
	
	@Override
	public List<MarketingCarDO> list(Map<String, Object> map){
		return marketingCarDao.list(map);
	}
	
	@Override
	public int count(Map<String, Object> map){
		return marketingCarDao.count(map);
	}
	
	@Override
	public int save(MarketingCarDO marketingCar){
		return marketingCarDao.save(marketingCar);
	}
	
	@Override
	public int update(MarketingCarDO marketingCar){
		return marketingCarDao.update(marketingCar);
	}
	
	@Override
	public int remove(Integer appMarketingCarId){
		return marketingCarDao.remove(appMarketingCarId);
	}
	
	@Override
	public int batchRemove(Integer[] appMarketingCarIds){
		return marketingCarDao.batchRemove(appMarketingCarIds);
	}
	
}
