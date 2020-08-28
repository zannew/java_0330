package com.wifi.order.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wifi.order.model.Item;
import com.wifi.order.model.ItemListView;
import com.wifi.order.model.ItemRegRequest;
import com.wifi.order.service.ItemDeleteService;
import com.wifi.order.service.ItemListService;
import com.wifi.order.service.ItemRegService;
import com.wifi.order.service.ItemViewService;

@RestController
@RequestMapping("/items")
public class ItemRestController {

	@Autowired
	private ItemListService listService;
	@Autowired
	private ItemViewService viewService;
	@Autowired
	private ItemRegService regService;
	@Autowired
	private ItemDeleteService deleteService;
	
	 
	@GetMapping	// GET방식으로 들어올 때만 처리하는 메서드 : GET| /items
	public ItemListView getItemList(HttpServletRequest request){

		System.out.println("In controller - request ▶ "+request);
		
		String searchType=request.getParameter("searchType");
		String istate=request.getParameter("istate");
		String keyword=request.getParameter("keyword");
		
		if(keyword.isEmpty()) {
			keyword="keyword : 널";
		}
		if(istate==null) {
			istate="istate : 널";
		}
		
		System.out.println("C에서 searchType : "+searchType);
		System.out.println("C에서 istate : "+istate);
		System.out.println("C에서 keyword : "+keyword);
		
		ItemListView itemListView=null;
		
		if(istate.equals("1")) {							
			itemListView=listService.getItemRList(request);
			System.out.println("getItemRList호출");
		}else if (istate.equals("0")) {
			itemListView=listService.getItemList(request);
			System.out.println("getItemList호출");
		}else {
			itemListView=listService.getItemList(request);
			System.out.println("else 호출");
			
		}
		
		return itemListView;
	}
	
	// Get방식 
	@GetMapping("/{iidx}")
	public Item getItem(@PathVariable("iidx") int iIdx) {
		
		return viewService.getItem(iIdx);
	}
	
	
	// 공구 등록 결과 반환
	@PostMapping		// POST방식으로 들어올 때만 처리하는 메서드 : POST| /items
	public int regItem(ItemRegRequest regRequest, HttpServletRequest request) {
		
		System.out.println("In Controller - regRequest ▶ "+ regRequest);
		
		return regService.regItem(regRequest, request);
	}
	
	// 공구 삭제 결과 반환
	@DeleteMapping("/{iidx}")
	public int deleteItem(@PathVariable("iidx") int iidx) {
		
		
		return deleteService.deleteItem(iidx);
	}
	
}
