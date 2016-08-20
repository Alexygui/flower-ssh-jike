package com.aaa.service.impl;

import com.aaa.dao.impl.UserDao;
import com.aaa.model.User;
import com.aaa.service.IUserService;

/**
 * 实现用户操作的service层的类
 */
public class UserService implements IUserService{
	/**
	 * 声明UserDao变量，添加get和set方法由spring注入
	 */
	private UserDao userDao;
	
	public UserDao getUserDao() {
		return userDao;
	}

	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}

	/**
	 * 实现添加或更新User的方法
	 */
	@Override
	public boolean addOrUpdateUser(User user) {
		return userDao.addOrUpdateUser(user);
	}

}
