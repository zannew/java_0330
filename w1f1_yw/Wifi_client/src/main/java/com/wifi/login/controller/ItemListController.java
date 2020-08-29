package com.wifi.login.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/itemList")
public class ItemListController {

	@RequestMapping(method=RequestMethod.GET)
	public String getItemList() {
		
		return "items/itemList";
	}
	
}
