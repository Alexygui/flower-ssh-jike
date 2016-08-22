package com.aaa.dao.impl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.aaa.dao.IOrderDao;
import com.aaa.model.Orders;

public class OrderDao implements IOrderDao{
	private SessionFactory sessionFactory;
	
	
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	/**
	 * 将Orders的对象保存到数据库中，利用数据库id自增功能生成新的带id的Orders的对象返回
	 */
	@Override
	public Orders saveOrders(Orders orders) {
//System.out.println("orderid=" + orders.getOrderid());
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		session.save(orders);
		transaction.commit();
		session.close();
//System.out.println("orderid=" + orders.getOrderid());
//		orderid=null
//		orderid=14
		//通过上面的两条的打印测试发现位存入数据库之后的orderid从null变成具体的值,
		//看来hibernate已经把Orders的对象是从数据库中重新取出来了一遍，所以orderid有了具体的值
		return orders;
	}

}
