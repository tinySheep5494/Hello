package com.chenyu.service;

import com.chenyu.entity.Food;
import com.chenyu.util.Page;

public interface FoodService {
	Food findone(Long id);
	
	Page<Food> findall();
}
