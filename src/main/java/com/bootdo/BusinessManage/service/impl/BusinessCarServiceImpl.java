package com.bootdo.BusinessManage.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import com.bootdo.BusinessManage.dao.BusinessCarDao;
import com.bootdo.BusinessManage.domain.BusinessCarDO;
import com.bootdo.BusinessManage.service.BusinessCarService;



@Service
public class BusinessCarServiceImpl implements BusinessCarService {
	@Autowired
	private BusinessCarDao businessCarDao;
	
	@Override
	public BusinessCarDO get(Integer businessId){
		return businessCarDao.get(businessId);
	}
	
	@Override
	public List<BusinessCarDO> list(Map<String, Object> map){
		return businessCarDao.list(map);
	}
	
	@Override
	public int count(Map<String, Object> map){
		return businessCarDao.count(map);
	}
	
	@Override
	public int save(BusinessCarDO car){
		if(null == businessCarDao.getByBusinessIdAndBrandId(car.getBusinessId(),car.getBrandId())){
			return businessCarDao.save(car);
		}
		return 0;
	}
	
	@Override
	public int update(BusinessCarDO car){
		return businessCarDao.update(car);
	}
	
	@Override
	public int remove(Integer businessId){
		return businessCarDao.remove(businessId);
	}
	
	@Override
	public int batchRemove(Integer[] businessIds){
		return businessCarDao.batchRemove(businessIds);
	}

}
