package com.aaa.service;

import com.aaa.model.User;

public interface IUserService {
	public boolean addOrUpdateUser(User user);
	public User checkUser(User user);
}
