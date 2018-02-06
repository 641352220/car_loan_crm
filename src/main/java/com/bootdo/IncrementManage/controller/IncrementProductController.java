package com.bootdo.IncrementManage.controller;

import java.util.List;
import java.util.Map;

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

import com.bootdo.IncrementManage.domain.IncrementProductDO;
import com.bootdo.IncrementManage.service.IncrementProductService;
import com.bootdo.common.utils.PageUtils;
import com.bootdo.common.utils.Query;
import com.bootdo.common.utils.R;

/**
 * 增值产品表
 * 
 * @author xgg
 * @email 641352220@qq.com
 * @date 2018-01-10 13:13:11
 */
 
@Controller
@RequestMapping("/IncrementManage/product")
public class IncrementProductController {
	@Autowired
	private IncrementProductService incrementProductService;
	
	@GetMapping()
	@RequiresPermissions("IncrementManage:product:product")
	String Product(){
	    return "IncrementManage/product/product";
	}
	
	@ResponseBody
	@GetMapping("/list")
	@RequiresPermissions("IncrementManage:product:product")
	public PageUtils list(@RequestParam Map<String, Object> params){
		//查询列表数据
        Query query = new Query(params);
		List<IncrementProductDO> productList = incrementProductService.list(query);
		int total = incrementProductService.count(query);
		PageUtils pageUtils = new PageUtils(productList, total);
		return pageUtils;
	}
	
	@GetMapping("/add")
	@RequiresPermissions("IncrementManage:product:add")
	String add(){
	    return "IncrementManage/product/add";
	}

	@GetMapping("/edit/{productId}")
	@RequiresPermissions("IncrementManage:product:edit")
	String edit(@PathVariable("productId") Integer productId,Model model){
		IncrementProductDO product = incrementProductService.get(productId);
		model.addAttribute("product", product);
	    return "IncrementManage/product/edit";
	}
	
	/**
	 * 保存
	 */
	@ResponseBody
	@PostMapping("/save")
	@RequiresPermissions("IncrementManage:product:add")
	public R save(@RequestParam Map<String,Object> param, IncrementProductDO product){
		if(incrementProductService.save(product)>0){
			return R.ok();
		}
		return R.error();
	}
	/**
	 * 修改
	 */
	@ResponseBody
	@RequestMapping("/update")
	@RequiresPermissions("IncrementManage:product:edit")
	public R update(@RequestParam Map<String,Object> param, IncrementProductDO product){
		incrementProductService.update(product);
		return R.ok();
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/remove")
	@ResponseBody
	@RequiresPermissions("IncrementManage:product:remove")
	public R remove( Integer productId){
		if(incrementProductService.remove(productId)>0){
		return R.ok();
		}
		return R.error();
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/batchRemove")
	@ResponseBody
	@RequiresPermissions("IncrementManage:product:batchRemove")
	public R remove(@RequestParam("ids[]") Integer[] productIds){
		incrementProductService.batchRemove(productIds);
		return R.ok();
	}
	
}
