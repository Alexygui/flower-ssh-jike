package com.aaa.dao;

import com.aaa.model.Guashi;
import com.aaa.model.User;

public interface IUserDao {
	public boolean addOrUpdateUser(User user);
	public User checkUser(User user);
	public boolean guashiUser(int userid);
	public boolean jiechuguashiUser(int userid);
}
