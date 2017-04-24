package com.chenyu.controller;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

import javax.annotation.Resource;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.FileUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.chenyu.constants.CacheConstants;
import com.chenyu.constants.UrlConstants;
import com.chenyu.domain.Food;
import com.chenyu.service.FoodService;
import com.chenyu.util.PageRequest;
import com.chenyu.util.PageResult;

@Controller
public class FoodController {

	@Resource
	private FoodService foodService;

	@RequestMapping(UrlConstants.FOOD)
	public String index() {
		return "food";
	}

	@RequestMapping(UrlConstants.FOOD_PAGE)
	@ResponseBody
	public PageResult<Food> food(final Integer pageNumber, final Integer pageSize) {
		if (pageNumber == null || pageSize == null) {
			return null;
		}
		Page<Food> page = foodService.page(new PageRequest(pageNumber, pageSize), new Specification<Food>() {
			@Override
			public Predicate toPredicate(Root<Food> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
				return null;
			}
		});
		return new PageResult<Food>(page.getTotalElements(), page.getContent());
	}
	
	@RequestMapping(UrlConstants.FOOD_POLLING)
	@ResponseBody
	public PageResult<Food> polling() {
		return new PageResult<Food>((long) CacheConstants.FOODS.size(), CacheConstants.FOODS);
	}

	@RequestMapping(UrlConstants.FOOD_ID)
	@ResponseBody
	public Food food(@PathVariable Long id) {
		return foodService.find(id);
	}

	@RequestMapping(UrlConstants.FOOD_UPLOAD)
	@ResponseBody
	public String upload(MultipartFile multipartFile, HttpServletRequest httpServletRequest,
			HttpServletResponse httpServletResponse) {
		if (multipartFile == null) {
			return null;
		}
		try {
			SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMdd");
			String path = "/WEB-INF/upload/" + simpleDateFormat.format(new Date());
			String realPath = httpServletRequest.getSession().getServletContext().getRealPath(path);
			File file = new File(realPath);
			if (!file.exists())
				file.mkdirs();
			String xlsFileName = multipartFile.getOriginalFilename();
			File xlsFile = new File(realPath + "/" + xlsFileName);
			FileUtils.copyInputStreamToFile(multipartFile.getInputStream(), xlsFile);
			System.out.println(xlsFile.getName());
			if (foodService.readIn(xlsFile)) {
				return "success";
			}
		} catch (Exception e) {
		}
		return "fail";
	}

	@RequestMapping(UrlConstants.FOOD_DOWNLOAD)
	@ResponseBody
	public String download(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) {
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMdd");
		String path = "/WEB-INF/download/" + simpleDateFormat.format(new Date());
		String realPath = httpServletRequest.getSession().getServletContext().getRealPath(path);
		File file = new File(realPath);
		if (!file.exists())
			file.mkdirs();
		String uuid = UUID.randomUUID().toString().replaceAll("-", "");
		String filePath = realPath + "/" + uuid + ".xls";
		if (foodService.writeOut(filePath)) {
			httpServletResponse.setHeader("Content-disposition", "attachment; filename=" + new File(filePath));
			return "success";
		}
		return "fail";
	}

}
