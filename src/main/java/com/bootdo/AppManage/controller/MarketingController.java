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

import com.bootdo.AppManage.domain.MarketingDO;
import com.bootdo.AppManage.service.MarketingService;
import com.bootdo.common.utils.PageUtils;
import com.bootdo.common.utils.Query;
import com.bootdo.common.utils.R;

/**
 * 首页营销模块
 * 
 * @author xgg
 * @email 641352220@qq.com
 * @date 2018-01-04 14:59:49
 */
 
@Controller
@RequestMapping("/AppManage/marketing")
public class MarketingController {
	@Autowired
	private MarketingService marketingService;
	
	@GetMapping()
	@RequiresPermissions("AppManage:marketing:marketing")
	String Marketing(){
	    return "AppManage/marketing/marketing";
	}
	
	@ResponseBody
	@GetMapping("/list")
	@RequiresPermissions("AppManage:marketing:marketing")
	public PageUtils list(@RequestParam Map<String, Object> params){
		//查询列表数据
        Query query = new Query(params);
		List<MarketingDO> marketingList = marketingService.list(query);
		int total = marketingService.count(query);
		PageUtils pageUtils = new PageUtils(marketingList, total);
		return pageUtils;
	}
	
	@GetMapping("/add")
	@RequiresPermissions("AppManage:marketing:add")
	String add(){
	    return "AppManage/marketing/add";
	}

	@GetMapping("/edit/{marketingId}")
	@RequiresPermissions("AppManage:marketing:edit")
	String edit(@PathVariable("marketingId") Integer marketingId,Model model){
		MarketingDO marketing = marketingService.get(marketingId);
		model.addAttribute("marketing", marketing);
	    return "AppManage/marketing/edit";
	}
	
	/**
	 * 保存
	 */
	@ResponseBody
	@PostMapping("/save")
	@RequiresPermissions("AppManage:marketing:add")
	public R save( MarketingDO marketing){
		if(marketingService.save(marketing)>0){
			return R.ok();
		}
		return R.error();
	}
	/**
	 * 修改
	 */
	@ResponseBody
	@RequestMapping("/update")
	@RequiresPermissions("AppManage:marketing:edit")
	public R update( MarketingDO marketing){
		marketingService.update(marketing);
		return R.ok();
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/remove")
	@ResponseBody
	@RequiresPermissions("AppManage:marketing:remove")
	public R remove( Integer marketingId){
		if(marketingService.remove(marketingId)>0){
		return R.ok();
		}
		return R.error();
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/batchRemove")
	@ResponseBody
	@RequiresPermissions("AppManage:marketing:batchRemove")
	public R remove(@RequestParam("ids[]") Integer[] marketingIds){
		marketingService.batchRemove(marketingIds);
		return R.ok();
	}


	@ResponseBody
	@GetMapping("/nameList")
	public List<MarketingDO> carPeoductNameList(){
		//查询列表数据
		List<MarketingDO> marketingDOList = marketingService.nameList();
		return marketingDOList;
	}
}
