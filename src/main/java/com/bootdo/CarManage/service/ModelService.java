package com.bootdo.CarManage.service;

import com.bootdo.CarManage.dao.ModelDao;
import com.bootdo.CarManage.domain.ModelDO;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * 车型(例如奥迪A8)
 * 
 * @author xgg
 * @email 641352220@qq.com
 * @date 2018-01-04 16:43:41
 */
public interface ModelService {
	
	ModelDO get(Integer carModelId);
	
	List<ModelDO> list(Map<String, Object> map);
	
	int count(Map<String, Object> map);
	
	int save(ModelDO model);
	
	int update(ModelDO model);
	
	int remove(Integer carModelId);
	
	int batchRemove(Integer[] carModelIds);

	List<ModelDO> ModelDaoListByBrandId(@Param("brandId") Integer brandId);

	List<ModelDO> ModelDaoListByBrandIds(@Param("brandId") String brandId);
}
