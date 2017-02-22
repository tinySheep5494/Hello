package com.chenyu.controller.api;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.chenyu.constants.UrlConstants;

@Controller
public class ApiHelloController {

	@RequestMapping(UrlConstants.API_HELLO)
	@ResponseBody
	public String api_hello() {
		System.out.println("api hello method");
		return "Hello";
	}
	
	@RequestMapping("/api/hello/{name}")
	@ResponseBody
	public String api_hello(@PathVariable String name) {
		if(name != null)
			return "Hello " + name;
		return "Hello";
	}
}
