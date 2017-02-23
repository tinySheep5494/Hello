package com.chenyu.repository.impl;

import org.springframework.stereotype.Repository;

import com.chenyu.entity.Food;
import com.chenyu.repository.FoodRepository;

@Repository
public class FoodRepositoryImpl implements FoodRepository {

	@Override
	public Food findone() {
		Food food = new Food();
		food.setId(6L);
		food.setName("chips");
		food.setPrice(7.50D);
		food.setCalorie(50);
		food.setHunger(10);
		food.setHappiness(30);
		return food;
	}
	
	
}
