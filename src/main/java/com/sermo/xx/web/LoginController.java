package com.sermo.xx.web;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import com.sermo.xx.model.UserInfo;
import com.sermo.xx.service.UserInfoService;
import com.sermo.xx.utils.IPUtil;

@Controller
public class LoginController {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(LoginController.class);
	@Resource
	private UserInfoService service;
	
	/**
	 * 登陆页面
	 * @return
	 */
	@RequestMapping(value="/login", method = RequestMethod.GET)
	public String login(){
		return "logins/login";
	}
	
	/**
	 * 登陆验证
	 * @param request
	 * @param session
	 * @param email
	 * @param password
	 * @param remember
	 * @return
	 */
	@RequestMapping(value="/login", method = RequestMethod.POST)
	public String login(HttpServletRequest request, HttpSession session, String email, String password, String remember){
		boolean falg = service.login(password, email);
		LOGGER.info("login," + email + "," + IPUtil.getIp2(request)+ "," + falg);
		if (falg) {
			session.setAttribute("email", email);
			return "redirect:/login_soft";
		}else{
			return "logins/login";
		}
	}
	
	
	/**
	 * 登陆成功后重定向的地址
	 * @return
	 */
	@RequestMapping("/login_soft")
	public String login_soft(){
		return "logins/login_soft";
	}
	
	/**
	 * 重置密码页面
	 * @return
	 */
	@RequestMapping(value="/reset_password", method = RequestMethod.GET)
	public String reset_password(){
		return "logins/reset_password";
	}
	
	/**
	 * 重置密码
	 * @param email
	 * @return
	 */
	@RequestMapping(value="/reset_password", method = RequestMethod.POST)
	public String reset_password(String email){
		boolean falg = service.sendEmail(email);
		LOGGER.info("reset_password," + email + "," + falg);
		if (falg) {
			return "redirect:/login";
		}else{
			return "500";
		}
	}

	/**
	 * 注册页面
	 * @return
	 */
	@RequestMapping(value="/register", method = RequestMethod.GET)
	public String register(){
		return "logins/register";
	}
	
	/**
	 * 注册
	 * @param request
	 * @param userInfo
	 * @return
	 */
	@RequestMapping(value="/register", method = RequestMethod.POST)
	public @ResponseBody boolean register(HttpServletRequest request, UserInfo userInfo){
		boolean falg = service.insert(userInfo);
		LOGGER.info("register," + userInfo.getEmail() + "," + IPUtil.getIp2(request) + "," + falg);
		return falg;
	}
	
	/**
	 * 重置密码页面
	 * @param request
	 * @param email
	 * @param resetKey
	 * @return
	 */
	@RequestMapping(value="/change_password", method = RequestMethod.GET)
	public String change_password(HttpServletRequest request, String email, String reset_key, HttpSession session){
		session.setAttribute("email", email);
		boolean falg = service.selectByKey(email, reset_key);
		if (falg) {
			return "logins/change_password";
		}
		return "500";
	}
	
	/**
	 * 重置密码页面
	 * @param request
	 * @param email
	 * @param resetKey
	 * @return
	 */
	@RequestMapping(value="/change_password", method = RequestMethod.POST)
	public String change_password(HttpServletRequest request, String password, HttpSession session){
		String email = (String) session.getAttribute("email");
		boolean falg = service.updatePassword(email, password);
		LOGGER.info("change_password," + email + "," + falg);
		if (falg) {
			return "redirect:/login";
		}
		return "500";
	}
	
	@RequestMapping("/emailIsExits")
	public @ResponseBody boolean emailIsExits(String email){
		return service.emailIsExits(email);
	}
}
