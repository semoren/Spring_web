package com.sermo.xx.model;

import java.io.Serializable;

public class UserInfo  implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 6710210767023638396L;

	private String email;
	
	private String userName;
	
	private String password;
	
	private String token;

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}
	
}
