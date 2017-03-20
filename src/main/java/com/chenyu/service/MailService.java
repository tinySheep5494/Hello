package com.chenyu.service;

import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.stereotype.Service;

@Service
public class MailService {
	
	public void sendMail() {
		String username = "ychen";
		String password = "etonenet@243698";
		String host = "mail.etonenet.com";
		int port = 22;
		String to = "ychen@mail.etonenet.com";
		JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
		mailSender.setHost(host);
		mailSender.setPort(port);
		mailSender.setUsername(username);
		mailSender.setPassword(password);
		SimpleMailMessage smm = new SimpleMailMessage();
		smm.setFrom(username.trim());
		smm.setTo(to);
		smm.setSubject("hello(title)");
		smm.setText("hello(content)");
		System.out.println("1");
		mailSender.send(smm);
		System.out.println("2");
	}
}
