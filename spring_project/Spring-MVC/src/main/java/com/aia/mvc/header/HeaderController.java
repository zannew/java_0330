package com.aia.mvc.header;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HeaderController {

	@RequestMapping("/header/getHeader")
	public String getHeader(@RequestHeader("referer") String referer, Model model) {
		
		// header로 데이터 수집 → 트래킹 분석, 패턴 확인
		model.addAttribute("referer", referer);
		
		return "/header/getHeader";
	}
	
}