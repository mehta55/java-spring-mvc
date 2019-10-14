package com.nagarro.dto;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * User class is an user entity that is stored in database for login
 * functionality.
 * 
 * @author sahilmehta02
 *
 */
@Entity
@Table(name = "Users")
public class User {

	@Id
	String uId;
	String uPswd;

	public String getUId() {
		return uId;
	}

	public void setUId(String uName) {
		this.uId = uName;
	}

	public String getuPswd() {
		return uPswd;
	}

	public void setuPswd(String uPswd) {
		this.uPswd = uPswd;
	}

}
