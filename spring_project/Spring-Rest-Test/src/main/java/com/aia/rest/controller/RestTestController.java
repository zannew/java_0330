package com.aia.rest.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.aia.rest.model.Member;

@RestController
@RequestMapping("/rest/v1")
public class RestTestController {

	@RequestMapping("/membermap")
	public Map<Integer, Member> getMap(){
		
		Map<Integer, Member> map = new HashMap<Integer, Member>();
		
		map.put(1, new Member(1, "cool@1", "123123", "COOL", "default.jpg", new Date()));
		map.put(2, new Member(2, "cool@1", "123123", "COOL", "default.jpg", new Date()));
		map.put(3, new Member(3, "cool@1", "123123", "COOL", "default.jpg", new Date()));
		map.put(4, new Member(4, "cool@1", "123123", "COOL", "default.jpg", new Date()));
		map.put(5, new Member(5, "cool@1", "123123", "COOL", "default.jpg", new Date()));
		
		return map;
	}
	
	
	//@RequestMapping(method=RequestMethod.GET)
	@GetMapping
	public Member getMember() {
		Member member = new Member();

		member.setIdx(1);
		member.setUid("cool@");
		member.setUname("COOL");
		
		return member;
	}
	
	
	@RequestMapping("/text")		// = "/rest/v1/text"
	public String testString() {
		return "HIHI RESTfUL";
	}
	
}
