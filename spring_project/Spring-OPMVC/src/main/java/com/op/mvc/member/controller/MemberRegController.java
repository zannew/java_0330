package com.op.mvc.member.controller;

import java.io.UnsupportedEncodingException;
import java.security.GeneralSecurityException;
import java.security.NoSuchAlgorithmException;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.op.mvc.member.model.MemberRegRequest;
import com.op.mvc.member.service.MemberRegService;
import com.op.mvc.util.AES256Util;
import com.op.mvc.util.Sha256;

@Controller
@RequestMapping("/member/memberReg")
public class MemberRegController {

	@Autowired
	MemberRegService regService;
	
//	@Autowired
//	private Sha256 sha256;
//	
//	@Autowired
//	private AES256Util aes256Util;
//	
//	// Spring security 암호화
//	@Autowired
//	private BCryptPasswordEncoder passwordEncoder;
	
	
	//요청한 url
	@RequestMapping(method=RequestMethod.GET)
	public String getMemberRegForm() {
		
		
		return "member/memberRegForm";
	}
	
	
	@RequestMapping(method=RequestMethod.POST)
	public String getMemberReg(MemberRegRequest regRequest, HttpServletRequest request,  Model model) throws NoSuchAlgorithmException, UnsupportedEncodingException, GeneralSecurityException {
		
		
		System.out.println("controller확인용 : "+regRequest);
		
		model.addAttribute("result", regService.memberReg(request, regRequest));
		
		return "member/memberReg";
	}
}
