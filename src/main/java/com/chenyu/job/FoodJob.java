package com.chenyu.job;

import javax.annotation.Resource;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.chenyu.constants.CacheConstants;
import com.chenyu.domain.Food;
import com.chenyu.service.FoodService;

@Component
public class FoodJob {
	
	@Resource
	FoodService FoodService;
	
	@Scheduled(cron = "0/30 * * * * ?")
	public void food() {
//		System.out.println("更新数据开始");
//		CacheConstants.FOODS.clear();
//		for (Food food : FoodService.findAll()) {
//			CacheConstants.FOODS.add(food);
//		}
//		System.out.println("更新数据完成");
	}

}
