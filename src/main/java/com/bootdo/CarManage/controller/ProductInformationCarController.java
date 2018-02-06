package com.bootdo.CarManage.controller;

import java.util.List;
import java.util.Map;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bootdo.CarManage.domain.ProductInformationCarDO;
import com.bootdo.CarManage.service.ProductInformationCarService;
import com.bootdo.common.utils.PageUtils;
import com.bootdo.common.utils.Query;
import com.bootdo.common.utils.R;

/**
 * 汽车产品补充表关联汽车表,一个方案支持多款车
 * 
 * @author xgg
 * @email 641352220@qq.com
 * @date 2018-01-04 16:43:41
 */
 
@Controller
@RequestMapping("/CarManage/productInformationCar")
public class ProductInformationCarController {
	@Autowired
	private ProductInformationCarService productInformationCarService;
	
	@GetMapping()
	@RequiresPermissions("CarManage:productInformationCar:productInformationCar")
	String ProductInformationCar(){
	    return "CarManage/productInformationCar/productInformationCar";
	}
	
	@ResponseBody
	@GetMapping("/list")
	@RequiresPermissions("CarManage:productInformationCar:productInformationCar")
	public PageUtils list(@RequestParam Map<String, Object> params){
		//查询列表数据
        Query query = new Query(params);
		List<ProductInformationCarDO> productInformationCarList = productInformationCarService.list(query);
		int total = productInformationCarService.count(query);
		PageUtils pageUtils = new PageUtils(productInformationCarList, total);
		return pageUtils;
	}
	
	@GetMapping("/add")
	@RequiresPermissions("CarManage:productInformationCar:add")
	String add(){
	    return "CarManage/productInformationCar/add";
	}

	
	/**
	 * 保存
	 */
	@ResponseBody
	@PostMapping("/save")
	@RequiresPermissions("CarManage:productInformationCar:add")
	public R save( ProductInformationCarDO productInformationCar){
		if(productInformationCarService.save(productInformationCar)>0){
			return R.ok();
		}
		return R.error();
	}
	/**
	 * 修改
	 */
	@ResponseBody
	@RequestMapping("/update")
	@RequiresPermissions("CarManage:productInformationCar:edit")
	public R update( ProductInformationCarDO productInformationCar){
		productInformationCarService.update(productInformationCar);
		return R.ok();
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/remove")
	@ResponseBody
	@RequiresPermissions("CarManage:productInformationCar:remove")
	public R remove( Integer businessId){
		if(productInformationCarService.remove(businessId)>0){
		return R.ok();
		}
		return R.error();
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/batchRemove")
	@ResponseBody
	@RequiresPermissions("CarManage:productInformationCar:batchRemove")
	public R remove(@RequestParam("ids[]") Integer[] businessIds){
		productInformationCarService.batchRemove(businessIds);
		return R.ok();
	}
	
}
