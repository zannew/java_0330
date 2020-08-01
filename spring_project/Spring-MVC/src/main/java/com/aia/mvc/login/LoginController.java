package com.aia.mvc.login;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.aia.mvc.login.model.LoginRequest;

//@Controller없으면 명시적으로 설정
@Controller
@RequestMapping("/login/login")		//http://localhost:8080/mvc/login/login
public class LoginController {

	//get방식의 요청에 대한 처리 메서드→ LoginForm 페이지
	@RequestMapping(method=RequestMethod.GET)
	public String getLoginForm() {
		return "login/loginForm";		
		//	/WEB-INF/views/login/loginForm.jsp
	}
	
	//post방식의 요청에 대한 처리 메서드
	@RequestMapping(method=RequestMethod.POST) 
	public String login(HttpServletRequest request, 
						@RequestParam("uid") String userId,
						@RequestParam("upw") String userPw, 
						@ModelAttribute("login") LoginRequest loginRequest,	//loginRequest라는 이름을 "login"으로 바꿔서 저장
						Model model) {
		
		
		// request가 현재 들어오는 request인지 여부 확인용
		String uid = request.getParameter("uid");
		String upw = request.getParameter("upw");
		
		System.out.println("uid : "+uid);
		System.out.println("upw : "+upw);
		
		System.out.println("-------------------------------------------");
		System.out.println("userId : "+userId);
		System.out.println("userPw : "+userPw);
		System.out.println("-------------------------------------------");
		
		/*
		 * request.setAttribute("id", "scott");
		 * 
		 * model.addAttribute("id", uid); model.addAttribute("pw", upw);
		 */
		
		
		//자동으로 바인딩되어있음
		System.out.println(loginRequest.getUid());
		System.out.println(loginRequest.getUpw());
		
		
		return "login/login"; 
	}
	
	
	
	
	
	
	
}