package com.aia.member.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
@RequestMapping("/")
public class IndexController {

	@GetMapping
	public String index() {
		//return "Member Restful API!";
		
		return "index";
	}
	
}
