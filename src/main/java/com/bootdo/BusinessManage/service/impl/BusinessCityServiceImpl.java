package com.bootdo.BusinessManage.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import com.bootdo.BusinessManage.dao.BusinessCityDao;
import com.bootdo.BusinessManage.domain.BusinessCityDO;
import com.bootdo.BusinessManage.service.BusinessCityService;



@Service
public class BusinessCityServiceImpl implements BusinessCityService {
	@Autowired
	private BusinessCityDao businessCityDao;
	
	@Override
	public BusinessCityDO get(Integer businessId){
		return businessCityDao.get(businessId);
	}
	
	@Override
	public List<BusinessCityDO> list(Map<String, Object> map){
		return businessCityDao.list(map);
	}
	
	@Override
	public int count(Map<String, Object> map){
		return businessCityDao.count(map);
	}
	
	@Override
	public int save(BusinessCityDO city){
		if(null == businessCityDao.getByBusinessIdAndCityId(city.getBusinessId(),city.getCityId())){
			return businessCityDao.save(city);
		}
		return 0;
	}
	
	@Override
	public int update(BusinessCityDO city){
		return businessCityDao.update(city);
	}
	
	@Override
	public int remove(Integer businessId){
		return businessCityDao.remove(businessId);
	}
	
	@Override
	public int batchRemove(Integer[] businessIds){
		return businessCityDao.batchRemove(businessIds);
	}

	@Override
	public BusinessCityDO getByBusinessIdAndCityId(Integer businessId, Integer cityId) {
		return businessCityDao.getByBusinessIdAndCityId(businessId,cityId);
	}

}
