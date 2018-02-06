package com.bootdo.AppManage.dao;

import com.bootdo.AppManage.domain.ConfigDO;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

/**
 * app常量
 * @author xgg
 * @email 641352220@qq.com
 * @date 2018-01-04 14:59:49
 */
@Mapper
public interface ConfigDao {

	ConfigDO get(String name);
	
	List<ConfigDO> list();
	
	int save(ConfigDO config);
	
	int update(ConfigDO config);

}
