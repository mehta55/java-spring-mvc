package com.nagarro.daoImp;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import com.nagarro.dao.Dao;
import com.nagarro.dao.UserDao;
import com.nagarro.dto.User;

public class UserDaoImp implements UserDao {

	final static Logger LOG = Logger.getLogger(FlightFileDaoImp.class);

	@Autowired
	private Dao dao;

	public void saveUser(User user) {
		LOG.info("Saving new user : " + user.getUId());
		
		dao.begin();
		dao.getSession().save(user);
		dao.commit();
		dao.close();

		LOG.info("Saved new user : " + user.getUId() + "successfully.");
	}

	public User getUser(String uId) {
		LOG.info("Retriving User : " + uId);
		
		dao.begin();
		User user = (User) dao.getSession().get(User.class, uId);
		dao.commit();
		dao.close();

		LOG.info("Retrived User : " + uId + " successfully.");
		return user;
	}
	
}
