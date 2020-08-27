package w1f1.ksy.login.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/board/itemList")
public class ItemListController {

	
	@RequestMapping(method=RequestMethod.GET)
	public String itemList() {
		
		return "board/itemList";
		
	}
	
}
