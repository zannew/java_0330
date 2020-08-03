package com.op.mvc.member.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.op.mvc.member.model.MemberRegRequest;
import com.op.mvc.member.service.MemberRegService;

@Controller
@RequestMapping("/member/memberReg")
public class MemberRegController {

	@Autowired
	MemberRegService regService;
	
	//요청한 url
	@RequestMapping(method=RequestMethod.GET)
	public String getMemberRegForm() {
		
		
		return "member/memberRegForm";
	}
	
	
	@RequestMapping(method=RequestMethod.POST)
	public String getMemberReg(MemberRegRequest regRequest, HttpServletRequest request,  Model model) {
		
		
		System.out.println("controller확인용 : "+regRequest);
		
		model.addAttribute("result", regService.memberReg(request, regRequest));
		
		return "member/memberReg";
	}
}
