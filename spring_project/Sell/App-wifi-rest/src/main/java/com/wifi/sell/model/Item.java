package com.wifi.sell.model;

import java.sql.Date;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

public class Item {

	private int iIdx;
	private String title;
	private int price;
	private int countM;
	private int countW;
	@JsonFormat(pattern = "YYYY-MM-DD HH:mm:ss", timezone = "Asia/Seoul")
	private Date regDate;
	@JsonFormat(pattern = "YYYY-MM-DD HH:mm:ss", timezone = "Asia/Seoul")
	private Date receive;
	private String addr;
	private String location;
	private String content;
	private String photo;
	//거래중/거래완료/게시기간만료/수령대기중?/추천공구 / 일반공구 - 통합 상태값
	private int state;
	private int viewCount;
	private int category;
	private int midx;

	// 디폴트 생성자
	public Item() {
	}

	// ItemRegRequest에서 객체로 변환하기 위한 생성자(iIdx, regdate없음)
	public Item(String title, int price, int countM, int countW, Date receive, String addr, String location,
			String content, int state, int viewCount, int category, int midx) {
		this(0, title, price, countM, countW, null, receive, addr, 
				location, content, null, state, viewCount, category, midx);
	}
		
		
	public Item(int iIdx, String title, int price, int countM, int countW, Date regDate, Date receive, String addr,
			String location, String content, String photo, int state, int viewCount, int category, int midx) {
		this.iIdx = iIdx;
		this.title = title;
		this.price = price;
		this.countM = countM;
		this.countW = countW;
		this.regDate = regDate;
		this.receive = receive;
		this.addr = addr;
		this.location = location;
		this.content = content;
		this.photo = photo;
		this.state = state;
		this.viewCount = viewCount;
		this.category = category;
		this.midx = midx;
	}

	
	

	public int getiIdx() {
		return iIdx;
	}


	public void setiIdx(int iIdx) {
		this.iIdx = iIdx;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getCountM() {
		return countM;
	}

	public void setCountM(int countM) {
		this.countM = countM;
	}

	public int getCountW() {
		return countW;
	}

	public void setCountW(int countW) {
		this.countW = countW;
	}
	
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "Asia/Seoul")
	public Date getRegDate() {
		return regDate;
	}

	public void setRegDate(Date regDate) {
		this.regDate = regDate;
	}

	public Date getReceive() {
		return receive;
	}

	//@DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")
	@JsonFormat(pattern = "YYYY-MM-DD HH:mm:ss", timezone = "Asia/Seoul")
	public void setReceive(Date receive) {
		this.receive = receive;
	}
	
	// java.sql.Date → java.util.Date 변환	
	//@DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")
	@JsonFormat(pattern = "YYYY-MM-DD HH:mm:ss", timezone = "Asia/Seoul")
	public java.util.Date getToDate(){		//${member.toDate}
		return new java.util.Date(receive.getTime());	// getTime() : 기준 날짜이후 밀리세컨단위 long타입으로 리턴
	}

	public String getAddr() {
		return addr;
	}

	public void setAddr(String addr) {
		this.addr = addr;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getPhoto() {
		return photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}

	public int getState() {
		return state;
	}

	public void setState(int state) {
		this.state = state;
	}

	public int getViewCount() {
		return viewCount;
	}

	public void setViewCount(int viewCount) {
		this.viewCount = viewCount;
	}


	public int getCategory() {
		return category;
	}

	public void setCategory(int category) {
		this.category = category;
	}

	public int getMidx() {
		return midx;
	}

	public void setMidx(int midx) {
		this.midx = midx;
	}

	

	@Override
	public String toString() {
		return "Item [iIdx=" + iIdx + ", title=" + title + ", price=" + price + ", countM=" + countM + ", countW="
				+ countW + ", regDate=" + regDate + ", receive=" + receive + ", addr=" + addr + ", location=" + location
				+ ", content=" + content + ", photo=" + photo + ", state=" + state + ", viewCount=" + viewCount
				+ ", category=" + category + ", midx=" + midx + "]";
	}

	
	
	
	
}
