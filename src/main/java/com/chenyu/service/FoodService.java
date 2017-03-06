package com.chenyu.service;

import javax.annotation.Resource;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import com.chenyu.domain.Food;
import com.chenyu.repository.FoodRepository;

@Service
public class FoodService {
	
	@Resource
	private FoodRepository foodRepo;
	
	public Food find(Long id) {
		return foodRepo.findOne(id);
	}
	
	public Page<Food> page(PageRequest pageRequest, Specification<Food> spec) {
		return foodRepo.findAll(spec, pageRequest);
	}
}
