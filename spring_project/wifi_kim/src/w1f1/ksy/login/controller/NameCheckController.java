package w1f1.ksy.login.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import w1f1.ksy.login.service.NameCheckService;

@Controller
public class NameCheckController {
	
	@Autowired
	NameCheckService nameCheckService;
	
	
	
	@ResponseBody
	@RequestMapping("/member/nameCheck")
	public String nameCheck (
			@RequestParam("name") String name
			) {
		
		
		return nameCheckService.checkName(name);
	}
	
	

}
