package com.wifi.sell.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wifi.sell.model.Item;
import com.wifi.sell.model.ItemDeleteRequest;
import com.wifi.sell.model.ItemListView;
import com.wifi.sell.model.ItemRegRequest;
import com.wifi.sell.service.ItemDeleteService;
import com.wifi.sell.service.ItemListService;
import com.wifi.sell.service.ItemRegService;
import com.wifi.sell.service.ItemViewService;

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
	
	@GetMapping			// GET방식으로 들어올 때만 처리하는 메서드 : GET| /items
	public List<Item> getItemList(){
		
		//System.out.println("In controller - request ▶ "+request);
		
		return listService.getItemList();
	}
	
	@GetMapping("/{iIdx}")
	public Item getItem(@PathVariable("iIdx") int iIdx) {
		
		return viewService.getItem(iIdx);
	}
	
	@GetMapping("/{searchType}/{keyword}")
	public List<Item> getSearchList(@PathVariable("searchType") String searchType, @PathVariable("keyword") String keyword){
		
		return viewService.getItemList(searchType, keyword);
	}
	
	
//	@GetMapping
//	public ItemListView getSearchList(HttpServletRequest request){
//		
//		return listService.getSearchList(request);
//	}
	
	
	// 공구 등록 결과 반환
	@PostMapping		// POST방식으로 들어올 때만 처리하는 메서드 : POST| /items
	public int regItem(ItemRegRequest regRequest, HttpServletRequest request) {
		
		System.out.println("In Controller - regRequest ▶ "+ regRequest);
		
		return regService.regItem(regRequest, request);
	}
	
	// 공구 삭제 결과 반환
	@DeleteMapping("/{iIdx}")
	public int deleteItem(@PathVariable("iIdx") int iIdx) {
		
		
		return deleteService.deleteItem(iIdx);
	}
	
}
