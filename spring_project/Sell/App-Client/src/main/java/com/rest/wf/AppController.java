package com.rest.wf;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AppController {

	@RequestMapping("/index")
	public String index() {
		
		
		return "appStarter";
	}
	
	
}
