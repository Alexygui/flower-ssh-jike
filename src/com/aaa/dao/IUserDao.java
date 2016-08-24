package com.aaa.dao;

import java.util.List;

import com.aaa.model.Guashi;
import com.aaa.model.User;

public interface IUserDao {
	public boolean addOrUpdateUser(User user);
	public User checkUser(User user);
	public boolean guashiUser(int userid);
	public boolean jiechuguashiUser(int userid);
	public List<Guashi> getGuashi();
}
