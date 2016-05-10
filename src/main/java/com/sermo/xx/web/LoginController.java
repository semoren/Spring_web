package com.sermo.xx.web;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.sermo.xx.model.UserInfo;
import com.sermo.xx.service.UserInfoService;
import com.sermo.xx.utils.IPUtil;

@Controller
public class LoginController {
	
	private static Logger logger = Logger.getLogger(LoginController.class);
	
	@Resource
	private UserInfoService service;
	
	@RequestMapping("/confirmLogin")
	public String login(HttpServletRequest request, HttpSession session, String email, String password){
//		boolean falg = service.login(password, email);
		boolean falg = true;
		if (falg) {
			logger.info("登陆成功|" + email + "|" + IPUtil.getIp2(request));
			session.setAttribute("email", email);
			return "redirect:/login_soft";
		}else{
			return "logins/login";
		}
	}
	
	@RequestMapping("/login")
	public String login(){
		return "logins/login";
	}
	
	//登陆成功后重定向的地址
	@RequestMapping("/login_soft")
	public String login_soft(){
		return "logins/login_soft";
	}
	
	@RequestMapping("/reset_password")
	@ResponseBody
	public String reset_password(String email){
		logger.info("重置密码|" + email);
		return "logins/login";
	}
	
	@RequestMapping("/register")
	public String register(HttpServletRequest request, UserInfo userInfo){
		logger.info("注册用户|" + userInfo.getEmail() + "|" + IPUtil.getIp2(request));
		return "logins/login";
	}
}