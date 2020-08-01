package com.aia.mvc;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HelloController {

	// view의 이름을 return
	@RequestMapping("/hello")
	public String hello(Model model) {
		
		model.addAttribute("msg", "안녕하세요");
		
		
		return "hello/hello";
		// /WEB-INF/views/hello/hello.jsp	→ 여기로 갈거야(view페이지)
		
	}
	
	
}