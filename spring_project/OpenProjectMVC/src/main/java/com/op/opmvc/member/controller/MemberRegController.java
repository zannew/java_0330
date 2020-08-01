package com.op.opmvc.member.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.op.opmvc.member.model.RegRequest;

@Controller
@RequestMapping("/member/memberReg")	//http://localhost:8080/opmvc/member/memberReg
public class MemberRegController {

	@RequestMapping(method=RequestMethod.POST)
	public String getMemberRegForm() {
		
		return "member/memberRegForm";
		// /WEB-INF/views/member/memberRegForm.jsp
		
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public String memberReg(HttpServletRequest request,
							@RequestParam("uid") String userId,
							@RequestParam("upw") String userPw,
							@ModelAttribute("member") RegRequest regRequest) {
		
		return "member/memberReg";
	}
	
	
	
	
}
