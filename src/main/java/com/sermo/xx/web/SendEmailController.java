package com.sermo.xx.web;

import javax.annotation.Resource;
import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sermo.xx.utils.StringUtil;

@Controller
public class SendEmailController {
	private static Logger logger = Logger.getLogger(SendEmailController.class);
	
	private @Value("${spirng.mail.text}") String mailText;
	
	@Resource
	private JavaMailSenderImpl sender;
	
	@RequestMapping("/sendEmail")
	public String sendEmail(){
		MimeMessage message = sender.createMimeMessage();
		try {
			MimeMessageHelper helper = new MimeMessageHelper(message, true, "UTF-8");
			helper.setFrom("woshicainiao1573@163.com");
			helper.setTo("2275014030@qq.com");
			helper.setSubject("重置密码");
//			StringBuilder builder = new StringBuilder();
//			builder.append("<div style=\"border:1px solid #CCC;background:#F4F4F4;width:100%;text-align:left\">");
//			builder.append("<div style=\"font-size:14px;margin-bottom:20px;\">");
//			builder.append("<p style=\"margin-left:30px;\">大侠，密码太多容易忘记? 点击以下链接，再战江湖！</p>");
//			builder.append("<br/><a href=\"");
//			builder.append("https://www.baidu.com/");
//			builder.append("\"  style=\"margin-left:30px;\">");
//			builder.append("百度");
//			builder.append("</a></div></div>");
//			logger.info(builder.toString());
			String msg = StringUtil.format(mailText, "https://www.shiyanlou.com/", "实验楼");
			logger.info(msg);
			helper.setText(msg,true);
			sender.send(message);
			logger.info("发送邮件成功");
		} catch (MessagingException e) {
			e.printStackTrace();
		}
		return "/logins/login";
	}
}
