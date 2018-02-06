package com.bootdo.CarManage.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.bootdo.AdverManage.domain.AdverCarDO;
import com.bootdo.AdverManage.service.AdverCarService;
import com.bootdo.CarManage.domain.CarTreeDO;
import com.bootdo.CarManage.service.ProductInformationService;
import com.bootdo.common.domain.Tree;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bootdo.CarManage.domain.CarDO;
import com.bootdo.CarManage.service.CarService;
import com.bootdo.common.utils.PageUtils;
import com.bootdo.common.utils.Query;
import com.bootdo.common.utils.R;

/**
 * 车型下具体的某款车
 * 
 * @author xgg
 * @email 641352220@qq.com
 * @date 2018-01-04 16:43:41
 */
 
@Controller
@RequestMapping("/CarManage/car")
public class CarController {
	@Autowired
	private CarService carService;
	@Autowired
	private ProductInformationService productInformationService;
	@Autowired
	private AdverCarService adverCarService;
	
	@GetMapping()
	@RequiresPermissions("CarManage:car:car")
	String Car(){
	    return "CarManage/car/car";
	}
	
	@ResponseBody
	@GetMapping("/list")
	@RequiresPermissions("CarManage:car:car")
	public PageUtils list(@RequestParam Map<String, Object> params){
		//查询列表数据
        Query query = new Query(params);
		List<CarDO> carList = carService.list(query);
		int total = carService.count(query);
		PageUtils pageUtils = new PageUtils(carList, total);
		return pageUtils;
	}
	

	@GetMapping("/treeByFA")
	@ResponseBody
	public Tree<CarTreeDO> treeByFA() {
		Tree<CarTreeDO> tree = new Tree<CarTreeDO>();
		tree = carService.getCarTreeDOByFA();
		return tree;
	}

	@GetMapping("/treeTwoByFA")
	@ResponseBody
	public Tree<CarTreeDO> treeTwoByFA(Integer id) {
		Tree<CarTreeDO> tree = new Tree<CarTreeDO>();
		tree = carService.treeTwoByFA(id);
		return tree;
	}

	@GetMapping("/treeThreeByFA")
	@ResponseBody
	public Tree<CarTreeDO> treeThreeByFA(Integer id) {
		Tree<CarTreeDO> tree = new Tree<CarTreeDO>();
		tree = carService.treeThreeByFA(id);
		return tree;
	}

	@GetMapping("/treeInit")
	@ResponseBody
	public Map<String,Object> treeInit(Integer id) {
		Map<String,Object> map = new HashMap<>();
		String  brandIdsR = null;
		String  modelIdsR = null;
		List<Integer> brandIdList = productInformationService.getBrandIds(id);
		Map<Integer,Integer> brandIds = new HashMap<>();
		for(Integer brandId : brandIdList){
			brandIds.put(brandId,brandId);
			if(null == brandIdsR){
				brandIdsR = brandId+"";
			}else{
				brandIdsR = brandIdsR + "," + brandId;
			}
		}
		List<Integer> modelIdList = productInformationService.getModelIds(id);
		Map<Integer,Integer> modelIds = new HashMap<>();
		for(Integer modelId : modelIdList){
			modelIds.put(modelId,modelId);
			if(null == modelIdsR){
				modelIdsR = modelId+"";
			}else{
				modelIdsR = modelIdsR + "," + modelId;
			}
		}
		List<Integer> carIdList = productInformationService.getCarIds(id);
		Map<Integer,Integer> carIds = new HashMap<>();
		for(Integer carId : carIdList){
			carIds.put(carId,carId);
		}
		Tree<CarTreeDO> tree = new Tree<CarTreeDO>();
		tree = carService.getCarTreeDOInit(brandIds,modelIds,carIds);
		map.put("tree",tree);
		if(null != modelIdsR){
			map.put("modelIds",modelIdsR.split(","));
		}
		if(null != brandIdsR) {
			map.put("brandIds", brandIdsR.split(","));
		}
		return map;
	}

	@GetMapping("/tree")
	@ResponseBody
	public Tree<CarTreeDO> tree() {
		Tree<CarTreeDO> tree = new Tree<CarTreeDO>();
		tree = carService.getCarTreeDO();
		return tree;
	}



	@GetMapping("/treeTwo")
	@ResponseBody
	public Tree<CarTreeDO> treeTwo(Integer id) {
		Tree<CarTreeDO> tree = new Tree<CarTreeDO>();
		tree = carService.treeTwo(id);
		return tree;
	}

	@GetMapping("/treeThree")
	@ResponseBody
	public Tree<CarTreeDO> treeThree(Integer id) {
		Tree<CarTreeDO> tree = new Tree<CarTreeDO>();
		tree = carService.treeThree(id);
		return tree;
	}



	@GetMapping("/carTreeView/{carProductInformationId}")
	String carTreeViewByCpii(@PathVariable("carProductInformationId") Integer carProductInformationId,Model model) {
		model.addAttribute("carProductInformationId",carProductInformationId);
		return  "CarManage/car/carTreeByCpii";
	}

	@GetMapping("/carTreeView")
	String carTreeView() {
		return  "CarManage/car/carTree";
	}

	@GetMapping("/treeByCpii")
	@ResponseBody
	public Tree<CarTreeDO> treeByCpii(Integer carProductInformationId) {
		Tree<CarTreeDO> tree = new Tree<CarTreeDO>();
		tree = carService.getCarTreeDOByCpii(carProductInformationId);
		return tree;
	}

	@GetMapping("/treeTwoByCpii")
	@ResponseBody
	public Tree<CarTreeDO> treeTwoByCpii(Integer id,Integer carProductInformationId) {
		Tree<CarTreeDO> tree = new Tree<CarTreeDO>();
		tree = carService.treeTwoByCpii(id,carProductInformationId);
		return tree;
	}

	@GetMapping("/treeThreeByCpii")
	@ResponseBody
	public Tree<CarTreeDO> treeThreeByCpii(Integer id,Integer carProductInformationId) {
		Tree<CarTreeDO> tree = new Tree<CarTreeDO>();
		tree = carService.treeThreeByCpii(id,carProductInformationId);
		return tree;
	}
}
