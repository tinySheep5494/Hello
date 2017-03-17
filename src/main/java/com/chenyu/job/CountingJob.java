package com.chenyu.job;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class CountingJob {
	
	@Scheduled(cron="0/5 * *  * * ? ")
	public void time() {
		System.out.println("定时任务测试-每5秒输出该提示");
	}
	
}
