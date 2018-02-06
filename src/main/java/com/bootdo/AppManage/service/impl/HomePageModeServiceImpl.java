package com.bootdo.AppManage.service.impl;

import com.bootdo.common.config.AliyunOSS;
import com.bootdo.common.service.DictService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import com.bootdo.AppManage.dao.HomePageModeDao;
import com.bootdo.AppManage.domain.HomePageModeDO;
import com.bootdo.AppManage.service.HomePageModeService;



@Service
public class HomePageModeServiceImpl implements HomePageModeService {
	@Autowired
	private HomePageModeDao homePageModeDao;
	@Autowired
	private DictService dictService;
	@Autowired
	private AliyunOSS aliyunOSS;
	
	@Override
	public HomePageModeDO get(Integer homePageModeId){
		return homePageModeDao.get(homePageModeId);
	}
	
	@Override
	public List<HomePageModeDO> list(Map<String, Object> map){
		List<HomePageModeDO> homePageModeDOList = homePageModeDao.list(map);
		for (HomePageModeDO homePageModeDO : homePageModeDOList) {
			homePageModeDO.setPosition(dictService.getName("page_mode_position",homePageModeDO.getPosition()));
			homePageModeDO.setJumpType(dictService.getName("page_mode_jump_type",homePageModeDO.getJumpType()));
			homePageModeDO.setLogoClick(aliyunOSS.getCdn()+homePageModeDO.getLogoClick());
			homePageModeDO.setLogoNoClick(aliyunOSS.getCdn()+homePageModeDO.getLogoNoClick());
		}
		return homePageModeDOList;
	}
	
	@Override
	public int count(Map<String, Object> map){
		return homePageModeDao.count(map);
	}
	
	@Override
	public int save(HomePageModeDO homePageMode){
		return homePageModeDao.save(homePageMode);
	}
	
	@Override
	public int update(HomePageModeDO homePageMode){
		return homePageModeDao.update(homePageMode);
	}
	
	@Override
	public int remove(Integer homePageModeId){
		return homePageModeDao.remove(homePageModeId);
	}
	
	@Override
	public int batchRemove(Integer[] homePageModeIds){
		return homePageModeDao.batchRemove(homePageModeIds);
	}
	
}
