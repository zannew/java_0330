package com.wifi.order.service;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wifi.order.dao.ItemDao;
import com.wifi.order.model.ItemListView;
import com.wifi.order.model.MyItem;
import com.wifi.order.model.MySell;
import com.wifi.order.model.SellListView;

@Service
public class ItemListService {

	private ItemDao dao;
	
	@Autowired
	private SqlSessionTemplate sTemplate;
	
	// 전체리스트 - 추천/일반
	public ItemListView getItemList(HttpServletRequest request) {
		
		dao = sTemplate.getMapper(ItemDao.class);

		Map<String, Object> search = new HashMap<String, Object>();

		// 검색 데이터 : searchType, keyword
		String searchType = request.getParameter("searchType");
		String istate = request.getParameter("istate");
		String keyword = request.getParameter("keyword");
		String count = request.getParameter("count");

		System.out.println("searchType : " + searchType);
		System.out.println("keyword : " + keyword);

		// 값이 공백이라면 null로 전달해주기
		if (searchType != null && !searchType.isEmpty()) {
			search.put("searchType", searchType);
		}

		if (keyword != null && !keyword.isEmpty()) {
			if(searchType=="category") {
				int categoryNum =  Integer.parseInt(keyword);
				if(categoryNum==7) {
					categoryNum=0;
					search.put("keyword", categoryNum);
					System.out.println("7일 때 categoryNum : "+categoryNum);
				}else {
					search.put("keyword", categoryNum);
					System.out.println("7이 아닐 때 categoryNum : "+categoryNum);
				}
			}else {
				search.put("keyword", keyword);
			}
		}
		
		if (istate != null && !istate.isEmpty()) {
			search.put("istate", istate);
		}

		// view 로 전달할 결과 데이터
		ItemListView listView = null;

		// 전체 게시물 개수 구하기
		int itemTotalCnt = dao.totalCount(search);
		System.out.println("일반totalCnt ▶" + itemTotalCnt);

		// 한 페이지 당 노출할 게시물의 개수
		int ITEM_CNT_PER_PAGE = 10;
		if (count != null) {
			try {
				ITEM_CNT_PER_PAGE = Integer.parseInt(count);
				System.out.println("ITEM_CNT_PER_PAGE : "+ITEM_CNT_PER_PAGE);
			} catch (NumberFormatException e) {
				System.out.println("숫자 타입의 문자열이 전달되지 않아 예외 발생");
			}
		}

		// 현재 페이지 번호
		int currentPageNumber = 1;
		String page = request.getParameter("page");
		System.out.println("▶page : " + page);
		System.out.println("▶searchType : " + searchType);
		System.out.println("▶istate : " + istate);
		System.out.println("▶keyword : " + keyword);

		if (page != null) {
			try {
				currentPageNumber = Integer.parseInt(page);
			} catch (NumberFormatException e) {
				System.out.println("숫자 타입의 문자열이 전달되지 않아 예외 발생");
			}
		}

		// 게시물의 첫번째 행의 index
		int startRow = 0;

		// 한 페이지 당 노출할 리스트
		List<MyItem> itemList = null;

		if (itemTotalCnt > 0) {
			startRow = (currentPageNumber - 1) * ITEM_CNT_PER_PAGE;

			System.out.println("startRow ▶" + startRow);
			search.put("startRow", startRow);
			search.put("count", ITEM_CNT_PER_PAGE);

			itemList = dao.selectList(search);
			System.out.println("itemList ▶" + itemList);

		} else {
			currentPageNumber = 0;
			itemList = Collections.emptyList();
		}

		listView = new ItemListView(itemTotalCnt, currentPageNumber, itemList, ITEM_CNT_PER_PAGE, startRow);

		System.out.println("▶ listView : " + listView);

		return listView;
		
	}
	
