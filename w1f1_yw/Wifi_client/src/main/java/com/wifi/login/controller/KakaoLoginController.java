package com.wifi.login.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.wifi.login.service.KakaoLoginService;

@Controller
public class KakaoLoginController {

	@RequestMapping(value="/index", method=RequestMethod.GET)
	public ModelAndView kakaoLoginForm(HttpSession session) {
		
		ModelAndView mandv = new ModelAndView();
		
		String kakaoUrl = KakaoLoginService.getAuthorizationUrl(session);
		
		System.out.println("KakaoLoginController-KakaoLoginForm : "+kakaoUrl);
		
		mandv.addObject("kakaoUrl", kakaoUrl);
		
		return mandv;
	}
	@RequestMapping(value="/kakaoLogin", produces="application/json", method={RequestMethod.GET, RequestMethod.POST})
	public String kakaoLogin(@RequestParam("code") String code, 
							HttpServletRequest request, 
							HttpServletResponse response, 
							HttpSession session) {
		
		
		return "";
	}
	
	
	
}
