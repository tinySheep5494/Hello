package com.chenyu.controller;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.annotation.Resource;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
	public PageResult<Food> food(final Integer pageNumber, final Integer pageSize) {
		Page<Food> page = foodService.page(new PageRequest(pageNumber - 1, pageSize), new Specification<Food>() {
			@Override
			public Predicate toPredicate(Root<Food> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
				return null;
			}
		});
		return new PageResult<Food>(page.getTotalElements(), page.getContent());
	}
	
	@RequestMapping(UrlConstants.FOOD_UPLOAD)
	@ResponseBody
	public String upload(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) {
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMdd");
		String path = "/WEB-INF/upload/" + simpleDateFormat.format(new Date());
		String realPath = httpServletRequest.getSession().getServletContext().getRealPath(path);
		File file = new File(realPath);
		if (!file.exists())
			file.mkdirs();
		String xlsFileName = "20170309xls.xls";
		File xlsFile = new File(realPath + "/" + xlsFileName);
		if (foodService.readIn(xlsFile)) {
			return "success";
		}
		return "fail";
	}
}
