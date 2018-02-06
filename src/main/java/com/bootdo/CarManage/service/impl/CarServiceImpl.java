package com.bootdo.CarManage.service.impl;


import com.bootdo.CarManage.dao.BrandDao;
import com.bootdo.CarManage.dao.ModelDao;
import com.bootdo.CarManage.domain.BrandDO;
import com.bootdo.CarManage.domain.CarTreeDO;
import com.bootdo.CarManage.domain.ModelDO;
import com.bootdo.common.domain.Tree;
import com.bootdo.common.utils.BuildTree;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.bootdo.CarManage.dao.CarDao;
import com.bootdo.CarManage.domain.CarDO;
import com.bootdo.CarManage.service.CarService;



@Service
public class CarServiceImpl implements CarService {
	@Autowired
	private CarDao carDao;
	@Autowired
	private BrandDao brandDao;
	@Autowired
	private ModelDao modelDao;
	
	@Override
	public CarDO get(Integer carId){
		return carDao.get(carId);
	}
	
	@Override
	public List<CarDO> list(Map<String, Object> map){
		return carDao.list(map);
	}
	
	@Override
	public int count(Map<String, Object> map){
		return carDao.count(map);
	}
	
	@Override
	public int save(CarDO car){
		return carDao.save(car);
	}
	
	@Override
	public int update(CarDO car){
		return carDao.update(car);
	}
	
	@Override
	public int remove(Integer carId){
		return carDao.remove(carId);
	}
	
	@Override
	public int batchRemove(Integer[] carIds){
		return carDao.batchRemove(carIds);
	}



	@Override
	public Tree<CarTreeDO> getCarTreeDO() {
		List<Tree<CarTreeDO>> trees = new ArrayList<Tree<CarTreeDO>>();
		List<BrandDO> brandDOS = brandDao.BrandDOList();
		for(BrandDO brandDO : brandDOS){
			Tree<CarTreeDO> tree = new Tree<CarTreeDO>();
			tree.setId(brandDO.getBrandId().toString());
			tree.setParentId("0");
			tree.setText(brandDO.getBrandName());
			Map<String, Object> state = new HashMap<>(16);
			state.put("opened", false);
			tree.setState(state);
			trees.add(tree);
		}
		// 默认顶级菜单为０，根据数据库实际情况调整
		Tree<CarTreeDO> t = BuildTree.build(trees);
		return t;
	}

	@Override
	public Tree<CarTreeDO> getCarTreeDOInit(Map<Integer,Integer> brandIds,Map<Integer,Integer> modelIds, Map<Integer,Integer> carIds) {
		List<Tree<CarTreeDO>> trees = new ArrayList<Tree<CarTreeDO>>();
		List<BrandDO> brandDOS = brandDao.BrandDOListByFA();
		for(BrandDO brandDO : brandDOS){
			Tree<CarTreeDO> tree = new Tree<CarTreeDO>();
			if(null != brandIds.get(brandDO.getBrandId())){
				List<ModelDO> modelDOS = modelDao.ModelDaoListByBrandIdByFA(brandDO.getBrandId());
				for(ModelDO modelDO : modelDOS){
//					if(null != modelIds.get(modelDO.getCarModelId())){
						List<CarDO> carDOS = carDao.CarDOListByCarModelIdByFA(modelDO.getCarModelId());
						for(CarDO carDO : carDOS){

								Tree<CarTreeDO> carTree = new Tree<CarTreeDO>();
								carTree.setId(carDO.getCarId().toString());
								carTree.setParentId(modelDO.getCarModelId().toString());
								carTree.setText(carDO.getStyleName());
								Map<String, Object> state = new HashMap<>(16);
								if(null != carIds.get(carDO.getCarId())){
									state.put("opened", true);
									state.put("selected", true);
								}
								carTree.setState(state);
								trees.add(carTree);

						}
						Tree<CarTreeDO> modelDOTree = new Tree<CarTreeDO>();
						modelDOTree.setId(modelDO.getCarModelId().toString());
						modelDOTree.setParentId(brandDO.getBrandId().toString());
						modelDOTree.setText(modelDO.getModelName());
//						Map<String, Object> state = new HashMap<>(16);
//						state.put("opened", true);
//						modelDOTree.setState(state);
						modelDOTree.setChecked(true);
						trees.add(modelDOTree);
//					}
				}
			}
			tree.setId(brandDO.getBrandId().toString());
			tree.setParentId("0");
			tree.setText(brandDO.getBrandName());
			Map<String, Object> state = new HashMap<>(16);
			state.put("opened", false);
			tree.setState(state);
			trees.add(tree);
		}
		// 默认顶级菜单为０，根据数据库实际情况调整
		Tree<CarTreeDO> t = BuildTree.build(trees);
		return t;
	}

	@Override
	public Tree<CarTreeDO> treeTwo(Integer id) {
		List<Tree<CarTreeDO>> trees = new ArrayList<Tree<CarTreeDO>>();
		List<ModelDO> modelDOS = modelDao.ModelDaoListByBrandId(id);
		getModels(modelDOS,trees,false);
		// 默认顶级菜单为０，根据数据库实际情况调整
		Tree<CarTreeDO> t = BuildTree.build(trees);
		return t;
	}

