package com.aia.mvc.search;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.aia.mvc.search.model.SearchType;

@Controller
public class SearchController {

	//파라미터의 값을 매개변수에 저장해서 받음 (String → int 형변환 ok)
	//속성 이름이 두개 이상이 경우 따로 지정
	@RequestMapping("/search")
	public String search(@RequestParam(name="query", required = false) String query, 
						@RequestParam(name="page", defaultValue= "1") int pageNumber,
						Model model) {
						//defaultValue는 String타입
		
		model.addAttribute("query", query);
		model.addAttribute("page", pageNumber);
		
		return "search/search";
	}
	
	@RequestMapping("/search/searchForm")
	public String searchForm() {
		
		return "search/searchForm";
	}
	
	
	@ModelAttribute("searchType")	//searchType이라는 이름으로 위에 메서드들을 공유
	public List<SearchType> searchType(){
		
		List<SearchType> options = new ArrayList<SearchType>();
		
		options.add(new SearchType(1, "전체"));
		options.add(new SearchType(2, "이름"));
		options.add(new SearchType(3, "포지션"));
		
		return options;
	} 
	
	
}