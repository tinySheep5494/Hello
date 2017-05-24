package com.chenyu.service;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.io.FileUtils;
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
	
	public Iterable<Food> findAll() {
		return foodRepo.findAll();
	}

	/**
	 * 将excel文件(.xls/.xlsx)读入数据库
	 * 文件格式：首行为标题，第一列ID(不读入数据库)，第二列为名称，第三列为图标，第四列为价格，第五列为热量，第六列为饱食度，第七列为满意度
	 * 
	 * 得到文件对象，根据文件格式(后缀)读入Workbook，转化为Iterable对象，存入数据库
	 * @param file
	 * @return
	 */
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
					 * col1:Name col2:Icon col3:Price col4:Calorie col5:Hunger
					 * col6:Happiness
					 */
					// 首行不读
					if (row.getRowNum() == 0) {
						continue;
					}
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

	/**
	 * 数据库数据全部导出
	 * 文件格式：首行为标题，第一列ID(不读入数据库)，第二列为名称，第三列为图标，第四列为价格，第五列为热量，第六列为饱食度，第七列为满意度
	 * 
	 * 从数据库读出数据Iterable对象，存入新建的Workbook对象，生成指定路径文件，将Workbook写入文件输出流
	 * @param path
	 * @return
	 */
	@SuppressWarnings("resource")
	@Transactional(rollbackFor = Exception.class)
	public boolean writeOut(String path) {
		HSSFWorkbook hssfWorkbook = new HSSFWorkbook();
		Sheet sheet = hssfWorkbook.createSheet();
		List<Food> foods = (List<Food>) foodRepo.findAll();
		Row firstRow = sheet.createRow(0);
		firstRow.createCell(0).setCellValue("ID");
		firstRow.createCell(1).setCellValue("名称");
		firstRow.createCell(2).setCellValue("图标");
		firstRow.createCell(3).setCellValue("价格");
		firstRow.createCell(4).setCellValue("热量");
		firstRow.createCell(5).setCellValue("饱食度");
		firstRow.createCell(6).setCellValue("满意度");
		for (int i = 0; i < foods.size(); i++) {
			Row row = sheet.createRow(i + 1);
			row.createCell(0).setCellValue(foods.get(i).getId());
			row.createCell(1).setCellValue(foods.get(i).getName());
			row.createCell(2).setCellValue(foods.get(i).getIcon());
			row.createCell(3).setCellValue(foods.get(i).getPrice());
			row.createCell(4).setCellValue(foods.get(i).getCalorie());
			row.createCell(5).setCellValue(foods.get(i).getHunger());
			row.createCell(6).setCellValue(foods.get(i).getHappiness());
		}
		for (int i = 0; i < sheet.getRow(0).getPhysicalNumberOfCells(); i++) {
			sheet.autoSizeColumn(i);
		}
		try {
			FileOutputStream fileOutputStream = new FileOutputStream(path);
			hssfWorkbook.write(fileOutputStream);
			fileOutputStream.close();
			return true;
		} catch (Exception e) {
			return false;
		}
	}
	
	public byte[] writeByte(String path) {
		byte[] buffer = null;  
		if (writeOut(path)) {
			File file = new File(path);
			try {
				buffer = FileUtils.readFileToByteArray(file);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return buffer;
	}
	
	public File readByte(String path, byte[] bs) {
		File file = new File(path);
		try {
			FileUtils.writeByteArrayToFile(file, bs);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return file;
	}
}
