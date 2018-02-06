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

import com.bootdo.CarManage.domain.BrandDO;
import com.bootdo.CarManage.service.BrandService;
import com.bootdo.common.utils.PageUtils;
import com.bootdo.common.utils.Query;
import com.bootdo.common.utils.R;

/**
 * 品牌
 * 
 * @author xgg
 * @email 641352220@qq.com
 * @date 2018-01-04 16:43:41
 */
 
@Controller
@RequestMapping("/CarManage/brand")
public class BrandController {
	@Autowired
	private BrandService brandService;
	
	@GetMapping()
	@RequiresPermissions("CarManage:brand:brand")
	String Brand(){
	    return "CarManage/brand/brand";
	}
	
	@ResponseBody
	@GetMapping("/list")
	@RequiresPermissions("CarManage:brand:brand")
	public PageUtils list(@RequestParam Map<String, Object> params){
		//查询列表数据
        Query query = new Query(params);
		List<BrandDO> brandList = brandService.list(query);
		int total = brandService.count(query);
		PageUtils pageUtils = new PageUtils(brandList, total);
		return pageUtils;
	}
	
	@GetMapping("/add")
	@RequiresPermissions("CarManage:brand:add")
	String add(){
	    return "CarManage/brand/add";
	}

	@GetMapping("/edit/{brandId}")
	@RequiresPermissions("CarManage:brand:edit")
	String edit(@PathVariable("brandId") Integer brandId,Model model){
		BrandDO brand = brandService.get(brandId);
		model.addAttribute("brand", brand);
	    return "CarManage/brand/edit";
	}
	
	/**
	 * 保存
	 */
	@ResponseBody
	@PostMapping("/save")
	@RequiresPermissions("CarManage:brand:add")
	public R save( BrandDO brand){
		if(brandService.save(brand)>0){
			return R.ok();
		}
		return R.error();
	}
	/**
	 * 修改
	 */
	@ResponseBody
	@RequestMapping("/update")
	@RequiresPermissions("CarManage:brand:edit")
	public R update( BrandDO brand){
		brandService.update(brand);
		return R.ok();
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/remove")
	@ResponseBody
	@RequiresPermissions("CarManage:brand:remove")
	public R remove( Integer brandId){
		if(brandService.remove(brandId)>0){
		return R.ok();
		}
		return R.error();
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/batchRemove")
	@ResponseBody
	@RequiresPermissions("CarManage:brand:batchRemove")
	public R remove(@RequestParam("ids[]") Integer[] brandIds){
		brandService.batchRemove(brandIds);
		return R.ok();
	}


	@ResponseBody
	@GetMapping("/brandList")
	public List<BrandDO> brandList(){
		//查询列表数据
		return brandService.BrandDOList();
	}

	@ResponseBody
	@GetMapping("/listByBusinessId")
	public List<BrandDO> businessCity(Integer id){
		//查询列表数据
		try{
			return brandService.listByBusinessId(id);
		}catch (Exception e){
			e.printStackTrace();
			return  null;
		}
	}

	@ResponseBody
	@GetMapping("/brandListCarOffer")
	public List<BrandDO> brandListCarOffer(){
		//查询列表数据
		return brandService.BrandDOListByFA();
	}
}
