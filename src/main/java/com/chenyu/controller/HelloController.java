package com.chenyu.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController {
	
	@RequestMapping(value = "/hello", method = RequestMethod.GET)
	@ResponseBody
	public String Hello() {
		return "Hello";
	}
	
	@RequestMapping(value = "/hello/{name}", method = RequestMethod.GET)
	@ResponseBody
	public String Hello(@PathVariable String name) {
		return "Hello " + name;
	}
}
