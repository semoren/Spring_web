package com.sermo.xx.service;


public interface UserInfoService {
	
	/**
	 * 判断是否登陆成功
	 * @return 
	 */
	public boolean login(String password, String email);
}
