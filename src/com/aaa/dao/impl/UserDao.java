package com.aaa.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.aaa.dao.IUserDao;
import com.aaa.model.User;

/**
 * 实现用户操作的类
 */
public class UserDao implements IUserDao {
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

	/**
	 * 检查登录的用户是否在数据库已经注册
	 */
	@Override
	public User checkUser(User user) {
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		// Query query = session.createQuery("from User where userid=" +
		// user.getUserid());
		Query query = session.createQuery("from User where username='" + user.getUsername() + "' and password='"
				+ user.getPassword() + "' and role='" + user.getRole() + "'");
		User user2 = new User();
		List<User> list = query.list();
		transaction.commit();
		session.close();
		if (list.size() != 0) {
			user2 = list.get(0);
			return user2;
		}
		return null;
	}

}
