package com.bootdo.AppManage.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import com.bootdo.AppManage.dao.ConfigDao;
import com.bootdo.AppManage.domain.ConfigDO;
import com.bootdo.AppManage.service.ConfigService;



@Service
public class ConfigServiceImpl implements ConfigService {
	@Autowired
	private ConfigDao configDao;
	
	@Override
	public ConfigDO get(String name){
		return configDao.get(name);
	}

	@Override
	public List<ConfigDO> list() {
		return configDao.list();
	}

	@Override
	public int save(ConfigDO config){
		return configDao.save(config);
	}
	
	@Override
	public int update(ConfigDO config){
		return configDao.update(config);
	}
}
