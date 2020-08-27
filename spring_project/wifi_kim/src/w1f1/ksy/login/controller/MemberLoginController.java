package w1f1.ksy.login.controller;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import w1f1.ksy.login.model.LoginRequest;
import w1f1.ksy.login.service.MemberLoginService;

@Controller
@RequestMapping("/member/loginForm")
public class MemberLoginController {
	
	@Autowired
	MemberLoginService loginService;
	
	@RequestMapping(method=RequestMethod.GET)
	public String loginForm() {
		return "member/loginForm";
		
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public String login(
			LoginRequest loginRequest,
			HttpSession session,
			HttpServletResponse response,
			Model model
			) {
		
		model.addAttribute("result", loginService.login(loginRequest, session, response));
		
		return "member/login";
	}
}
