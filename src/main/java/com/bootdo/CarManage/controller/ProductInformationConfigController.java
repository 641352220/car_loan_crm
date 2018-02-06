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

import com.bootdo.CarManage.domain.ProductInformationConfigDO;
import com.bootdo.CarManage.service.ProductInformationConfigService;
import com.bootdo.common.utils.PageUtils;
import com.bootdo.common.utils.Query;
import com.bootdo.common.utils.R;

/**
 * 车贷报价方案期限利率详情表,一个方案可以有多条首付和期限
 * 
 * @author xgg
 * @email 641352220@qq.com
 * @date 2018-01-04 16:43:41
 */
 
@Controller
@RequestMapping("/CarManage/productInformationConfig")
public class ProductInformationConfigController {
	@Autowired
	private ProductInformationConfigService productInformationConfigService;
	
	@GetMapping()
	@RequiresPermissions("CarManage:productInformationConfig:productInformationConfig")
	String ProductInformationConfig(){
	    return "CarManage/productInformationConfig/productInformationConfig";
	}
	
	@ResponseBody
	@GetMapping("/list")
	@RequiresPermissions("CarManage:productInformationConfig:productInformationConfig")
	public PageUtils list(@RequestParam Map<String, Object> params){
		//查询列表数据
        Query query = new Query(params);
		List<ProductInformationConfigDO> productInformationConfigList = productInformationConfigService.list(query);
		int total = productInformationConfigService.count(query);
		PageUtils pageUtils = new PageUtils(productInformationConfigList, total);
		return pageUtils;
	}
	
	@GetMapping("/add")
	@RequiresPermissions("CarManage:productInformationConfig:add")
	String add(){
	    return "CarManage/productInformationConfig/add";
	}

	
	/**
	 * 保存
	 */
	@ResponseBody
	@PostMapping("/save")
	@RequiresPermissions("CarManage:productInformationConfig:add")
	public R save( ProductInformationConfigDO productInformationConfig){
		if(productInformationConfigService.save(productInformationConfig)>0){
			return R.ok();
		}
		return R.error();
	}
	/**
	 * 修改
	 */
	@ResponseBody
	@RequestMapping("/update")
	@RequiresPermissions("CarManage:productInformationConfig:edit")
	public R update( ProductInformationConfigDO productInformationConfig){
		productInformationConfigService.update(productInformationConfig);
		return R.ok();
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/remove")
	@ResponseBody
	@RequiresPermissions("CarManage:productInformationConfig:remove")
	public R remove( Integer carProductInformationId){
		if(productInformationConfigService.remove(carProductInformationId)>0){
		return R.ok();
		}
		return R.error();
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/batchRemove")
	@ResponseBody
	@RequiresPermissions("CarManage:productInformationConfig:batchRemove")
	public R remove(@RequestParam("ids[]") Integer[] carProductInformationIds){
		productInformationConfigService.batchRemove(carProductInformationIds);
		return R.ok();
	}
	
}