	// 전체 리스트 - (추천)공구글 - 검색없음, 스크롤 없이 10개 상단 고정
		public ItemListView getItemRList(HttpServletRequest request) {
			
			dao = sTemplate.getMapper(ItemDao.class);

			Map<String, Object> search = new HashMap<String, Object>();

			// 검색 데이터 : searchType, keyword
			String searchType = request.getParameter("searchType");
			//String istate = (request.getParameter("istate"));
			int istate=Integer.parseInt(request.getParameter("istate"));
			String keyword = request.getParameter("keyword");
			String count = request.getParameter("count");

			System.out.println("searchType : " + searchType);
			System.out.println("keyword : " + keyword);

			// 값이 공백이라면 null로 전달해주기
			if (searchType != null && !searchType.isEmpty()) {
				search.put("searchType", searchType);
			}

			if (keyword != null && !keyword.isEmpty()) {
				search.put("keyword", keyword);
			}
			search.put("istate", istate);

			// view 로 전달할 결과 데이터
			ItemListView listView = null;

			// 전체 게시물 개수 구하기
			int itemTotalCnt = dao.totalCount(search);
			System.out.println("추천totalCnt ▶" + itemTotalCnt);

			// 한 페이지 당 노출할 게시물의 개수
			final int ITEM_CNT_PER_PAGE = 10;
			if (count != null) {
				try {
					// ITEM_CNT_PER_PAGE = Integer.parseInt(count);
				} catch (NumberFormatException e) {
					System.out.println("숫자 타입의 문자열이 전달되지 않아 예외 발생");
				}
			}

			// 현재 페이지 번호
			int currentPageNumber = 1;
			String page = request.getParameter("page");
			String rpage = request.getParameter("rpage");
			System.out.println("▶page : " + page);
			System.out.println("▶searchType : " + searchType);
			System.out.println("▶istate : " + istate);
			System.out.println("▶keyword : " + keyword);

			if (page != null) {
				try {
					currentPageNumber = Integer.parseInt(page);
				} catch (NumberFormatException e) {
					System.out.println("숫자 타입의 문자열이 전달되지 않아 예외 발생");
				}
			}
			if (rpage != null) {
				try {
					currentPageNumber = Integer.parseInt(rpage);
				} catch (NumberFormatException e) {
					System.out.println("숫자 타입의 문자열이 전달되지 않아 예외 발생");
				}
			}

			// 게시물의 첫번째 행의 index
			int startRow = 0;

			// 한 페이지 당 노출할 리스트
			List<MyItem> itemList = null;

			if (itemTotalCnt > 0) {
				startRow = (currentPageNumber - 1) * ITEM_CNT_PER_PAGE;

				System.out.println("startRow ▶" + startRow);
				search.put("startRow", startRow);
				search.put("count", ITEM_CNT_PER_PAGE);

				itemList = dao.selectList(search);
				System.out.println("itemList ▶" + itemList);

			} else {
				currentPageNumber = 0;
				itemList = Collections.emptyList();
			}

			listView = new ItemListView(itemTotalCnt, currentPageNumber, itemList, ITEM_CNT_PER_PAGE, startRow);

			System.out.println("▶ listView : " + listView);
			return listView;
		}
		
		
		
		public SellListView getSellList(HttpServletRequest request) {

			dao = sTemplate.getMapper(ItemDao.class);

			Map<String, Object> search = new HashMap<String, Object>();

			String istate = (request.getParameter("istate"));
			String count = request.getParameter("count");
			String midx = request.getParameter("midx");

			search.put("istate", istate);
			search.put("midx", midx);

			// view 로 전달할 결과 데이터
			SellListView sellView = null;

			// 전체 게시물 개수 구하기
			int sellTotalCnt = dao.totalSellCount(search);
			System.out.println("sell totalCnt ▶" + sellTotalCnt);

			// 한 페이지 당 노출할 게시물의 개수
			int ITEM_CNT_PER_PAGE = 10;
			if (count != null) {
				try {
					ITEM_CNT_PER_PAGE = Integer.parseInt(count);// 어느 단에서 받을 건지..?
				} catch (NumberFormatException e) {
					System.out.println("숫자 타입의 문자열이 전달되지 않아 예외 발생");
				}
			}

			// 현재 페이지 번호
			int currentPageNumber = 1;
			String page = request.getParameter("page");
			String rpage = request.getParameter("rpage");
			System.out.println("▶ sell page : " + page);
			System.out.println("▶  count : " + count);
			System.out.println("▶sell midx : " + midx);
			System.out.println("▶sell istate : " + istate);

			if (page != null) {
				try {
					currentPageNumber = Integer.parseInt(page);
				} catch (NumberFormatException e) {
					System.out.println("숫자 타입의 문자열이 전달되지 않아 예외 발생");
				}
			}
			if (rpage != null) {
				try {
					currentPageNumber = Integer.parseInt(rpage);
				} catch (NumberFormatException e) {
					System.out.println("숫자 타입의 문자열이 전달되지 않아 예외 발생");
				}
			}

			// 게시물의 첫번째 행의 index
			int startRow = 0;

			// 한 페이지 당 노출할 리스트
			List<MySell> sellList = null;

			if (sellTotalCnt > 0) {
				startRow = (currentPageNumber - 1) * ITEM_CNT_PER_PAGE;

				System.out.println("startRow ▶" + startRow);
				search.put("startRow", startRow);
				search.put("count", ITEM_CNT_PER_PAGE);

				sellList = dao.selectSellList(search);
				System.out.println("sellList ▶" + sellList);
				System.out.println("sellList size ▶" + sellList.size());

			} else {
				currentPageNumber = 0;
				sellList = Collections.emptyList();
			}

			sellView = new SellListView(sellTotalCnt, currentPageNumber, sellList, ITEM_CNT_PER_PAGE, startRow);

			System.out.println("▶ SellListView : " + sellView);

			return sellView;

		}
		
	
}
