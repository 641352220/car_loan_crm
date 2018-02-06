package com.bootdo.OrderManage.service.impl;

import com.bootdo.common.service.DictService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import com.bootdo.OrderManage.dao.OrderDao;
import com.bootdo.OrderManage.domain.OrderDO;
import com.bootdo.OrderManage.service.OrderService;



@Service
public class OrderServiceImpl implements OrderService {
	@Autowired
	private OrderDao orderDao;
	@Autowired
	private DictService dictService;
	
	@Override
	public OrderDO get(Integer orderId){
		return orderDao.get(orderId);
	}
	
	@Override
	public List<OrderDO> list(Map<String, Object> map){
		return orderDao.list(map);
	}
	
	@Override
	public int count(Map<String, Object> map){
		return orderDao.count(map);
	}
	
	@Override
	public int save(OrderDO order){
		return orderDao.save(order);
	}
	
	@Override
	public int update(OrderDO order){
		return orderDao.update(order);
	}
	
	@Override
	public int remove(Integer orderId){
		return orderDao.remove(orderId);
	}
	
	@Override
	public int batchRemove(Integer[] orderIds){
		return orderDao.batchRemove(orderIds);
	}

	@Override
	public List<OrderDO> userList(Map<String, Object> map) {
		List<OrderDO> orderDOS = orderDao.userList(map);
		for(OrderDO orderDO : orderDOS){
			orderDO.setOfferType(dictService.getName("order_offer_type",orderDO.getOfferType()));
		}
		return orderDOS;
	}

	@Override
	public int userCount(Map<String, Object> map) {
		return orderDao.userCount(map);
	}

}
