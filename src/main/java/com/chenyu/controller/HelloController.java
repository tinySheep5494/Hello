package com.chenyu.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.chenyu.constants.UrlConstants;

@Controller
public class HelloController {
	
	@RequestMapping(value = "/hello", method = RequestMethod.GET)
	@ResponseBody
	public String hello() {
		return "Hello";
	}
	
	@RequestMapping(value = UrlConstants.HELLO_NAME, method = RequestMethod.GET)
	@ResponseBody
	public String hello(@PathVariable String name) {
		return "Hello " + name;
	}
}
