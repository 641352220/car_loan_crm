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

import com.bootdo.CarManage.domain.DetailsDO;
import com.bootdo.CarManage.service.DetailsService;
import com.bootdo.common.utils.PageUtils;
import com.bootdo.common.utils.Query;
import com.bootdo.common.utils.R;

/**
 * 汽车详情(很多字段的那个)
 * 
 * @author xgg
 * @email 641352220@qq.com
 * @date 2018-01-04 16:43:41
 */
 
@Controller
@RequestMapping("/CarManage/details")
public class DetailsController {
	@Autowired
	private DetailsService detailsService;
	
	@GetMapping()
	@RequiresPermissions("CarManage:details:details")
	String Details(){
	    return "CarManage/details/details";
	}
	
	@ResponseBody
	@GetMapping("/list")
	@RequiresPermissions("CarManage:details:details")
	public PageUtils list(@RequestParam Map<String, Object> params){
		//查询列表数据
        Query query = new Query(params);
		List<DetailsDO> detailsList = detailsService.list(query);
		int total = detailsService.count(query);
		PageUtils pageUtils = new PageUtils(detailsList, total);
		return pageUtils;
	}
	
	@GetMapping("/add")
	@RequiresPermissions("CarManage:details:add")
	String add(){
	    return "CarManage/details/add";
	}

	@GetMapping("/edit/{carDetailsId}")
	@RequiresPermissions("CarManage:details:edit")
	String edit(@PathVariable("carDetailsId") Integer carDetailsId,Model model){
		DetailsDO details = detailsService.get(carDetailsId);
		model.addAttribute("details", details);
	    return "CarManage/details/edit";
	}
	
	/**
	 * 保存
	 */
	@ResponseBody
	@PostMapping("/save")
	@RequiresPermissions("CarManage:details:add")
	public R save( DetailsDO details){
		if(detailsService.save(details)>0){
			return R.ok();
		}
		return R.error();
	}
	/**
	 * 修改
	 */
	@ResponseBody
	@RequestMapping("/update")
	@RequiresPermissions("CarManage:details:edit")
	public R update( DetailsDO details){
		detailsService.update(details);
		return R.ok();
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/remove")
	@ResponseBody
	@RequiresPermissions("CarManage:details:remove")
	public R remove( Integer carDetailsId){
		if(detailsService.remove(carDetailsId)>0){
		return R.ok();
		}
		return R.error();
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/batchRemove")
	@ResponseBody
	@RequiresPermissions("CarManage:details:batchRemove")
	public R remove(@RequestParam("ids[]") Integer[] carDetailsIds){
		detailsService.batchRemove(carDetailsIds);
		return R.ok();
	}
	
}
