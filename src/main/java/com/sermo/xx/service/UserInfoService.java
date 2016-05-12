package com.sermo.xx.service;

import com.sermo.xx.model.UserInfo;

public interface UserInfoService {
	
	/**
	 * 判断是否登陆成功
	 * @param password
	 * @param email
	 * @return
	 */
	public boolean login(String password, String email);
	
	/**
	 * email 是否存在
	 * @param email
	 * @return
	 */
	public boolean emailIsExits(String email);
	
	/**
	 * 注册新用户
	 * @param info
	 * @return
	 */
	public boolean insert(UserInfo info);
}
