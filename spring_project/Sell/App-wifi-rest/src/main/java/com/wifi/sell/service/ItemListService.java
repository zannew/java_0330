package com.wifi.sell.service;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wifi.sell.dao.ItemDao;
import com.wifi.sell.model.Item;
import com.wifi.sell.model.ItemListView;
// 서비스 필수 요소 : dao, sqlSesstionTemplate
@Service
public class ItemListService {

	private ItemDao dao;
	
	@Autowired
	private SqlSessionTemplate sTemplate;

	// 전체 리스트
	public List<Item> getItemList() {

		dao = sTemplate.getMapper(ItemDao.class);
		
		return dao.selectList();
	}

	// 검색한 리스트
//	public ItemListView getSearchList(HttpServletRequest request) {
//		
//		dao = sTemplate.getMapper(ItemDao.class);
//		
//		Map<String, Object> search = new HashMap<String, Object>();
//		
//		// 검색 데이터 : searchType, keyword
//		String searchType=request.getParameter("searchType");
//		String keyword=request.getParameter("keyword");
//		
//		// 값이 공백이라면 null로 전달해주기
//		
//		if(searchType != null && !searchType.isEmpty()) {
//			search.put("searchType", searchType);
//		}
//		if(keyword != null && !keyword.isEmpty()) {
//			search.put("keyword", keyword);
//		}
//		
//		// view 로 전달할 결과 데이터
//		ItemListView listView = null;
//
//		// 전체 게시물 개수 구하기
//		int totalCnt = dao.totalCount(search);
//
//		// 한 페이지 당 노출할 게시물의 개수
//		final int ITEM_CNT_PER_PAGE = 3;
//
//		// 현재 페이지 번호
//		int currentPageNumber = 1;
//		String page = request.getParameter("page");
//		if (page != null) {
//			try {
//				currentPageNumber = Integer.parseInt(page);
//			} catch (NumberFormatException e) {
//				System.out.println("숫자 타입의 문자열이 전달되지 않아 예외 발생");
//			}
//		}
//
//		// 게시물의 첫번째 행의 index
//		int startRow = 0;
//
//		// 한 페이지 당 노출할 리스트
//		List<Item> itemList = null;
//		
//		if (totalCnt > 0) {
//			startRow = (currentPageNumber - 1) * ITEM_CNT_PER_PAGE;
//
//			System.out.println(startRow);
//			search.put("startRow", startRow);
//			search.put("count", ITEM_CNT_PER_PAGE);
//
//			itemList = dao.selectList(search);
//		} else {
//			currentPageNumber = 0;
//			itemList = Collections.emptyList();
//		}
//
//		listView = new ItemListView(totalCnt, currentPageNumber, itemList, ITEM_CNT_PER_PAGE, startRow);
//
//		System.out.println(listView);
//
//		return listView;
//		
//	}
	

}
