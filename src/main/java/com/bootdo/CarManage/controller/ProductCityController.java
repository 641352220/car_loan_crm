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

import com.bootdo.CarManage.domain.ProductCityDO;
import com.bootdo.CarManage.service.ProductCityService;
import com.bootdo.common.utils.PageUtils;
import com.bootdo.common.utils.Query;
import com.bootdo.common.utils.R;

/**
 * 车贷产品城市关联表
 * 
 * @author xgg
 * @email 641352220@qq.com
 * @date 2018-01-04 16:43:41
 */
 
@Controller
@RequestMapping("/CarManage/productCity")
public class ProductCityController {
	@Autowired
	private ProductCityService productCityService;
	
	@GetMapping()
	@RequiresPermissions("CarManage:productCity:productCity")
	String ProductCity(){
	    return "CarManage/productCity/productCity";
	}
	
	@ResponseBody
	@GetMapping("/list")
	@RequiresPermissions("CarManage:productCity:productCity")
	public PageUtils list(@RequestParam Map<String, Object> params){
		//查询列表数据
        Query query = new Query(params);
		List<ProductCityDO> productCityList = productCityService.list(query);
		int total = productCityService.count(query);
		PageUtils pageUtils = new PageUtils(productCityList, total);
		return pageUtils;
	}
	
	@GetMapping("/add")
	@RequiresPermissions("CarManage:productCity:add")
	String add(){
	    return "CarManage/productCity/add";
	}

	@GetMapping("/edit/{carProductId}")
	@RequiresPermissions("CarManage:productCity:edit")
	String edit(@PathVariable("carProductId") Integer carProductId,Model model){
		ProductCityDO productCity = productCityService.get(carProductId);
		model.addAttribute("productCity", productCity);
	    return "CarManage/productCity/edit";
	}
	
	/**
	 * 保存
	 */
	@ResponseBody
	@PostMapping("/save")
	@RequiresPermissions("CarManage:productCity:add")
	public R save( ProductCityDO productCity){
		if(productCityService.save(productCity)>0){
			return R.ok();
		}
		return R.error();
	}
	/**
	 * 修改
	 */
	@ResponseBody
	@RequestMapping("/update")
	@RequiresPermissions("CarManage:productCity:edit")
	public R update( ProductCityDO productCity){
		productCityService.update(productCity);
		return R.ok();
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/remove")
	@ResponseBody
	@RequiresPermissions("CarManage:productCity:remove")
	public R remove( Integer carProductId){
		if(productCityService.remove(carProductId)>0){
		return R.ok();
		}
		return R.error();
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/batchRemove")
	@ResponseBody
	@RequiresPermissions("CarManage:productCity:batchRemove")
	public R remove(@RequestParam("ids[]") Integer[] carProductIds){
		productCityService.batchRemove(carProductIds);
		return R.ok();
	}

}
