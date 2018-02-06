package com.bootdo.AppManage.service;

import com.bootdo.AppManage.domain.CityDO;

import java.util.List;
import java.util.Map;

/**
 * 城市表
 * 
 * @author xgg
 * @email 641352220@qq.com
 * @date 2018-01-04 14:59:49
 */
public interface CityService {

	List<CityDO> productCity(Integer id,Integer level);

	List<CityDO> businessCity(Integer id,Integer level);
}
