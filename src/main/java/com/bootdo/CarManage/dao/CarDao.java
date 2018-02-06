package com.bootdo.CarManage.dao;

import com.bootdo.CarManage.domain.CarDO;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * 车型下具体的某款车
 * @author xgg
 * @email 641352220@qq.com
 * @date 2018-01-04 16:43:41
 */
@Mapper
public interface CarDao {

	CarDO get(Integer carId);
	
	List<CarDO> list(Map<String, Object> map);
	
	int count(Map<String, Object> map);
	
	int save(CarDO car);
	
	int update(CarDO car);
	
	int remove(Integer car_id);
	
	int batchRemove(Integer[] carIds);

	List<CarDO> CarDOListByCarModelId(@Param("carModelId") Integer carModelId);

	List<CarDO> CarDOListByCarModelIdByFA(@Param("carModelId") Integer carModelId);

	List<CarDO> CarDOListByCarModelIdAndCpii(@Param("carModelId") Integer carModelId,@Param("carProductInformationId") Integer carProductInformationId);

	List<CarDO> listById(@Param("carIdQuery") String carIdQuery);
}
