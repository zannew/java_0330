package com.aia.mvc.order.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.aia.mvc.order.model.OrderCommand;

@Controller
public class OrderController {
	
	//name값을 @Controller에서 설정할 수 있다. → 사용에 제한적 → 관리를 위해 controller를 나누는게 better
	@RequestMapping(value = "/order/order", method = RequestMethod.GET)
	public String orderForm() {
		
		return "order/orderForm";
		//order폴더 안에 orderForm.jsp로 감
	}
	
	@RequestMapping(value="/order/order", method = RequestMethod.POST)
	public String order(OrderCommand order) {
		
		System.out.println(order);
		
		return "order/order";
	}
	
	
	

}