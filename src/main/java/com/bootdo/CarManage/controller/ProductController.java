package com.bootdo.CarManage.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.bootdo.BusinessManage.service.BusinessCityService;
import com.bootdo.CarManage.domain.ProductCityDO;
import com.bootdo.CarManage.service.ProductCityService;
import com.bootdo.common.controller.BaseController;
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

import com.bootdo.CarManage.domain.ProductDO;
import com.bootdo.CarManage.service.ProductService;
import com.bootdo.common.utils.PageUtils;
import com.bootdo.common.utils.Query;
import com.bootdo.common.utils.R;

import javax.servlet.http.HttpServletRequest;

/**
 * 车贷产品
 * 
 * @author xgg
 * @email 641352220@qq.com
 * @date 2018-01-04 16:43:41
 */
 
@Controller
@RequestMapping("/CarManage/product")
public class ProductController extends BaseController{
	@Autowired
	private ProductService productService;
	@Autowired
	private ProductCityService productCityService;
	
	@GetMapping()
	@RequiresPermissions("CarManage:product:product")
	String Product(){
	    return "CarManage/product/product";
	}
	
	@ResponseBody
	@GetMapping("/list")
	@RequiresPermissions("CarManage:product:product")
	public PageUtils list(@RequestParam Map<String, Object> params){
		//查询列表数据
        Query query = new Query(params);
		Integer userType = getUserType();
		if(2 == userType){
			query.put("businessId",getDeptId());
		}
		List<ProductDO> productList = productService.list(query);
		int total = productService.count(query);
		PageUtils pageUtils = new PageUtils(productList, total);
		return pageUtils;
	}

	/**
	 * 修改平台状态
	 */
	@PostMapping( "/updateStateByP")
	@ResponseBody
	@RequiresPermissions("CarManage:product:edit")
	public R updateStateByP( Integer carProductId,Integer type){
		ProductDO product = productService.get(carProductId);
		product.setPlatformState(type);
		if(productService.update(product)>0){
			return R.ok();
		}
		return R.error();
	}

	@GetMapping("/add")
	@RequiresPermissions("CarManage:product:add")
	String add(){
	    return "CarManage/product/add";
	}

	@GetMapping("/edit/{carProductId}")
	@RequiresPermissions("CarManage:product:edit")
	String edit(@PathVariable("carProductId") Integer carProductId,Model model){
		ProductDO product = productService.get(carProductId);
		model.addAttribute("product", product);
	    return "CarManage/product/edit";
	}
	
	/**
	 * 保存
	 */
	@ResponseBody
	@PostMapping("/save")
	@RequiresPermissions("CarManage:product:add")
	public R save( ProductDO product, HttpServletRequest request){
		product.setCreateBy(Integer.parseInt(getUserId().toString()));
		product.setCreateDate(new Date());
		product.setBusinessId(getDeptId());
		product.setCommentNum(0);
		product.setCommentBranch(0);
		product.setPlatformState(1);
		if(productService.save(product)>0){
			try{
				productCityService.remove(product.getCarProductId());
				String[] carProductCityIds = request.getParameterValues("carProductCityIds");
				for(String carProductCityId : carProductCityIds){
					ProductCityDO productCityDO = new ProductCityDO();
					productCityDO.setCarProductId(product.getCarProductId());
					productCityDO.setLevel(3);
					productCityDO.setCityId(Integer.parseInt(carProductCityId));
					productCityService.save(productCityDO);
				}
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
	@RequiresPermissions("CarManage:product:edit")
	public R update( ProductDO product){
		product.setUpdateBy(getUserId());
		product.setUpdateDate(new Date());
		productService.update(product);
		return R.ok();
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/remove")
	@ResponseBody
	@RequiresPermissions("CarManage:product:remove")
	public R remove( Integer carProductId){
		if(productService.remove(carProductId)>0){
		return R.ok();
		}
		return R.error();
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/batchRemove")
	@ResponseBody
	@RequiresPermissions("CarManage:product:batchRemove")
	public R remove(@RequestParam("ids[]") Integer[] carProductIds){
		productService.batchRemove(carProductIds);
		return R.ok();
	}


	@ResponseBody
	@GetMapping("/carProductNameList")
	public List<ProductDO> carPeoductNameList(){
		//查询列表数据
		List<ProductDO> productList = productService.nameList(getDeptId());
		return productList;
	}
}
