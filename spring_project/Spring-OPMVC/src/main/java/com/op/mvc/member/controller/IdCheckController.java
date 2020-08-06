package com.op.mvc.member.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.op.mvc.member.service.IdCheckService;

@Controller
public class IdCheckController {

	//서비스 가져오고
	@Autowired
	IdCheckService idCheckService;
	
	//요청 매핑 (해당 주소로 처리할 메서드이다.)
	@RequestMapping("/member/idCheck")
	
	// 리턴 객체를 HTTP응답으로 전송
	// 메서드의 반환 데이터를 뷰의 데이터로 사용
	@ResponseBody
	public String idCheck(@RequestParam("uid") String uid) {
		
		return idCheckService.IdCheck(uid);
	}
	
	
	
	
	
	
}
