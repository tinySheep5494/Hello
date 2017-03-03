package com.chenyu.controller;

import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.chenyu.constants.UrlConstants;
import com.chenyu.domain.Food;
import com.chenyu.service.FoodService;
import com.chenyu.util.Page;

@Controller
public class FoodController {

	@Resource
	private FoodService foodService;
	
	@RequestMapping(UrlConstants.FOOD_ID)
	@ResponseBody
	public Food food(@PathVariable Long id) {
		return foodService.findone(id);
	}
	
	@RequestMapping(UrlConstants.FOOD)
	@ResponseBody
	public Page<Food> food() {
		return foodService.findall();
	}
	
	@RequestMapping(UrlConstants.FOOD_SIMPLE)
	@ResponseBody
	public Map<Long, String> foodSimpleList() {
		return foodService.simpleMap();
	}
}
