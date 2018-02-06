package com.bootdo.UserManage.service.impl;

import com.bootdo.common.service.DictService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import com.bootdo.UserManage.domain.UserAppDO;
import com.bootdo.UserManage.service.UserAppService;
import com.bootdo.UserManage.dao.UserAppDao;


@Service
public class UserAppAppServiceImpl implements UserAppService {
	@Autowired
	private UserAppDao userDao;
	@Autowired
	private DictService dictService;
	
	@Override
	public UserAppDO get(Integer userId){
		return userDao.get(userId);
	}
	
	@Override
	public List<UserAppDO> list(Map<String, Object> map){
		List<UserAppDO> list = userDao.list(map);
		for(UserAppDO userAppDao : list){
			userAppDao.setLoginType(dictService.getName("user_login_type",userAppDao.getLoginType()));
		}
		return list;
	}
	
	@Override
	public int count(Map<String, Object> map){
		return userDao.count(map);
	}
	
	@Override
	public int save(UserAppDO user){
		return userDao.save(user);
	}
	
	@Override
	public int update(UserAppDO user){
		return userDao.update(user);
	}
	
	@Override
	public int remove(Integer userId){
		return userDao.remove(userId);
	}
	
	@Override
	public int batchRemove(Integer[] userIds){
		return userDao.batchRemove(userIds);
	}
	
}
