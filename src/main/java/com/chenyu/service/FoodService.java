package com.chenyu.service;

import java.util.Map;

import com.chenyu.domain.Food;
import com.chenyu.util.Page;

public interface FoodService {
	Food findone(Long id);
	
	Page<Food> findall();
	
	Map<Long, String> simpleMap(); 
}
