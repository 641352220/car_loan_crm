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

import com.bootdo.CarManage.domain.TypeDO;
import com.bootdo.CarManage.service.TypeService;
import com.bootdo.common.utils.PageUtils;
import com.bootdo.common.utils.Query;
import com.bootdo.common.utils.R;

/**
 * 汽车类型表
 * 
 * @author xgg
 * @email 641352220@qq.com
 * @date 2018-01-04 16:43:41
 */
 
@Controller
@RequestMapping("/CarManage/type")
public class TypeController {
	@Autowired
	private TypeService typeService;
	
	@GetMapping()
	@RequiresPermissions("CarManage:type:type")
	String Type(){
	    return "CarManage/type/type";
	}
	
	@ResponseBody
	@GetMapping("/list")
	@RequiresPermissions("CarManage:type:type")
	public PageUtils list(@RequestParam Map<String, Object> params){
		//查询列表数据
        Query query = new Query(params);
		List<TypeDO> typeList = typeService.list(query);
		int total = typeService.count(query);
		PageUtils pageUtils = new PageUtils(typeList, total);
		return pageUtils;
	}
	
	@GetMapping("/add")
	@RequiresPermissions("CarManage:type:add")
	String add(){
	    return "CarManage/type/add";
	}

	@GetMapping("/edit/{carTypeId}")
	@RequiresPermissions("CarManage:type:edit")
	String edit(@PathVariable("carTypeId") Integer carTypeId,Model model){
		TypeDO type = typeService.get(carTypeId);
		model.addAttribute("type", type);
	    return "CarManage/type/edit";
	}
	
	/**
	 * 保存
	 */
	@ResponseBody
	@PostMapping("/save")
	@RequiresPermissions("CarManage:type:add")
	public R save( TypeDO type){
		if(typeService.save(type)>0){
			return R.ok();
		}
		return R.error();
	}
	/**
	 * 修改
	 */
	@ResponseBody
	@RequestMapping("/update")
	@RequiresPermissions("CarManage:type:edit")
	public R update( TypeDO type){
		typeService.update(type);
		return R.ok();
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/remove")
	@ResponseBody
	@RequiresPermissions("CarManage:type:remove")
	public R remove( Integer carTypeId){
		if(typeService.remove(carTypeId)>0){
		return R.ok();
		}
		return R.error();
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/batchRemove")
	@ResponseBody
	@RequiresPermissions("CarManage:type:batchRemove")
	public R remove(@RequestParam("ids[]") Integer[] carTypeIds){
		typeService.batchRemove(carTypeIds);
		return R.ok();
	}

	@ResponseBody
	@GetMapping("/nameList")
	public List<TypeDO> nameList(){
		//查询列表数据
		List<TypeDO> productList = typeService.nameList();
		return productList;
	}
	
}
