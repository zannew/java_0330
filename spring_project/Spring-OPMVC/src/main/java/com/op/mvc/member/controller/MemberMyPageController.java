package com.op.mvc.member.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MemberMyPageController {

	@RequestMapping("/member/mypage/mypage")
	public String getMyPage() {
		return "member/mypage";
	}
	
}
