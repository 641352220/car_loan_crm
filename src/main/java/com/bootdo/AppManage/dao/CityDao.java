package com.bootdo.AppManage.dao;

import com.bootdo.AppManage.domain.CityDO;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * 城市表
 * @author xgg
 * @email 641352220@qq.com
 * @date 2018-01-04 14:59:49
 */
@Mapper
public interface CityDao {

	List<CityDO> productCity(@Param("id") Integer id,@Param("level") Integer level);

	List<CityDO> businessCity(@Param("id") Integer id,@Param("level") Integer level);
}
