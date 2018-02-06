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

import com.bootdo.AppManage.domain.CityDO;
import com.bootdo.AppManage.service.CityService;
import com.bootdo.common.utils.PageUtils;
import com.bootdo.common.utils.Query;
import com.bootdo.common.utils.R;
import sun.rmi.server.InactiveGroupException;

/**
 * 城市表
 * 
 * @author xgg
 * @email 641352220@qq.com
 * @date 2018-01-04 14:59:49
 */
 
@Controller
@RequestMapping("/AppManage/city")
public class CityController {
	@Autowired
	private CityService cityService;


	@ResponseBody
	@GetMapping("/productCity")
	public List<CityDO> productCity(Integer id,Integer level){
		//查询列表数据
		try{
			return cityService.productCity(id,level);
		}catch (Exception e){
			e.printStackTrace();
			return  null;
		}
	}

	@ResponseBody
	@GetMapping("/businessCity")
	public List<CityDO> businessCity(Integer id,Integer level){
		//查询列表数据
		try{
			return cityService.businessCity(id,level);
		}catch (Exception e){
			e.printStackTrace();
			return  null;
		}
	}
	
}
