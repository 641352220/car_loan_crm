package com.bootdo.OrderManage.service;

import com.bootdo.OrderManage.domain.OrderDO;

import java.util.List;
import java.util.Map;

/**
 * 订单
 * 
 * @author xgg
 * @email 641352220@qq.com
 * @date 2018-01-10 14:59:48
 */
public interface OrderService {
	
	OrderDO get(Integer orderId);
	
	List<OrderDO> list(Map<String, Object> map);
	
	int count(Map<String, Object> map);
	
	int save(OrderDO order);
	
	int update(OrderDO order);
	
	int remove(Integer orderId);
	
	int batchRemove(Integer[] orderIds);

	List<OrderDO> userList(Map<String, Object> map);

	int userCount(Map<String, Object> map);
}
