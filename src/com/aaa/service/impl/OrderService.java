package com.aaa.service.impl;

import com.aaa.dao.IOrderDao;
import com.aaa.dao.impl.OrderDao;
import com.aaa.model.Orders;
import com.aaa.service.IOrderService;

public class OrderService implements IOrderService{
	private IOrderDao orderDao;
	
	public IOrderDao getOrderDao() {
		return orderDao;
	}

	public void setOrderDao(IOrderDao orderDao) {
		this.orderDao = orderDao;
	}

	@Override
	public Orders saveOrders(Orders orders) {
		return orderDao.saveOrders(orders);
	}

}
