package com.bootdo.CarManage.dao;

import com.bootdo.CarManage.domain.ModelDO;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * 车型(例如奥迪A8)
 * @author xgg
 * @email 641352220@qq.com
 * @date 2018-01-04 16:43:41
 */
@Mapper
public interface ModelDao {

	ModelDO get(Integer carModelId);
	
	List<ModelDO> list(Map<String, Object> map);
	
	int count(Map<String, Object> map);
	
	int save(ModelDO model);
	
	int update(ModelDO model);
	
	int remove(Integer car_model_id);
	
	int batchRemove(Integer[] carModelIds);

	List<ModelDO> ModelDaoListByBrandId(@Param("brandId") Integer brandId);

	List<ModelDO> ModelDaoListByBrandIdByFA(@Param("brandId") Integer brandId);

	List<ModelDO> ModelDaoListByBrandIds(@Param("brandIds") String brandIds);

	List<ModelDO> ModelDaoListByBrandIdAndCpii(@Param("brandId") Integer brandId,@Param("carProductInformationId") Integer carProductInformationId);
}
