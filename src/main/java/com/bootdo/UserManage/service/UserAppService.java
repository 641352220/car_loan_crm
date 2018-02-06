package com.bootdo.UserManage.service;

import com.bootdo.UserManage.domain.UserAppDO;

import java.util.List;
import java.util.Map;

/**
 * 用户表
 * 
 * @author xgg
 * @email 641352220@qq.com
 * @date 2018-01-10 14:57:10
 */
public interface UserAppService {

	UserAppDO get(Integer userId);
	
	List<UserAppDO> list(Map<String, Object> map);
	
	int count(Map<String, Object> map);
	
	int save(UserAppDO user);
	
	int update(UserAppDO user);
	
	int remove(Integer userId);
	
	int batchRemove(Integer[] userIds);
}
