package com.sermo.xx.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HelloController {
	
	@RequestMapping("/login")
	public String login(){
		System.out.println("页面调转");
		return "views/index";
	}
}
