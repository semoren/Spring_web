package com.sermo.xx.model;

import java.io.Serializable;
import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

public class UserInfo  implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 6710210767023638396L;
	
	private String id;
	
	private String email;
	
	private String username;
	
	private String password;
	
	private String token;
	
	@DateTimeFormat(pattern="yyyy/MM/dd hh:mm:ss")
	private Date createTime;

	@DateTimeFormat(pattern="yyyy/MM/dd hh:mm:ss")
	private Date updateTime;
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
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

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Date getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}
	
}
