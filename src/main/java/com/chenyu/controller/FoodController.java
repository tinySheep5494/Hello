package com.chenyu.controller;

import javax.annotation.Resource;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.chenyu.constants.UrlConstants;
import com.chenyu.domain.Food;
import com.chenyu.service.FoodService;
import com.chenyu.util.PageResult;

@Controller
public class FoodController {

	@Resource
	private FoodService foodService;
	
	@RequestMapping(UrlConstants.FOOD_ID)
	@ResponseBody
	public Food food(@PathVariable Long id) {
		return foodService.find(id);
	}
	
	@RequestMapping(UrlConstants.FOOD)
	@ResponseBody
	public PageResult<Food> food() {
		Page<Food> page = foodService.page(new PageRequest(1, 10), new Specification<Food>() {
			
			@Override
			public Predicate toPredicate(Root<Food> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
				// TODO Auto-generated method stub
				return null;
			}
		});
		return new PageResult<Food>(page.getTotalElements(), page.getContent());
	}
}
