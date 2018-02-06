package com.bootdo.UserManage.dao;

import com.bootdo.UserManage.domain.UserInformationDO;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

/**
 * 用户信息补充表
 * @author xgg
 * @email 641352220@qq.com
 * @date 2018-01-10 14:57:10
 */
@Mapper
public interface UserInformationDao {

	UserInformationDO get(Integer userId);
	
	List<UserInformationDO> list(Map<String, Object> map);
	
	int count(Map<String, Object> map);
	
	int save(UserInformationDO information);
	
	int update(UserInformationDO information);
	
	int remove(Integer user_id);
	
	int batchRemove(Integer[] userIds);
}
