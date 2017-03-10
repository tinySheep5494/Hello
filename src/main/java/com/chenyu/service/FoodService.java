package com.chenyu.service;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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

	@Transactional(rollbackFor = Exception.class)
	public boolean readIn(File file) {
		InputStream inputStream = null;
		HSSFWorkbook hssfWorkbook;
		XSSFWorkbook xssfWorkbook;
		String fileSuffix = file.getName().substring(file.getName().lastIndexOf("."));
		List<Food> foods = null;
		try {
			try {
				foods = new ArrayList<Food>();
				inputStream = new FileInputStream(file);
				Sheet sheet0;
				if (".xls".equals(fileSuffix)) {
					hssfWorkbook = new HSSFWorkbook(inputStream);
					sheet0 = hssfWorkbook.getSheetAt(0);
				} else if (".xlsx".equals(fileSuffix)) {
					xssfWorkbook = new XSSFWorkbook(inputStream);
					sheet0 = xssfWorkbook.getSheetAt(0);
				} else {
					return false;
				}
				for (Row row : sheet0) {
					/*
					 * col1:Name
					 * col2:Icon
					 * col3:Price
					 * col4:Calorie
					 * col5:Hunger
					 * col6:Happiness
					 */
					Food food = new Food();
					food.setName(row.getCell(1).getStringCellValue());
					food.setIcon(row.getCell(2).getStringCellValue());
					food.setPrice(row.getCell(3).getNumericCellValue());
					food.setCalorie((int) row.getCell(4).getNumericCellValue());
					food.setHunger((int) row.getCell(5).getNumericCellValue());
					food.setHappiness((int) row.getCell(6).getNumericCellValue());
					foods.add(food);
				}
				foodRepo.save(foods);
				return true;
			} finally {
				if (inputStream != null) {
					inputStream.close();
				}
			}
		} catch (Exception e) {
			return false;
	    }
	}
	
	@Transactional(rollbackFor = Exception.class)
	public void writeOut() {
		
	}
}
