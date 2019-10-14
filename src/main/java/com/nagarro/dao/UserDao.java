package com.nagarro.dao;

import com.nagarro.dto.User;

public interface UserDao {

	public void saveUser(User user);
	public User getUser(String uId);
}
