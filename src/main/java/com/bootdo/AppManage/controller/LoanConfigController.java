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

import com.bootdo.AppManage.domain.LoanConfigDO;
import com.bootdo.AppManage.service.LoanConfigService;
import com.bootdo.common.utils.PageUtils;
import com.bootdo.common.utils.Query;
import com.bootdo.common.utils.R;

/**
 * 车贷产品期数及首付比例配置
 * 
 * @author xgg
 * @email 641352220@qq.com
 * @date 2018-01-04 14:59:49
 */
 
@Controller
@RequestMapping("/AppManage/loanConfig")
public class LoanConfigController {
	@Autowired
	private LoanConfigService loanConfigService;
	
	@GetMapping()
	@RequiresPermissions("AppManage:loanConfig:loanConfig")
	String LoanConfig(){
	    return "AppManage/loanConfig/loanConfig";
	}
	
	@ResponseBody
	@GetMapping("/list")
	@RequiresPermissions("AppManage:loanConfig:loanConfig")
	public PageUtils list(@RequestParam Map<String, Object> params){
		//查询列表数据
        Query query = new Query(params);
		List<LoanConfigDO> loanConfigList = loanConfigService.list(query);
		int total = loanConfigService.count(query);
		PageUtils pageUtils = new PageUtils(loanConfigList, total);
		return pageUtils;
	}
	
	@GetMapping("/add")
	@RequiresPermissions("AppManage:loanConfig:add")
	String add(){
	    return "AppManage/loanConfig/add";
	}

	@GetMapping("/edit/{loanConfigId}")
	@RequiresPermissions("AppManage:loanConfig:edit")
	String edit(@PathVariable("loanConfigId") Integer loanConfigId,Model model){
		LoanConfigDO loanConfig = loanConfigService.get(loanConfigId);
		model.addAttribute("loanConfig", loanConfig);
	    return "AppManage/loanConfig/edit";
	}
	
	/**
	 * 保存
	 */
	@ResponseBody
	@PostMapping("/save")
	@RequiresPermissions("AppManage:loanConfig:add")
	public R save( LoanConfigDO loanConfig){
		if(loanConfigService.save(loanConfig)>0){
			return R.ok();
		}
		return R.error();
	}
	/**
	 * 修改
	 */
	@ResponseBody
	@RequestMapping("/update")
	@RequiresPermissions("AppManage:loanConfig:edit")
	public R update( LoanConfigDO loanConfig){
		loanConfigService.update(loanConfig);
		return R.ok();
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/remove")
	@ResponseBody
	@RequiresPermissions("AppManage:loanConfig:remove")
	public R remove( Integer loanConfigId){
		if(loanConfigService.remove(loanConfigId)>0){
		return R.ok();
		}
		return R.error();
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/batchRemove")
	@ResponseBody
	@RequiresPermissions("AppManage:loanConfig:batchRemove")
	public R remove(@RequestParam("ids[]") Integer[] loanConfigIds){
		loanConfigService.batchRemove(loanConfigIds);
		return R.ok();
	}

	@ResponseBody
	@GetMapping("/loanConfigList")
	public List<LoanConfigDO> loanConfigList(Integer type,Integer carProductInformationId){
		//查询列表数据
		try{
			return loanConfigService.LoanConfigDOList(type,carProductInformationId);
		}catch (Exception e){
			e.printStackTrace();
			return  null;
		}
	}

	
}
