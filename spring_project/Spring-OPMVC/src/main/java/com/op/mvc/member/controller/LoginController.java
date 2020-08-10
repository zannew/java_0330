package com.op.mvc.member.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.op.mvc.member.model.LoginRequest;
import com.op.mvc.member.service.MemberLoginService;




//@Controller없으면 명시적으로 설정
@Controller
@RequestMapping("/login/login")		//http://localhost:8080/mvc/login/login
public class LoginController {
	
	@Autowired
	MemberLoginService loginService;

	//get방식의 요청에 대한 처리 메서드→ LoginForm 페이지
	@RequestMapping(method=RequestMethod.GET)
	public String getLoginForm() {
		return "member/loginForm";		
		//	/WEB-INF/views/login/loginForm.jsp
	}
	
	//post방식의 요청에 대한 처리 메서드
	@RequestMapping(method=RequestMethod.POST) 
	public String login(LoginRequest loginRequest,
			HttpSession session,
			HttpServletResponse response,
			Model model) {
		
		
		model.addAttribute("result", loginService.login(loginRequest, session, response));
		
		
		return "member/login"; 
	}
	
	
}