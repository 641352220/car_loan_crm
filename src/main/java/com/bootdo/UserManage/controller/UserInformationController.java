package com.bootdo.UserManage.controller;

import java.util.List;
import java.util.Map;

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

import com.bootdo.UserManage.domain.UserInformationDO;
import com.bootdo.UserManage.service.UserInformationService;
import com.bootdo.common.utils.PageUtils;
import com.bootdo.common.utils.Query;
import com.bootdo.common.utils.R;

/**
 * 用户信息补充表
 * 
 * @author xgg
 * @email 641352220@qq.com
 * @date 2018-01-10 14:57:10
 */
 
@Controller
@RequestMapping("/UserManage/information")
public class UserInformationController {
	@Autowired
	private UserInformationService userInformationService;
	
	@GetMapping()
	@RequiresPermissions("UserManage:information:information")
	String Information(){
	    return "UserManage/information/information";
	}
	
	@ResponseBody
	@GetMapping("/list")
	@RequiresPermissions("UserManage:information:information")
	public PageUtils list(@RequestParam Map<String, Object> params){
		//查询列表数据
        Query query = new Query(params);
		List<UserInformationDO> informationList = userInformationService.list(query);
		int total = userInformationService.count(query);
		PageUtils pageUtils = new PageUtils(informationList, total);
		return pageUtils;
	}
	
	@GetMapping("/add")
	@RequiresPermissions("UserManage:information:add")
	String add(){
	    return "UserManage/information/add";
	}

	@GetMapping("/edit/{userId}")
	@RequiresPermissions("UserManage:information:edit")
	String edit(@PathVariable("userId") Integer userId,Model model){
		UserInformationDO information = userInformationService.get(userId);
		model.addAttribute("information", information);
	    return "UserManage/information/edit";
	}
	
	/**
	 * 保存
	 */
	@ResponseBody
	@PostMapping("/save")
	@RequiresPermissions("UserManage:information:add")
	public R save( UserInformationDO information){
		if(userInformationService.save(information)>0){
			return R.ok();
		}
		return R.error();
	}
	/**
	 * 修改
	 */
	@ResponseBody
	@RequestMapping("/update")
	@RequiresPermissions("UserManage:information:edit")
	public R update( UserInformationDO information){
		userInformationService.update(information);
		return R.ok();
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/remove")
	@ResponseBody
	@RequiresPermissions("UserManage:information:remove")
	public R remove( Integer userId){
		if(userInformationService.remove(userId)>0){
		return R.ok();
		}
		return R.error();
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/batchRemove")
	@ResponseBody
	@RequiresPermissions("UserManage:information:batchRemove")
	public R remove(@RequestParam("ids[]") Integer[] userIds){
		userInformationService.batchRemove(userIds);
		return R.ok();
	}
	
}
