package com.chenyu.controller.remote;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;

import com.chenyu.constants.UrlConstants;

@Controller
public class RemoteHelloController {

	@Resource
	RestTemplate restTemplate;
	
	@Value("${hello.host}")
	private String host;

	@RequestMapping(UrlConstants.REMOTE_HELLO)
	@ResponseBody
	public String remote_hello() {
		System.out.println("remote hello method");
		String targetUrl = host + "/api/hello";
		String result = restTemplate.getForObject(targetUrl, String.class);
		return result;
	}

	@RequestMapping("/remote/hello/{name}")
	@ResponseBody
	public String remote_hello(@PathVariable String name) {
		System.out.println("remote hello " + name + " method");
		String targetUrl = host + "/api/hello/{unm}";
		String unm = name;
		String result = restTemplate.getForObject(targetUrl, String.class, unm);
		return result;
	}

}