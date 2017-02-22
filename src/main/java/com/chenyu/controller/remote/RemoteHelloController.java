package com.chenyu.controller.remote;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;

import com.chenyu.constants.UrlConstants;

@Controller
public class RemoteHelloController {

	@Value("${hello.host}")
	private String host;

	@RequestMapping(UrlConstants.REMOTE_HELLO)
	@ResponseBody
	public String remote_hello() {
		RestTemplate restTemplate = new RestTemplate();
		System.out.println("remote hello method");
		String targerUrl = host + "/api/hello";
		String result = restTemplate.getForObject(targerUrl, String.class);
		return result;
	}

	@RequestMapping("/remote/hello/{name}")
	@ResponseBody
	public String remote_hello(@PathVariable String name) {
		RestTemplate restTemplate = new RestTemplate();
		String targerUrl = host + "/api/hello/{name}";
		String result = restTemplate.getForObject(targerUrl, String.class, name);
		return result;
	}

}
