package com.chenyu.job;

import javax.annotation.Resource;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.chenyu.service.MailService;

@Component
public class CountingJob {
	
	@Resource
	MailService mailService;

	@Scheduled(cron = "0 0/5 * * * ? ")
	public void time() {
//		System.out.println("定时任务测试-每5分钟输出该提示");
	}

	@Scheduled(cron = "0/10 * * * * ?")
	public void mail2() {
//		System.out.println("发邮件开始");
//		mailService.sendMail("ch243698@163.com","test","test");
//		System.out.println("发邮件结束");
	}
}
