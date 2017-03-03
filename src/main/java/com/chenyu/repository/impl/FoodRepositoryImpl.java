package com.chenyu.repository.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.chenyu.domain.Food;
import com.chenyu.repository.FoodRepository;

@Repository
public class FoodRepositoryImpl implements FoodRepository {

	@Override
	public Food findOne(Long id) {
		if (id != null) {
			List<Food> foodList = this.findall();
			for (Food food : foodList) {
				if (id.equals(food.getId())) {
					return food;
				}
			}
		}
		return null;
	}

	@Override
	public List<Food> findall() {
		List<Food> foodList = new ArrayList<Food>();
		Food food1 = new Food();
		food1.setId(6L);
		food1.setName("chips");
		food1.setPrice(7.50D);
		food1.setCalorie(50);
		food1.setHunger(10);
		food1.setHappiness(30);
		Food food2 = new Food();
		food2.setId(7L);
		food2.setName("hamburger");
		food2.setPrice(17.50D);
		food2.setCalorie(50);
		food2.setHunger(25);
		food2.setHappiness(35);
		Food food3 = new Food();
		food3.setId(8L);
		food3.setName("Coca-Cola");
		food3.setPrice(8.50D);
		food3.setCalorie(30);
		food3.setHunger(10);
		food3.setHappiness(30);
		foodList.add(food1);
		foodList.add(food2);
		foodList.add(food3);
		return foodList;
	}

}
