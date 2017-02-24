package com.chenyu.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.chenyu.entity.Food;
import com.chenyu.repository.FoodRepository;
import com.chenyu.service.FoodService;
import com.chenyu.util.Page;

@Service
public class FoodServiceImpl implements FoodService {
	
	@Resource
	private FoodRepository foodRepo;
	
	public Food findone(Long id) {
		return foodRepo.findone(id);
		
	}
	
	public Page<Food> findall() {
		List<Food> foodList = foodRepo.findall();
		return new Page<Food>(foodList.size(), foodList);
	}

	@Override
	public Map<Long, String> simpleMap() {
		List<Food> foodList = foodRepo.findall();
		Map<Long, String> simpleMap = new HashMap<Long, String>();
		for (Food food : foodList) {
			simpleMap.put(food.getId(), food.getName());
		}
		return simpleMap;
	}
}
