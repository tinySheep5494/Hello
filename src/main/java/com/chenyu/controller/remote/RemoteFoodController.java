package com.chenyu.controller.remote;

import java.io.IOException;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Controller;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;

import com.chenyu.constants.UrlConstants;
import com.chenyu.service.FoodService;

@Controller
public class RemoteFoodController {

	@Resource
	private FoodService foodService;

	@Resource
	RestTemplate restTemplate;

	@Value("${host}")
	private String host;

	@RequestMapping(UrlConstants.REMOTE_FOOD_DOWNLOAD)
	@ResponseBody
	public void remote_food_download(@RequestParam LinkedMultiValueMap<String, Object> params,
			@RequestHeader HttpHeaders headers, HttpServletResponse response) {
		String targetUrl = host + "/api/food/download";
		byte[] result = restTemplate.exchange(targetUrl, HttpMethod.GET,
				new HttpEntity<LinkedMultiValueMap<String, Object>>(null, headers), byte[].class).getBody();
		try {
			response.setHeader("Content-disposition",
					"attachment; filename=food.xls");
			response.getOutputStream().write(result);
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				response.getOutputStream().close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
