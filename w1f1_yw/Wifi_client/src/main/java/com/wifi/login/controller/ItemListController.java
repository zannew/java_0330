package com.wifi.login.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value="/items")
public class ItemListController {

	@RequestMapping(value="/itemList", method=RequestMethod.GET)
	public String getItemList() {
		
		return "items/itemList";
	}
	
	@RequestMapping(value="/regItem", method=RequestMethod.GET)
	public String regItem() {
		
		return "items/regForm";
	}
	
	public String getItemView() {
		
		return "items/regForm";
	}
	
	@RequestMapping(value="/view/{iidx}", method=RequestMethod.GET)
	public ModelAndView getItemView(@PathVariable("iidx") int iidx, Model model) {
		
		model.addAttribute("iidx", iidx);

		ModelAndView mandv = new ModelAndView();
		
		mandv.setViewName("items/itemView");
		
		
		return mandv;
	}
	
}
