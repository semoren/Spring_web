package com.sermo.xx.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HelloController {
	
	@RequestMapping("/login")
	public String login(){
		return "logins/login";
	}
}
