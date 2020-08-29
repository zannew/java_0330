package com.wifi.order.controller;


import javax.servlet.http.HttpServletRequest;


import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import com.wifi.order.model.SellListView;
import com.wifi.order.model.ItemRegRequest;
import com.wifi.order.service.ItemDeleteService;
import com.wifi.order.service.ItemListService;
import com.wifi.order.service.ItemRegService;
import com.wifi.order.service.ItemViewService;


@RestController
@RequestMapping("/sell")
public class SellRestController {


	@Autowired
	private ItemListService listService;
	@Autowired
	private ItemViewService viewService;
	@Autowired
	private ItemRegService regService;
	@Autowired
	private ItemDeleteService deleteService;
	
	 
	@GetMapping	// GET방식으로 들어올 때만 처리하는 메서드 : GET| /sell
	public SellListView getItemList(HttpServletRequest request){

		System.out.println("In sell controller - request ▶ "+request);
		
		String midx=request.getParameter("midx");
		
		if(midx==null) {
			midx="midx is null";
		}
		
		System.out.println("midx : "+midx);
		
		SellListView sellListView=listService.getSellList(request);
		
		return sellListView;
	}
	
	
	//게시자의 midx리턴
	@GetMapping("/{iidx}")
	public int getMidx(@PathVariable("iidx") int iidx) {
		
		return viewService.getMidx(iidx);
	}
	
}
