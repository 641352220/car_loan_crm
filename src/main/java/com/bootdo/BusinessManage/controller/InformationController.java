package com.bootdo.BusinessManage.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.bootdo.BusinessManage.domain.BusinessCarDO;
import com.bootdo.BusinessManage.domain.BusinessCityDO;
import com.bootdo.BusinessManage.service.BusinessCarService;
import com.bootdo.BusinessManage.service.BusinessCityService;
import com.bootdo.common.controller.BaseController;
import com.bootdo.common.domain.Tree;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bootdo.BusinessManage.domain.InformationDO;
import com.bootdo.BusinessManage.service.InformationService;
import com.bootdo.common.utils.PageUtils;
import com.bootdo.common.utils.Query;
import com.bootdo.common.utils.R;

import javax.servlet.http.HttpServletRequest;

/**
 * 合作商信息
 * 
 * @author xgg
 * @email 641352220@qq.com
 * @date 2018-01-05 10:03:25
 */
 
@Controller
@RequestMapping("/BusinessManage/information")
public class InformationController extends BaseController{
	@Autowired
	private InformationService informationService;
	@Autowired
	private BusinessCarService businessCarService;
	@Autowired
	private BusinessCityService businessCityService;

	@GetMapping("/info")
	@RequiresPermissions("BusinessManage:information:edit")
	String Config(Model model){
		InformationDO information = informationService.get(getDeptId());
		if(null == information){
			information = new InformationDO();
		}
		model.addAttribute("information", information);
		return "BusinessManage/information/edit";
	}

	/**
	 * 修改状态
	 */
	@PostMapping( "/updateState")
	@ResponseBody
	@RequiresPermissions("BusinessManage:information:edit")
	public R updateState( Integer businessId,Integer type){
		InformationDO information = informationService.get(businessId);
		information.setState(type);
		if(informationService.update(information)>0){
			return R.ok();
		}
		return R.error();
	}

	/**
	 * 修改   自己商家专用的修改
	 */
	@ResponseBody
	@RequestMapping("/update")
	@RequiresPermissions("BusinessManage:information:edit")
	public R update(@RequestParam Map<String,Object> param,InformationDO information,HttpServletRequest request){
		if(null == information.getBusinessId()){
			information.setCity(information.getCity().replace("市",""));
			information.setCreateBy(Integer.parseInt(getUserId().toString()));
			information.setCreateDate(new Date());
			informationService.save(information);
		}else{
			information.setCity(information.getCity().replace("市",""));
			information.setUpdateBy(getUserId());
			information.setUpdateDate(new Date());
			informationService.update(information);
		}
		try{
			String[] cityIds = request.getParameterValues("cityIds");
			for(String cityIdString : cityIds){
				Integer cityId = Integer.parseInt(cityIdString);
				BusinessCityDO businessCityDO = new BusinessCityDO(getDeptId(),cityId,2);
				businessCityService.save(businessCityDO);
			}
		}catch (Exception e){

		}

		try{
			String[] brandIds = request.getParameterValues("brandIds");
			for(String brandIdString : brandIds){
				Integer brandId = Integer.parseInt(brandIdString);
				BusinessCarDO businessCarDO = new BusinessCarDO(getDeptId(),brandId);
				businessCarService.save(businessCarDO);
			}
		}catch (Exception e){

		}
//		informationService.update(information);
		return R.ok();
	}


	@GetMapping()
	@RequiresPermissions("BusinessManage:information:information")
	String dept() {
		return "BusinessManage/information/information";
	}

	@ResponseBody
	@GetMapping("/list")
	@RequiresPermissions("BusinessManage:information:information")
	public List<InformationDO> list() {
		Map<String, Object> query = new HashMap<>(16);
		List<InformationDO> sysDeptList = informationService.list(query);
		return sysDeptList;
	}

	@GetMapping("/add/{pId}")
	@RequiresPermissions("BusinessManage:information:add")
	String add(@PathVariable("pId") Integer pId, Model model) {
		model.addAttribute("pId", pId);
		if (pId == 0) {
			model.addAttribute("pName", "总部门");
		} else {
			model.addAttribute("pName",informationService.get(pId).getCompanyName());
		}
		return  "BusinessManage/information/addP";
	}

	/**
	 * 保存
	 */
	@ResponseBody
	@PostMapping("/save")
	@RequiresPermissions("BusinessManage:information:add")
	public R save( InformationDO information){
		if(informationService.save(information)>0){
			return R.ok();
		}
		return R.error();
	}


	@GetMapping("/edit/{businessId}")
	@RequiresPermissions("BusinessManage:information:edit")
	String edit(@PathVariable("businessId") Integer businessId,Model model){
		InformationDO information = informationService.get(businessId);
		model.addAttribute("information", information);
	    return "BusinessManage/information/editP";
	}

	/**
	 * 修改
	 */
	@ResponseBody
	@RequestMapping("/updateP")
	@RequiresPermissions("BusinessManage:information:edit")
	public R update(InformationDO informationDO) {
		if (informationService.update(informationDO) > 0) {
			return R.ok();
		}
		return R.error();
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/remove")
	@ResponseBody
	@RequiresPermissions("BusinessManage:information:remove")
	public R remove( Integer businessId){
		if(informationService.remove(businessId)>0){
		return R.ok();
		}
		return R.error();
	}



	@GetMapping("/tree")
	@ResponseBody
	public Tree<InformationDO> tree() {
		Tree<InformationDO> tree = new Tree<InformationDO>();
		tree = informationService.getTree();
		return tree;
	}

	@GetMapping("/treeView")
	String treeView() {
		return  "BusinessManage/information/treeView";
	}
}
