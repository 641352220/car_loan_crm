package com.bootdo.UserManage.controller;

import java.util.List;
import java.util.Map;

import com.bootdo.OrderManage.domain.OrderDO;
import com.bootdo.OrderManage.service.OrderService;
import com.bootdo.UserManage.domain.UserInformationDO;
import com.bootdo.UserManage.service.UserInformationService;
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

import com.bootdo.UserManage.domain.UserAppDO;
import com.bootdo.UserManage.service.UserAppService;
import com.bootdo.common.utils.PageUtils;
import com.bootdo.common.utils.Query;
import com.bootdo.common.utils.R;

/**
 * 用户表
 * 
 * @author xgg
 * @email 641352220@qq.com
 * @date 2018-01-10 14:57:10
 */
 
@Controller
@RequestMapping("/UserManage/user")
public class UserAppController {
	@Autowired
	private UserAppService userAppService;
	@Autowired
	private UserInformationService userInformationService;
	@Autowired
	private OrderService orderService;
	
	@GetMapping()
	@RequiresPermissions("UserManage:user:user")
	String User(){
	    return "UserManage/user/user";
	}
	
	@ResponseBody
	@GetMapping("/list")
	@RequiresPermissions("UserManage:user:user")
	public PageUtils list(@RequestParam Map<String, Object> params){
		//查询列表数据
        Query query = new Query(params);
		List<UserAppDO> userList = userAppService.list(query);
		int total = userAppService.count(query);
		PageUtils pageUtils = new PageUtils(userList, total);
		return pageUtils;
	}
	
	@GetMapping("/add")
	@RequiresPermissions("UserManage:user:add")
	String add(){
	    return "UserManage/user/add";
	}

	@GetMapping("/edit/{userId}")
//	@RequiresPermissions("UserManage:user:edit")
	String edit(@PathVariable("userId") Integer userId,Model model){
		UserInformationDO user = userInformationService.get(userId);
		if(null == user){
			user = new UserInformationDO();
		}
		UserAppDO phone = userAppService.get(userId);
		model.addAttribute("phone", phone.getPhone());
		model.addAttribute("user", user);
	    return "UserManage/user/edit";
	}

	@GetMapping("/userCollectionList/{userId}")
	@RequiresPermissions("UserManage:user:edit")
	String userCollectionList(@PathVariable("userId") Integer userId,Model model){
		model.addAttribute("userId", userId);
		return "UserManage/user/userCollectionList";
	}

	@GetMapping("/userOrderList/{userId}")
	@RequiresPermissions("UserManage:user:edit")
	String userOrderList(@PathVariable("userId") Integer userId,Model model){
		model.addAttribute("userId", userId);
		return "UserManage/user/userOrderList";
	}

	@ResponseBody
	@GetMapping("/orderList")
	@RequiresPermissions("UserManage:user:edit")
	public PageUtils orderList(@RequestParam Map<String, Object> params){
		//查询列表数据
		Query query = new Query(params);
		List<OrderDO> orderList = orderService.userList(query);
		int total = orderService.userCount(query);
		PageUtils pageUtils = new PageUtils(orderList, total);
		return pageUtils;
	}
	
	/**
	 * 保存
	 */
	@ResponseBody
	@PostMapping("/save")
	@RequiresPermissions("UserManage:user:add")
	public R save( UserAppDO user){
		if(userAppService.save(user)>0){
			return R.ok();
		}
		return R.error();
	}
	/**
	 * 修改
	 */
	@ResponseBody
	@RequestMapping("/update")
	@RequiresPermissions("UserManage:user:edit")
	public R update( UserAppDO user){
		userAppService.update(user);
		return R.ok();
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/remove")
	@ResponseBody
	@RequiresPermissions("UserManage:user:remove")
	public R remove( Integer userId){
		UserAppDO userAppDO = userAppService.get(userId);
		userAppDO.setState(1);
		userAppService.update(userAppDO);
		return R.ok();
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/batchRemove")
	@ResponseBody
	@RequiresPermissions("UserManage:user:batchRemove")
	public R remove(@RequestParam("ids[]") Integer[] userIds){
		userAppService.batchRemove(userIds);
		return R.ok();
	}
	
}
