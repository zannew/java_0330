package com.wifi.order.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wifi.order.model.OrderRegRequest;
import com.wifi.order.service.OrderCheckCount_wService;
import com.wifi.order.service.OrderRegService;

@RestController
@RequestMapping("/orders")
public class OrderRestController {

	
	// 공구 참여 신청 ( 1. 대기 가능 인원 체크 → 2. 요청 )
	// 체크 count_w
	@Autowired
	private OrderCheckCount_wService checkService;
	
	// 요청 등록
	@Autowired
	private OrderRegService regService;
	
	
	// 공구 참여 신청 취소
	
	// 글 삭제 처리..? 머지.....
	

	// aside - 내가 요청한 공구 목록

	@GetMapping("/{iidx}")
	public int checkCount_w(@PathVariable("iidx") int iidx) {
		
		return checkService.selectCount_w(iidx);
	}
	
	
	@PostMapping
	public int regOrder(OrderRegRequest regRequest, HttpServletRequest request) {
		
		System.out.println("In OrderRestController - regOrder ▶ request : "+request);
		
		
		
		return regService.insertOrder(regRequest, request);
		
	}
	
}
