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

import com.bootdo.CarManage.domain.TypeRelationDO;
import com.bootdo.CarManage.service.TypeRelationService;
import com.bootdo.common.utils.PageUtils;
import com.bootdo.common.utils.Query;
import com.bootdo.common.utils.R;

/**
 * 汽车类型关联表
 * 
 * @author xgg
 * @email 641352220@qq.com
 * @date 2018-01-04 16:43:41
 */
 
@Controller
@RequestMapping("/CarManage/typeRelation")
public class TypeRelationController {
	@Autowired
	private TypeRelationService typeRelationService;
	
	@GetMapping()
	@RequiresPermissions("CarManage:typeRelation:typeRelation")
	String TypeRelation(){
	    return "CarManage/typeRelation/typeRelation";
	}
	
	@ResponseBody
	@GetMapping("/list")
	@RequiresPermissions("CarManage:typeRelation:typeRelation")
	public PageUtils list(@RequestParam Map<String, Object> params){
		//查询列表数据
        Query query = new Query(params);
		List<TypeRelationDO> typeRelationList = typeRelationService.list(query);
		int total = typeRelationService.count(query);
		PageUtils pageUtils = new PageUtils(typeRelationList, total);
		return pageUtils;
	}
	
	@GetMapping("/add")
	@RequiresPermissions("CarManage:typeRelation:add")
	String add(){
	    return "CarManage/typeRelation/add";
	}

	@GetMapping("/edit/{paramString}")
	@RequiresPermissions("CarManage:typeRelation:edit")
	String edit(@PathVariable("paramString") String paramString,Model model){
		String[] params = paramString.split(",");
		Integer carId = Integer.parseInt(params[0]);
		Integer carTypeId = Integer.parseInt(params[1]);
		TypeRelationDO typeRelation = typeRelationService.get(carId,carTypeId);
		model.addAttribute("typeRelation", typeRelation);
	    return "CarManage/typeRelation/edit";
	}
	
	/**
	 * 保存
	 */
	@ResponseBody
	@PostMapping("/save")
	@RequiresPermissions("CarManage:typeRelation:add")
	public R save( TypeRelationDO typeRelation){
		if(typeRelationService.save(typeRelation)>0){
			return R.ok();
		}
		return R.error();
	}
	/**
	 * 修改
	 */
	@ResponseBody
	@RequestMapping("/update")
	@RequiresPermissions("CarManage:typeRelation:edit")
	public R update( TypeRelationDO typeRelation){
		typeRelationService.update(typeRelation);
		return R.ok();
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/remove")
	@ResponseBody
	@RequiresPermissions("CarManage:typeRelation:remove")
	public R remove( Integer carId){
		if(typeRelationService.remove(carId)>0){
		return R.ok();
		}
		return R.error();
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/batchRemove")
	@ResponseBody
	@RequiresPermissions("CarManage:typeRelation:batchRemove")
	public R remove(@RequestParam("ids[]") Integer[] carIds){
		typeRelationService.batchRemove(carIds);
		return R.ok();
	}
	
}
