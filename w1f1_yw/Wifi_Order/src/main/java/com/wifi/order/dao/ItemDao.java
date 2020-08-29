package com.wifi.order.dao;

import java.util.List;
import java.util.Map;

import com.wifi.order.model.Item;
import com.wifi.order.model.MyItem;
import com.wifi.order.model.MySell;
import com.wifi.order.model.Rvs;
import com.wifi.order.model.RvsView;

public interface ItemDao {

	// public 생략
	// 공구 리스트 전체 출력 
	List<MyItem> selectList(Map<String, Object> search);
	List<MyItem> selectRList(Map<String, Object> search);
	List<MySell> selectSellList(Map<String, Object> search);

	
	// 공구 상세보기 - iIdx로
	Item selectByIidx(int iidx);
	void increaseViewCount(int iidx);

	
	// 게시자의 midx
	int selectMidx(int iidx);
	
	// 공구 검색된 리스트 출력
	List<Item> selectListByKeyword(String searchType, String keyword);

	// 공구 등록
	int insertItem(Item item);

	// 공구 삭제 (= state값 변경)
	int deleteItem(int iidx);

	// 전체 게시물의 개수 : 검색 포함
	int totalCount(Map<String, Object> search);
	// 내 판매현황 : 게시물 수
	int totalSellCount(Map<String, Object> search);
	
	//midx로 평점 가져오기
	Rvs selectRvs(Map<String, Object> search);

}
