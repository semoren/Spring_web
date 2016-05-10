package com.sermo.xx.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.sermo.xx.dao.UserInfoDao;
import com.sermo.xx.service.UserInfoService;
import com.sermo.xx.utils.MD5;

@Service
public class UserInfoServiceImpl implements UserInfoService{
	
	@Resource
	private UserInfoDao userInfoDao;

	@Override
	public boolean login(String password, String email) {
		String token = userInfoDao.getToken(email);
		password = MD5.encrypt(password, token);
		int result = userInfoDao.login(password, email);
		return result == 1 ? true : false;
	}
}