	@Override
	public Tree<CarTreeDO> treeThree(Integer id) {
		List<Tree<CarTreeDO>> trees = new ArrayList<Tree<CarTreeDO>>();
		List<CarDO> carDOS = carDao.CarDOListByCarModelId(id);
		getCars(carDOS,trees,false);
		// 默认顶级菜单为０，根据数据库实际情况调整
		Tree<CarTreeDO> t = BuildTree.build(trees);
		return t;
	}

	@Override
	public Tree<CarTreeDO> getCarTreeDOByCpii(Integer carProductInformationId) {
		List<Tree<CarTreeDO>> trees = new ArrayList<Tree<CarTreeDO>>();
		List<BrandDO> brandDOS = brandDao.BrandDOListByCpii(carProductInformationId);
		for(BrandDO brandDO : brandDOS){
			Tree<CarTreeDO> tree = new Tree<CarTreeDO>();
			tree.setId(brandDO.getBrandId().toString());
			tree.setParentId("0");
			tree.setText(brandDO.getBrandName());
			Map<String, Object> state = new HashMap<>(16);
			state.put("opened", false);
			tree.setState(state);
			trees.add(tree);
		}
		// 默认顶级菜单为０，根据数据库实际情况调整
		Tree<CarTreeDO> t = BuildTree.build(trees);
		return t;
	}

	@Override
	public Tree<CarTreeDO> treeTwoByCpii(Integer id, Integer carProductInformationId) {
		List<Tree<CarTreeDO>> trees = new ArrayList<Tree<CarTreeDO>>();
		List<ModelDO> modelDOS = modelDao.ModelDaoListByBrandIdAndCpii(id,carProductInformationId);
		getModels(modelDOS,trees,false);
		// 默认顶级菜单为０，根据数据库实际情况调整
		Tree<CarTreeDO> t = BuildTree.build(trees);
		return t;
	}

	@Override
	public Tree<CarTreeDO> treeThreeByCpii(Integer id, Integer carProductInformationId) {
		List<Tree<CarTreeDO>> trees = new ArrayList<Tree<CarTreeDO>>();
		List<CarDO> carDOS = carDao.CarDOListByCarModelIdAndCpii(id,carProductInformationId);
		getCars(carDOS,trees,false);
		// 默认顶级菜单为０，根据数据库实际情况调整
		Tree<CarTreeDO> t = BuildTree.build(trees);
		return t;
	}

	@Override
	public List<CarDO> listById(String carIdQuery) {
		return carDao.listById(carIdQuery);
	}

	@Override
	public Tree<CarTreeDO> getCarTreeDOByFA() {
		List<Tree<CarTreeDO>> trees = new ArrayList<Tree<CarTreeDO>>();
		List<BrandDO> brandDOS = brandDao.BrandDOListByFA();
		for(BrandDO brandDO : brandDOS){
			Tree<CarTreeDO> tree = new Tree<CarTreeDO>();
			tree.setId(brandDO.getBrandId().toString());
			tree.setParentId("0");
			tree.setText(brandDO.getBrandName());
			Map<String, Object> state = new HashMap<>(16);
			state.put("opened", false);
			tree.setState(state);
			trees.add(tree);
		}
		// 默认顶级菜单为０，根据数据库实际情况调整
		Tree<CarTreeDO> t = BuildTree.build(trees);
		return t;
	}

	@Override
	public Tree<CarTreeDO> treeTwoByFA(Integer id) {
		List<Tree<CarTreeDO>> trees = new ArrayList<Tree<CarTreeDO>>();
		List<ModelDO> modelDOS = modelDao.ModelDaoListByBrandIdByFA(id);
		getModels(modelDOS,trees,false);
		// 默认顶级菜单为０，根据数据库实际情况调整
		Tree<CarTreeDO> t = BuildTree.build(trees);
		return t;
	}

	@Override
	public Tree<CarTreeDO> treeThreeByFA(Integer id) {
		List<Tree<CarTreeDO>> trees = new ArrayList<Tree<CarTreeDO>>();
		List<CarDO> carDOS = carDao.CarDOListByCarModelIdByFA(id);
		getCars(carDOS,trees,false);
		// 默认顶级菜单为０，根据数据库实际情况调整
		Tree<CarTreeDO> t = BuildTree.build(trees);
		return t;
	}


	public static List<Tree<CarTreeDO>> getModels(List<ModelDO> modelDOS,List<Tree<CarTreeDO>> trees,boolean sf){
		for(ModelDO modelDO : modelDOS){
			Tree<CarTreeDO> tree = new Tree<CarTreeDO>();
			tree.setId(modelDO.getCarModelId().toString());
			tree.setParentId(null);
			tree.setText(modelDO.getModelName());
			Map<String, Object> state = new HashMap<>(16);
			state.put("opened", sf);
			tree.setState(state);
			trees.add(tree);
		}
		return trees;
	}

	public static List<Tree<CarTreeDO>> getCars(List<CarDO> carDOS,List<Tree<CarTreeDO>> trees,boolean sf){
		for(CarDO carDO : carDOS){
			Tree<CarTreeDO> tree = new Tree<CarTreeDO>();
			tree.setId(carDO.getCarId().toString());
			tree.setParentId(null);
			tree.setText(carDO.getStyleName());
			Map<String, Object> state = new HashMap<>(16);
			state.put("opened", sf);
			tree.setState(state);
			trees.add(tree);
		}
		return trees;
	}
}
