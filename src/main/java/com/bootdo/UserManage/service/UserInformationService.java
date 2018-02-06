package com.bootdo.UserManage.service;

import com.bootdo.UserManage.domain.UserInformationDO;

import java.util.List;
import java.util.Map;

/**
 * 用户信息补充表
 * 
 * @author xgg
 * @email 641352220@qq.com
 * @date 2018-01-10 14:57:10
 */
public interface UserInformationService {
	
	UserInformationDO get(Integer userId);
	
	List<UserInformationDO> list(Map<String, Object> map);
	
	int count(Map<String, Object> map);
	
	int save(UserInformationDO information);
	
	int update(UserInformationDO information);
	
	int remove(Integer userId);
	
	int batchRemove(Integer[] userIds);
}
