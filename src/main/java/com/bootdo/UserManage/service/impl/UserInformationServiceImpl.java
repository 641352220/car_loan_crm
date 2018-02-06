package com.bootdo.UserManage.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import com.bootdo.UserManage.dao.UserInformationDao;
import com.bootdo.UserManage.domain.UserInformationDO;
import com.bootdo.UserManage.service.UserInformationService;



@Service
public class UserInformationServiceImpl implements UserInformationService {
	@Autowired
	private UserInformationDao userInformationDao;
	
	@Override
	public UserInformationDO get(Integer userId){
		return userInformationDao.get(userId);
	}
	
	@Override
	public List<UserInformationDO> list(Map<String, Object> map){
		return userInformationDao.list(map);
	}
	
	@Override
	public int count(Map<String, Object> map){
		return userInformationDao.count(map);
	}
	
	@Override
	public int save(UserInformationDO information){
		return userInformationDao.save(information);
	}
	
	@Override
	public int update(UserInformationDO information){
		return userInformationDao.update(information);
	}
	
	@Override
	public int remove(Integer userId){
		return userInformationDao.remove(userId);
	}
	
	@Override
	public int batchRemove(Integer[] userIds){
		return userInformationDao.batchRemove(userIds);
	}
	
}
