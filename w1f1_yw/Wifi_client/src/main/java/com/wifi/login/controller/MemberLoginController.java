package com.wifi.login.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.wifi.login.model.LoginRequest;
import com.wifi.login.service.MemberLoginService;

@Controller
@RequestMapping("/member/loginForm")
public class MemberLoginController {

	@Autowired
	MemberLoginService service;
	
	@RequestMapping(method=RequestMethod.GET)
	public String getLoginForm() {
		
		return "member/loginForm";
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public String getLogin(LoginRequest loginRequest, HttpSession session, HttpServletRequest request, HttpServletResponse response, Model model) {
		
		model.addAttribute("result", service.login(loginRequest, session, response));
		
		return "member/login";
	}
}
