package com.sermo.xx.service;

import javax.mail.MessagingException;

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
	
	/**
	 * 发送重置密码邮件
	 * @param email
	 * @return
	 * @throws MessagingException
	 */
	public boolean sendEmail(String email);
	
	/**
	 * 根据 resetKey 和 email 判断信息是否存在
	 * @param email
	 * @param resetKey
	 * @return
	 */
	public boolean selectByKey(String email, String resetKey);
	
	/**
	 * 根据 email 重置密码
	 * @param userInfo
	 * @return
	 */
	public boolean updatePassword(String email, String password);
}
