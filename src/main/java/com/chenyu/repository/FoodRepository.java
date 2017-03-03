package com.chenyu.repository;

import java.util.List;

import com.chenyu.domain.Food;

public interface FoodRepository extends BaseRepostory<Food, Long> {
	Food findOne(Long id);
	
	List<Food> findall();
}