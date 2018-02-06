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
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bootdo.IncrementManage.domain.ProductClickRecordDO;
import com.bootdo.IncrementManage.service.ProductClickRecordService;
import com.bootdo.common.utils.PageUtils;
import com.bootdo.common.utils.Query;
import com.bootdo.common.utils.R;

/**
 * 增值产品点击记录
 * 
 * @author xgg
 * @email 641352220@qq.com
 * @date 2018-01-10 13:13:12
 */
 
@Controller
@RequestMapping("/IncrementManage/productClickRecord")
public class ProductClickRecordController {
	@Autowired
	private ProductClickRecordService productClickRecordService;
	
	@GetMapping()
	@RequiresPermissions("IncrementManage:productClickRecord:productClickRecord")
	String ProductClickRecord(){
	    return "IncrementManage/productClickRecord/productClickRecord";
	}
	
	@ResponseBody
	@GetMapping("/list")
	@RequiresPermissions("IncrementManage:productClickRecord:productClickRecord")
	public PageUtils list(@RequestParam Map<String, Object> params){
		//查询列表数据
        Query query = new Query(params);
		List<ProductClickRecordDO> productClickRecordList = productClickRecordService.list(query);
		int total = productClickRecordService.count(query);
		PageUtils pageUtils = new PageUtils(productClickRecordList, total);
		return pageUtils;
	}
	
	@GetMapping("/add")
	@RequiresPermissions("IncrementManage:productClickRecord:add")
	String add(){
	    return "IncrementManage/productClickRecord/add";
	}

	@GetMapping("/edit/{incrementProductId}")
	@RequiresPermissions("IncrementManage:productClickRecord:edit")
	String edit(@PathVariable("incrementProductId") Integer incrementProductId,Model model){
		ProductClickRecordDO productClickRecord = productClickRecordService.get(incrementProductId);
		model.addAttribute("productClickRecord", productClickRecord);
	    return "IncrementManage/productClickRecord/edit";
	}
	
	/**
	 * 保存
	 */
	@ResponseBody
	@PostMapping("/save")
	@RequiresPermissions("IncrementManage:productClickRecord:add")
	public R save( ProductClickRecordDO productClickRecord){
		if(productClickRecordService.save(productClickRecord)>0){
			return R.ok();
		}
		return R.error();
	}
	/**
	 * 修改
	 */
	@ResponseBody
	@RequestMapping("/update")
	@RequiresPermissions("IncrementManage:productClickRecord:edit")
	public R update( ProductClickRecordDO productClickRecord){
		productClickRecordService.update(productClickRecord);
		return R.ok();
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/remove")
	@ResponseBody
	@RequiresPermissions("IncrementManage:productClickRecord:remove")
	public R remove( Integer incrementProductId){
		if(productClickRecordService.remove(incrementProductId)>0){
		return R.ok();
		}
		return R.error();
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/batchRemove")
	@ResponseBody
	@RequiresPermissions("IncrementManage:productClickRecord:batchRemove")
	public R remove(@RequestParam("ids[]") Integer[] incrementProductIds){
		productClickRecordService.batchRemove(incrementProductIds);
		return R.ok();
	}
	
}
