package com.wifi.login;

import java.util.Locale;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MainController {

	@RequestMapping("/index")
	public String main(Locale locale, Model model) {
		
		return "main";
	}
	
	@RequestMapping("/itemView/iidx={iidx}")
	public ModelAndView getItemView(@PathVariable("iidx") int iidx, Model model) {
		
		model.addAttribute("iidx", iidx);

		ModelAndView mandv = new ModelAndView();
		
		mandv.setViewName("items/itemView");
		
		
		return mandv;
	}
}
