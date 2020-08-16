package com.wifi.sell.dao;

import java.util.List;
import java.util.Map;

import com.wifi.sell.model.Item;
import com.wifi.sell.model.ItemListView;

public interface ItemDao {

	// public 생략
	// 공구 리스트 전체 출력 
	List<Item> selectList();
	
	// 공구 상세보기 - iIdx로
	Item selectByIidx(int iIdx);
	
	// 공구 검색된 리스트 출력
	List<Item> selectListByKeyword(String searchType, String keyword);

	// 공구 등록
	int insertItem(Item item);

	// 공구 삭제 (= state값 변경)
	int deleteItem(int iIdx);

	// 전체 게시물의 개수 : 검색 포함
	int totalCount(Map search);

	
}
