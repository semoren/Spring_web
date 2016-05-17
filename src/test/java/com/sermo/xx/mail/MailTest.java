package com.sermo.xx.mail;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;

public class MailTest {
	public static void main(String[] args) throws MessagingException {
		JavaMailSenderImpl sender = new JavaMailSenderImpl();
		sender.setHost("smtp.163.com");
		sender.setUsername("");
		sender.setPassword("");
		MimeMessage message = sender.createMimeMessage();
		MimeMessageHelper helper = new MimeMessageHelper(message);
		helper.setTo("2275014030@qq.com");
		helper.setText("测试邮件");
		sender.send(message);
	}
}
