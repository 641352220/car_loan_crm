package com.bootdo.AdverManage.controller;

import com.bootdo.AdverManage.domain.AdverCarDO;
import com.bootdo.AdverManage.service.AdverCarService;
import com.bootdo.common.utils.PageUtils;
import com.bootdo.common.utils.Query;
import com.bootdo.common.utils.R;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * 爆款车辆
 * 
 * @author xgg
 * @email 641352220@qq.com
 * @date 2018-01-03 11:10:04
 */
 
@Controller
@RequestMapping("/AdverManage/adverCar")
public class AdverCarController {
	@Autowired
	private AdverCarService carService;
	
	@GetMapping()
	@RequiresPermissions("AdverManage:adverCar:car")
	String Car(){
	    return "AdverManage/adverCar/car";
	}
	
	@ResponseBody
	@GetMapping("/list")
	@RequiresPermissions("AdverManage:adverCar:car")
	public PageUtils list(@RequestParam Map<String, Object> params){
		//查询列表数据
        Query query = new Query(params);
		List<AdverCarDO> carList = carService.list(query);
		int total = carService.count(query);
		PageUtils pageUtils = new PageUtils(carList, total);
		return pageUtils;
	}
	
	@GetMapping("/add")
	@RequiresPermissions("AdverManage:adverCar:add")
	String add(){
	    return "AdverManage/adverCar/add";
	}

	@GetMapping("/edit/{adverCarId}")
	@RequiresPermissions("AdverManage:adverCar:edit")
	String edit(@PathVariable("adverCarId") Integer adverCarId,Model model){
		AdverCarDO car = carService.get(adverCarId);
		model.addAttribute("car", car);
		System.out.println(car.toString());
		return "AdverManage/adverCar/edit";
	}
	
	/**
	 * 保存
	 */
	@ResponseBody
	@PostMapping("/save")
	@RequiresPermissions("AdverManage:adverCar:add")
	public R save(AdverCarDO car){
		if(carService.save(car)>0){
			return R.ok();
		}
		return R.error();
	}
	/**
	 * 修改
	 */
	@ResponseBody
	@RequestMapping("/update")
	@RequiresPermissions("AdverManage:adverCar:edit")
	public R update(AdverCarDO car){
		carService.update(car);
		return R.ok();
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/remove")
	@ResponseBody
	@RequiresPermissions("AdverManage:adverCar:remove")
	public R remove(Integer adverCarId){
		if(carService.remove(adverCarId)>0){
		return R.ok();
		}
		return R.error();
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/batchRemove")
	@ResponseBody
	@RequiresPermissions("AdverManage:adverCar:batchRemove")
	public R remove(@RequestParam("ids[]") Integer[] adverCarIds){
		carService.batchRemove(adverCarIds);
		return R.ok();
	}
	
}
