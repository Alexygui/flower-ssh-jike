package com.aaa.service.impl;

import java.util.List;

import com.aaa.dao.IUserDao;
import com.aaa.model.Guashi;
import com.aaa.model.User;
import com.aaa.service.IUserService;

/**
 * 实现用户操作的service层的类
 */
public class UserService implements IUserService{
	/**
	 * 声明UserDao变量，添加get和set方法由spring注入
	 */
	private IUserDao userDao;
	
	public IUserDao getUserDao() {
		return userDao;
	}

	public void setUserDao(IUserDao userDao) {
		this.userDao = userDao;
	}

	/**
	 * 实现添加或更新User的方法
	 */
	@Override
	public boolean addOrUpdateUser(User user) {
		return userDao.addOrUpdateUser(user);
	}

	/**
	 * 检查登录的用户是否在数据库已经注册
	 */
	@Override
	public User checkUser(User user) {
		return userDao.checkUser(user);
	}

	/**
	 * 挂失用户
	 */
	@Override
	public boolean guashiUser(int userid) {
		return userDao.guashiUser(userid);
	}

	/**
	 * 将用户的挂失解除
	 */
	@Override
	public boolean jiechuguashiUser(int userid) {
		return userDao.jiechuguashiUser(userid);
	}

	public  List<Guashi> getGuashi() {
		return userDao.getGuashi();
	}

}
