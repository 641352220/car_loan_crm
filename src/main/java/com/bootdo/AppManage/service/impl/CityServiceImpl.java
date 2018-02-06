package com.bootdo.AppManage.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import com.bootdo.AppManage.dao.CityDao;
import com.bootdo.AppManage.domain.CityDO;
import com.bootdo.AppManage.service.CityService;



@Service
public class CityServiceImpl implements CityService {
	@Autowired
	private CityDao cityDao;


	@Override
	public List<CityDO> productCity(Integer id,Integer level) {
		return cityDao.productCity(id,level);
	}

	@Override
	public List<CityDO> businessCity(Integer id,Integer level) {
		return cityDao.businessCity(id,level);
	}
}
