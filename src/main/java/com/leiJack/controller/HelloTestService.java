package com.leiJack.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloTestService {
	
	@RequestMapping("/helloTestService")
	public String helloTestService() {
		return "hello,my name is testService";
	}
	
	
	@RequestMapping("/returnYourString")
	public String returnYourString(String str) {
		return "hello,your string is"+str;
	}
}
