package com.wifi.login.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.wifi.login.model.MemberRegRequest;
import com.wifi.login.service.MemberRegService;

@Controller
@RequestMapping("/member/memberReg")
public class MemberRegController {

	@Autowired
	private MemberRegService service;
	
	@RequestMapping(method=RequestMethod.GET)
	public String getMemberRegForm() {
		
		return "member/memberRegForm";
	}

	@RequestMapping(method=RequestMethod.POST)
	public String getMemberReg(HttpServletRequest request, MemberRegRequest regRequest, Model model) {
		
		System.out.println("MemberRegController-request : "+request);
		System.out.println("MemberRegController-regRequest : "+regRequest);
		System.out.println("MemberRegController-model : "+model);
		System.out.println("MemberRegController-service : "+service);
		
		model.addAttribute("result", service.regMember(regRequest, request));
		
		
		
		return "member/memberReg";
	}
}
