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
		System.out.println("定时任务测试-每5分钟输出该提示");
	}

	@Scheduled(cron = "0 * 9-17 * * ?")
	public void mail() {
		System.out.println("发邮件开始");
		mailService.sendMail();
		System.out.println("发邮件结束");
	}
}
