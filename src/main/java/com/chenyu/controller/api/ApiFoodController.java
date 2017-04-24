package com.chenyu.controller.api;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.chenyu.constants.UrlConstants;
import com.chenyu.service.FoodService;

@Controller
public class ApiFoodController {

	@Resource
	private FoodService foodService;
	
	@RequestMapping(UrlConstants.API_FOOD_DOWNLOAD)
	@ResponseBody
	public byte[] api_download(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) {
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMdd");
		String path = "/WEB-INF/download/" + simpleDateFormat.format(new Date());
		String realPath = httpServletRequest.getSession().getServletContext().getRealPath(path);
		File file = new File(realPath);
		if (!file.exists())
			file.mkdirs();
		String uuid = UUID.randomUUID().toString().replaceAll("-", "");
		String filePath = realPath + "/" + uuid + ".xls";
		byte[] bs = foodService.writeByte(filePath);
		return bs;
	}
}
