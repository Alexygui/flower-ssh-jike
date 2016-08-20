package com.aaa.dao;

import com.aaa.model.User;

public interface IUserDao {
	public boolean addOrUpdateUser(User user);
	public User checkUser(User user);

}
