package com.bootdo.OrderManage.controller;

import java.util.Date;
import java.util.List;
import java.util.Map;

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

import com.bootdo.OrderManage.domain.OrderDO;
import com.bootdo.OrderManage.service.OrderService;
import com.bootdo.common.utils.PageUtils;
import com.bootdo.common.utils.Query;
import com.bootdo.common.utils.R;

/**
 * 订单
 * 
 * @author xgg
 * @email 641352220@qq.com
 * @date 2018-01-10 14:59:48
 */
 
@Controller
@RequestMapping("/OrderManage/order")
public class OrderController extends BaseController{
	@Autowired
	private OrderService orderService;
	
	@GetMapping()
	@RequiresPermissions("OrderManage:order:order")
	String Order(){
	    return "OrderManage/order/order";
	}
	
	@ResponseBody
	@GetMapping("/list")
	@RequiresPermissions("OrderManage:order:order")
	public PageUtils list(@RequestParam Map<String, Object> params){
		//查询列表数据
        Query query = new Query(params);
        Integer userType = getUserType();
        if(2 == userType){
			query.put("loanBusinessId",getDeptId());
		}else if(3 == userType){
			query.put("carBusinessId",getDeptId());
		}
		List<OrderDO> orderList = orderService.list(query);
		int total = orderService.count(query);
		PageUtils pageUtils = new PageUtils(orderList, total);
		return pageUtils;
	}



	/**
	 * 删除
	 */
	@PostMapping( "/pass")
	@ResponseBody
//	@RequiresPermissions("OrderManage:order:pass")
	public R pass( Integer orderId){
		OrderDO orderDO = orderService.get(orderId);
		if(1 == orderDO.getState()){
			orderDO.setState(5);
		}else if(5 == orderDO.getState()){
			orderDO.setState(6);
		}else{
			return R.error();
		}
		orderDO.setUpdateTime(new Date());
		orderService.update(orderDO);
		return R.ok();
	}

	/**
	 * 删除
	 */
	@PostMapping( "/noPass")
	@ResponseBody
//	@RequiresPermissions("OrderManage:order:pass")
	public R noPass( Integer orderId){
		OrderDO orderDO = orderService.get(orderId);
		if(1 == orderDO.getState()){
			orderDO.setState(3);
		}else{
			return R.error();
		}
		orderDO.setUpdateTime(new Date());
		orderService.update(orderDO);
		return R.ok();
	}

	
}
