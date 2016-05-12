package com.sermo.xx.service.impl;

import java.util.Date;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.sermo.xx.dao.UserInfoDao;
import com.sermo.xx.model.UserInfo;
import com.sermo.xx.service.UserInfoService;
import com.sermo.xx.utils.MD5;
import com.sermo.xx.utils.UUIDUtil;
import com.sermo.xx.vo.UserInfoVo;

@Service
public class UserInfoServiceImpl implements UserInfoService{
	
	@Resource
	private UserInfoDao userInfoDao;

	@Override
	public boolean login(String password, String email) {
		UserInfoVo infoVo = userInfoDao.getInfoVo(email);
		password = MD5.encrypt(password + "|" + infoVo.getToken(), "MD5");
		if (password.equals(infoVo.getPassword())) {
			return true;
		}else{
			return false;
		}
	}

	@Override
	public boolean emailIsExits(String email) {
		int result = userInfoDao.emailIsExits(email);
		return result == 1 ? true : false;
	}

	@Override
	public boolean insert(UserInfo info) {
		info.setCreateTime(new Date());
		String token = UUIDUtil.UUIDGenerator();
		info.setToken(token);
		info.setId(token);
		String password = info.getPassword() + "|" + token;
		info.setPassword(MD5.encrypt(password, "MD5"));
		return userInfoDao.insert(info);
	}
}
