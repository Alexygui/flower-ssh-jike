package com.aaa.dao.impl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.aaa.dao.IUserDao;
import com.aaa.model.User;

/**
 * 实现用户操作的类
 */
public class UserDao implements IUserDao{
	/**
	 * 声明SessionFactory变量，添加get，set方法后由spring注入
	 */
	private SessionFactory sessionFactory;
	
	
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}


	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}


	/**
	 * 添加或更行用户数据的方法
	 */
	@Override
	public boolean addOrUpdateUser(User user) {
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		session.saveOrUpdate(user);
		transaction.commit();
		session.close();
		return true;
	}

}
