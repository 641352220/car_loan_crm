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

import com.bootdo.CarManage.domain.SubsidiaryDO;
import com.bootdo.CarManage.service.SubsidiaryService;
import com.bootdo.common.utils.PageUtils;
import com.bootdo.common.utils.Query;
import com.bootdo.common.utils.R;

/**
 * 子公司(例如一汽奥迪)
 * 
 * @author xgg
 * @email 641352220@qq.com
 * @date 2018-01-04 16:43:41
 */
 
@Controller
@RequestMapping("/CarManage/subsidiary")
public class SubsidiaryController {
	@Autowired
	private SubsidiaryService subsidiaryService;
	
	@GetMapping()
	@RequiresPermissions("CarManage:subsidiary:subsidiary")
	String Subsidiary(){
	    return "CarManage/subsidiary/subsidiary";
	}
	
	@ResponseBody
	@GetMapping("/list")
	@RequiresPermissions("CarManage:subsidiary:subsidiary")
	public PageUtils list(@RequestParam Map<String, Object> params){
		//查询列表数据
        Query query = new Query(params);
		List<SubsidiaryDO> subsidiaryList = subsidiaryService.list(query);
		int total = subsidiaryService.count(query);
		PageUtils pageUtils = new PageUtils(subsidiaryList, total);
		return pageUtils;
	}
	
	@GetMapping("/add")
	@RequiresPermissions("CarManage:subsidiary:add")
	String add(){
	    return "CarManage/subsidiary/add";
	}

	@GetMapping("/edit/{subsidiaryId}")
	@RequiresPermissions("CarManage:subsidiary:edit")
	String edit(@PathVariable("subsidiaryId") Integer subsidiaryId,Model model){
		SubsidiaryDO subsidiary = subsidiaryService.get(subsidiaryId);
		model.addAttribute("subsidiary", subsidiary);
	    return "CarManage/subsidiary/edit";
	}
	
	/**
	 * 保存
	 */
	@ResponseBody
	@PostMapping("/save")
	@RequiresPermissions("CarManage:subsidiary:add")
	public R save( SubsidiaryDO subsidiary){
		if(subsidiaryService.save(subsidiary)>0){
			return R.ok();
		}
		return R.error();
	}
	/**
	 * 修改
	 */
	@ResponseBody
	@RequestMapping("/update")
	@RequiresPermissions("CarManage:subsidiary:edit")
	public R update( SubsidiaryDO subsidiary){
		subsidiaryService.update(subsidiary);
		return R.ok();
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/remove")
	@ResponseBody
	@RequiresPermissions("CarManage:subsidiary:remove")
	public R remove( Integer subsidiaryId){
		if(subsidiaryService.remove(subsidiaryId)>0){
		return R.ok();
		}
		return R.error();
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/batchRemove")
	@ResponseBody
	@RequiresPermissions("CarManage:subsidiary:batchRemove")
	public R remove(@RequestParam("ids[]") Integer[] subsidiaryIds){
		subsidiaryService.batchRemove(subsidiaryIds);
		return R.ok();
	}
	
}
