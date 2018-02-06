package com.bootdo.CarManage.service;

import com.bootdo.AdverManage.domain.AdverCarDO;
import com.bootdo.CarManage.domain.CarDO;
import com.bootdo.CarManage.domain.CarTreeDO;
import com.bootdo.common.domain.Tree;

import java.util.List;
import java.util.Map;

/**
 * 车型下具体的某款车
 * 
 * @author xgg
 * @email 641352220@qq.com
 * @date 2018-01-04 16:43:41
 */
public interface CarService {
	
	CarDO get(Integer carId);
	
	List<CarDO> list(Map<String, Object> map);
	
	int count(Map<String, Object> map);
	
	int save(CarDO car);
	
	int update(CarDO car);
	
	int remove(Integer carId);
	
	int batchRemove(Integer[] carIds);

	Tree<CarTreeDO> getCarTreeDO();

	Tree<CarTreeDO> getCarTreeDOInit(Map<Integer,Integer> brandIds,Map<Integer,Integer> modelIds,Map<Integer,Integer> carIds);

	Tree<CarTreeDO> treeTwo(Integer id);

	Tree<CarTreeDO> treeThree(Integer id);

	Tree<CarTreeDO> getCarTreeDOByCpii(Integer carProductInformationId);

	Tree<CarTreeDO> treeTwoByCpii(Integer id,Integer carProductInformationId);

	Tree<CarTreeDO> treeThreeByCpii(Integer id,Integer carProductInformationId);

	List<CarDO> listById(String carIdQuery);

	Tree<CarTreeDO> getCarTreeDOByFA();

	Tree<CarTreeDO> treeTwoByFA(Integer id);

	Tree<CarTreeDO> treeThreeByFA(Integer id);

}
