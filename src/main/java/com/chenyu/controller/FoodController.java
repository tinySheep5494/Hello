package com.chenyu.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.chenyu.entity.Food;

@Controller
public class FoodController {

	@RequestMapping(value = "/food", method = RequestMethod.GET)
	@ResponseBody
	public Food food() {
		Food food = new Food();
		food.setId(1L);
		food.setName("bread");
		food.setCalorie(120);
		food.setPrice(3.50D);
		food.setHunger(10);
		food.setHappiness(5);
		return food;
	}
}
