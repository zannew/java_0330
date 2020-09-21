package com.wifi.order.dao;

import java.util.List;

import com.wifi.order.model.Alarm;

public interface AlarmDao {

	// 내가 등록한 공구글 가져오기
	List<Alarm> getMyItem(int midx);
	
	// 내가 등록한 공구글 가져오기
	List<Alarm> getMyOrder(int midx);
	
	// 판매현황쪽 알람 끄기 : 상태값 0으로 변경
	int cancleSellerAlarm(int midx, int iidx);
	
	// 구매현황쪽 알람 끄기 : 상태값 0으로 변경
	int cancleBuyerAlarm(int midx, int iidx);
	
	// 판매현황쪽 알람 행생성
	void insertSellerAlarm(int midx, int iidx);
	
	// 구매현황쪽 알람 행생성
	void insertBuyerAlarm(int midx, int iidx);

	// 판매현황쪽 알람 행삭제
	void deleteSellerAlarm(int iidx);
	
	// 구매현황쪽 알람 행생성
	void deleteBuyerAlarm(int midx, int iidx);
}
