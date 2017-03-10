package com.chenyu.controller.api;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.chenyu.constants.UrlConstants;

@Controller
public class ApiHelloController {

	@Value("${remoteAddr}")
	private String[] remoteAddrs;
	
	@RequestMapping(UrlConstants.API_HELLO)
	@ResponseBody
	public String api_hello() {
		return "Hello";
	}
	
	@RequestMapping(UrlConstants.API_HELLO_NAME)
	@ResponseBody
	public String api_hello(@PathVariable String name, HttpServletRequest request) {
		String requestRemoteAddr = request.getRemoteAddr();
		boolean ipPermission = false;
		for (String remoteAddr : remoteAddrs) {
			if (requestRemoteAddr != null && requestRemoteAddr.equals(remoteAddr)) {
				ipPermission = true;
			}
		}
		if (ipPermission) {
			if(name != null)
				return "Hello " + name;
			return "Hello";
		}
		return "wrong request, your ip address without permission";
	}
}
