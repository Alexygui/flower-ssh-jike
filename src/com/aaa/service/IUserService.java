package com.aaa.service;

import com.aaa.model.User;

public interface IUserService {
	public boolean addOrUpdateUser(User user);
	public User checkUser(User user);
	public boolean guashiUser(int userid);
	public boolean jiechuguashiUser(int userid);
}
