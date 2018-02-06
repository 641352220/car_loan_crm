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

import com.bootdo.CarManage.domain.ModelDO;
import com.bootdo.CarManage.service.ModelService;
import com.bootdo.common.utils.PageUtils;
import com.bootdo.common.utils.Query;
import com.bootdo.common.utils.R;

/**
 * 车型(例如奥迪A8)
 * 
 * @author xgg
 * @email 641352220@qq.com
 * @date 2018-01-04 16:43:41
 */
 
@Controller
@RequestMapping("/CarManage/model")
public class ModelController {
	@Autowired
	private ModelService modelService;
	
	@GetMapping()
	@RequiresPermissions("CarManage:model:model")
	String Model(){
	    return "CarManage/model/model";
	}
	
	@ResponseBody
	@GetMapping("/list")
	@RequiresPermissions("CarManage:model:model")
	public PageUtils list(@RequestParam Map<String, Object> params){
		//查询列表数据
        Query query = new Query(params);
		List<ModelDO> modelList = modelService.list(query);
		int total = modelService.count(query);
		PageUtils pageUtils = new PageUtils(modelList, total);
		return pageUtils;
	}
	
	@GetMapping("/add")
	@RequiresPermissions("CarManage:model:add")
	String add(){
	    return "CarManage/model/add";
	}

	@GetMapping("/edit/{carModelId}")
	@RequiresPermissions("CarManage:model:edit")
	String edit(@PathVariable("carModelId") Integer carModelId,Model model){
		ModelDO carModel = modelService.get(carModelId);
		model.addAttribute("model", carModel);
	    return "CarManage/model/edit";
	}
	
	/**
	 * 保存
	 */
	@ResponseBody
	@PostMapping("/save")
	@RequiresPermissions("CarManage:model:add")
	public R save( ModelDO model){
		if(modelService.save(model)>0){
			return R.ok();
		}
		return R.error();
	}
	/**
	 * 修改
	 */
	@ResponseBody
	@RequestMapping("/update")
	@RequiresPermissions("CarManage:model:edit")
	public R update( ModelDO model){
		modelService.update(model);
		return R.ok();
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/remove")
	@ResponseBody
	@RequiresPermissions("CarManage:model:remove")
	public R remove( Integer carModelId){
		if(modelService.remove(carModelId)>0){
		return R.ok();
		}
		return R.error();
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/batchRemove")
	@ResponseBody
	@RequiresPermissions("CarManage:model:batchRemove")
	public R remove(@RequestParam("ids[]") Integer[] carModelIds){
		modelService.batchRemove(carModelIds);
		return R.ok();
	}
	
}
