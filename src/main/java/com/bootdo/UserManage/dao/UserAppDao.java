package com.bootdo.UserManage.dao;

import com.bootdo.UserManage.domain.UserAppDO;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

/**
 * 用户表
 * @author xgg
 * @email 641352220@qq.com
 * @date 2018-01-10 14:57:10
 */
@Mapper
public interface UserAppDao {

	UserAppDO get(Integer userId);
	
	List<UserAppDO> list(Map<String, Object> map);
	
	int count(Map<String, Object> map);
	
	int save(UserAppDO user);
	
	int update(UserAppDO user);
	
	int remove(Integer user_id);
	
	int batchRemove(Integer[] userIds);
}
