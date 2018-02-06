package com.bootdo.AppManage.controller;

import java.util.List;
import java.util.Map;

import com.bootdo.AppManage.domain.LabelRelationDO;
import com.bootdo.AppManage.service.LabelRelationService;
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

import com.bootdo.AppManage.domain.MarketingCarDO;
import com.bootdo.AppManage.service.MarketingCarService;
import com.bootdo.common.utils.PageUtils;
import com.bootdo.common.utils.Query;
import com.bootdo.common.utils.R;

/**
 * 首页营销关联汽车表
 * 
 * @author xgg
 * @email 641352220@qq.com
 * @date 2018-01-04 14:59:49
 */
 
@Controller
@RequestMapping("/AppManage/marketingCar")
public class MarketingCarController {
	@Autowired
	private MarketingCarService marketingCarService;
	@Autowired
	private LabelRelationService labelRelationService;
	
	@GetMapping()
	@RequiresPermissions("AppManage:marketingCar:marketingCar")
	String MarketingCar(){
	    return "AppManage/marketingCar/marketingCar";
	}
	
	@ResponseBody
	@GetMapping("/list")
	@RequiresPermissions("AppManage:marketingCar:marketingCar")
	public PageUtils list(@RequestParam Map<String, Object> params){
		//查询列表数据
        Query query = new Query(params);
		List<MarketingCarDO> marketingCarList = marketingCarService.list(query);
		int total = marketingCarService.count(query);
		PageUtils pageUtils = new PageUtils(marketingCarList, total);
		return pageUtils;
	}
	
	@GetMapping("/add")
	@RequiresPermissions("AppManage:marketingCar:add")
	String add(){
	    return "AppManage/marketingCar/add";
	}

	@GetMapping("/edit/{appMarketingCarId}")
	@RequiresPermissions("AppManage:marketingCar:edit")
	String edit(@PathVariable("appMarketingCarId") Integer appMarketingCarId,Model model){
		MarketingCarDO marketingCar = marketingCarService.get(appMarketingCarId);
		model.addAttribute("marketingCar", marketingCar);
	    return "AppManage/marketingCar/edit";
	}
	
	/**
	 * 保存
	 */
	@ResponseBody
	@PostMapping("/save")
	@RequiresPermissions("AppManage:marketingCar:add")
	public R save(@RequestParam Map<String,Object> param, MarketingCarDO marketingCar){
		if(marketingCarService.save(marketingCar)>0){
			try{
				labelRelationService.save(new LabelRelationDO(marketingCar.getAppMarketingCarId(),Integer.parseInt(param.get("labelId").toString()),5));
			}catch (Exception e){
			}
			return R.ok();
		}
		return R.error();
	}
	/**
	 * 修改
	 */
	@ResponseBody
	@RequestMapping("/update")
	@RequiresPermissions("AppManage:marketingCar:edit")
	public R update(@RequestParam Map<String,Object> param, MarketingCarDO marketingCar){
		marketingCarService.update(marketingCar);
		try{
			labelRelationService.save(new LabelRelationDO(marketingCar.getAppMarketingCarId(),Integer.parseInt(param.get("labelId").toString()),5));
		}catch (Exception e){
		}
		return R.ok();
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/remove")
	@ResponseBody
	@RequiresPermissions("AppManage:marketingCar:remove")
	public R remove( Integer appMarketingCarId){
		if(marketingCarService.remove(appMarketingCarId)>0){
		return R.ok();
		}
		return R.error();
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/batchRemove")
	@ResponseBody
	@RequiresPermissions("AppManage:marketingCar:batchRemove")
	public R remove(@RequestParam("ids[]") Integer[] appMarketingCarIds){
		marketingCarService.batchRemove(appMarketingCarIds);
		return R.ok();
	}
	
}
