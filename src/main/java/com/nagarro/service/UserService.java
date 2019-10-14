package com.nagarro.service;

import org.springframework.beans.factory.annotation.Autowired;

import com.nagarro.dao.UserDao;
import com.nagarro.dto.User;

public class UserService {

	@Autowired
	private UserDao userdao;
	
	public boolean validateUser(String uId, String uPswd) {
		
		User user = userdao.getUser(uId);

		return user != null && user.getuPswd().equals(uPswd);		
	}
	
	public void saveUser(String uId, String uPswd) {
		
		User user = new User();
		user.setUId(uId);
		user.setuPswd(uPswd);
		userdao.saveUser(user);

	}
}
