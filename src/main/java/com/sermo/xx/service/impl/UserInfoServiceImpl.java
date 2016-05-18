package com.sermo.xx.service.impl;

import java.util.Date;

import javax.annotation.Resource;
import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sermo.xx.dao.UserInfoDao;
import com.sermo.xx.model.UserInfo;
import com.sermo.xx.service.UserInfoService;
import com.sermo.xx.utils.MD5;
import com.sermo.xx.utils.StringUtil;
import com.sermo.xx.utils.UUIDUtil;
import com.sermo.xx.vo.UserInfoVo;

@Service
public class UserInfoServiceImpl implements UserInfoService{
	
	private @Value(value="${spirng.mail.subject}") String subject;
	private @Value("${spirng.mail.text}") String mailText;
	
	@Resource
	private UserInfoDao userInfoDao;
	
	@Resource
	private JavaMailSenderImpl sender;

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

	@Override
	@Transactional
	public boolean sendEmail(String email){
		String reset_key = UUIDUtil.UUIDGenerator();
		userInfoDao.updateKey(email, reset_key);
		MimeMessage message = sender.createMimeMessage();
		MimeMessageHelper helper;
		try {
			helper = new MimeMessageHelper(message, true, "UTF-8");
			helper.setFrom("woshicainiao1573@163.com");
			helper.setTo(email);
			helper.setSubject(subject);
			String msg = StringUtil.format(mailText, reset_key, email, reset_key, email);
			helper.setText(msg,true);
			sender.send(message);
			return true;
		} catch (MessagingException e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean selectByKey(String email, String resetKey) {
		int result = userInfoDao.selectByKey(email, resetKey);
		if (result == 0) {
			return false;
		}
		return true;
	}

	@Override
	public boolean updatePassword(String email, String password) {
		String token = UUIDUtil.UUIDGenerator();
		password = MD5.encrypt(password + "|" + token, "MD5");
		UserInfo userInfo = new UserInfo();
		userInfo.setEmail(email);
		userInfo.setPassword(password);
		userInfo.setToken(token);
		userInfo.setUpdateTime(new Date());
		return userInfoDao.updatePassword(userInfo);
	}
}
