package com.bootdo.OrderManage.dao;

import com.bootdo.OrderManage.domain.OrderDO;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

/**
 * 订单
 * @author xgg
 * @email 641352220@qq.com
 * @date 2018-01-10 14:59:48
 */
@Mapper
public interface OrderDao {

	OrderDO get(Integer orderId);
	
	List<OrderDO> list(Map<String, Object> map);
	
	int count(Map<String, Object> map);
	
	int save(OrderDO order);
	
	int update(OrderDO order);
	
	int remove(Integer order_id);
	
	int batchRemove(Integer[] orderIds);

	List<OrderDO> userList(Map<String, Object> map);

	int userCount(Map<String, Object> map);
}
