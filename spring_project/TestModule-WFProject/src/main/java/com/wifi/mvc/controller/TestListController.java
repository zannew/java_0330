package com.wifi.mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class TestListController {

	@RequestMapping("/testList")
	public String getTestList() {
		
		
		return "testmodule/testList";
	}
	
}
