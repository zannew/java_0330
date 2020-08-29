package com.wifi.order.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wifi.order.model.Rvs;
import com.wifi.order.model.RvsView;
import com.wifi.order.service.ItemListService;

@RestController
@RequestMapping("/rvs")
public class RvsController {

	@Autowired
	ItemListService service;
	
	@GetMapping
	public Rvs getRvs(HttpServletRequest request) {
		
		Rvs rvsView = null;
		
		rvsView = service.getRvs(request);
		
		
		return rvsView;
	}
	
}
