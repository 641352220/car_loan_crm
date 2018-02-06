package com.bootdo.AppManage.controller;

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

import com.bootdo.AppManage.domain.HomePageModeDO;
import com.bootdo.AppManage.service.HomePageModeService;
import com.bootdo.common.utils.PageUtils;
import com.bootdo.common.utils.Query;
import com.bootdo.common.utils.R;

/**
 * 模块表
 * 
 * @author xgg
 * @email 641352220@qq.com
 * @date 2018-01-04 14:59:49
 */
 
@Controller
@RequestMapping("/AppManage/homePageMode")
public class HomePageModeController {
	@Autowired
	private HomePageModeService homePageModeService;
	
	@GetMapping()
	@RequiresPermissions("AppManage:homePageMode:homePageMode")
	String HomePageMode(){
	    return "AppManage/homePageMode/homePageMode";
	}
	
	@ResponseBody
	@GetMapping("/list")
	@RequiresPermissions("AppManage:homePageMode:homePageMode")
	public PageUtils list(@RequestParam Map<String, Object> params){
		//查询列表数据
        Query query = new Query(params);
		List<HomePageModeDO> homePageModeList = homePageModeService.list(query);
		int total = homePageModeService.count(query);
		PageUtils pageUtils = new PageUtils(homePageModeList, total);
		return pageUtils;
	}
	
	@GetMapping("/add")
	@RequiresPermissions("AppManage:homePageMode:add")
	String add(){
	    return "AppManage/homePageMode/add";
	}

	@GetMapping("/edit/{homePageModeId}")
	@RequiresPermissions("AppManage:homePageMode:edit")
	String edit(@PathVariable("homePageModeId") Integer homePageModeId,Model model){
		HomePageModeDO homePageMode = homePageModeService.get(homePageModeId);
		model.addAttribute("homePageMode", homePageMode);
	    return "AppManage/homePageMode/edit";
	}
	
	/**
	 * 保存
	 */
	@ResponseBody
	@PostMapping("/save")
	@RequiresPermissions("AppManage:homePageMode:add")
	public R save( HomePageModeDO homePageMode){
		System.out.println(homePageMode.toString());
		if(homePageModeService.save(homePageMode)>0){
			return R.ok();
		}
		return R.error();
	}
	/**
	 * 修改
	 */
	@ResponseBody
	@RequestMapping("/update")
	@RequiresPermissions("AppManage:homePageMode:edit")
	public R update( HomePageModeDO homePageMode){
		homePageModeService.update(homePageMode);
		return R.ok();
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/remove")
	@ResponseBody
	@RequiresPermissions("AppManage:homePageMode:remove")
	public R remove( Integer homePageModeId){
		if(homePageModeService.remove(homePageModeId)>0){
		return R.ok();
		}
		return R.error();
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/batchRemove")
	@ResponseBody
	@RequiresPermissions("AppManage:homePageMode:batchRemove")
	public R remove(@RequestParam("ids[]") Integer[] homePageModeIds){
		homePageModeService.batchRemove(homePageModeIds);
		return R.ok();
	}
	
}
