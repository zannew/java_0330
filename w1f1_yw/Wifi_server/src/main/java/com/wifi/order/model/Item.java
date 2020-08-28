package com.wifi.order.model;

import java.sql.Timestamp;

import com.fasterxml.jackson.annotation.JsonFormat;

public class Item {

	private int iidx;
	private String title;
	private int price;
	private int count_m;
	private int count_w;
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "Asia/Seoul")
	private Timestamp regdate;
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "Asia/Seoul")
	private Timestamp receive;
	private String addr;
	private String location;
	private String content;
	private String photo;
	//거래중/거래완료/게시기간만료/수령대기중?/추천공구 / 일반공구 - 통합 상태값
	private int state;
	private int view_count;
	private int category;
	private int midx;

	// 디폴트 생성자
	public Item() {
	}

	// ItemRegRequest에서 객체로 변환하기 위한 생성자(iIdx, regdate없음)

	public Item(String title, int price, int count_m, int count_w, Timestamp receive, String addr, String location,
			String content, int state, int view_count, int category, int midx) {
		this(0, title, price, count_m, count_w, null, receive, addr, 
				location, content, null, state, view_count, category, midx);
	}


	public Item(int iidx, String title, int price, int count_m, int count_w, Timestamp regdate, Timestamp receive,
			String addr, String location, String content, String photo, int state, int view_count, int category,
			int midx) {
		super();
		this.iidx = iidx;
		this.title = title;
		this.price = price;
		this.count_m = count_m;
		this.count_w = count_w;
		this.regdate = regdate;
		this.receive = receive;
		this.addr = addr;
		this.location = location;
		this.content = content;
		this.photo = photo;
		this.state = state;
		this.view_count = view_count;
		this.category = category;
		this.midx = midx;
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
	

	public int getIidx() {
		return iidx;
	}

	public void setIidx(int iidx) {
		this.iidx = iidx;
	}

	public int getCount_m() {
		return count_m;
	}

	public void setCount_m(int count_m) {
		this.count_m = count_m;
	}

	public int getCount_w() {
		return count_w;
	}

	public void setCount_w(int count_w) {
		this.count_w = count_w;
	}

	public int getView_count() {
		return view_count;
	}

	public void setView_count(int view_count) {
		this.view_count = view_count;
	}

	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "Asia/Seoul")
	public Timestamp getRegdate() {
		return regdate;
	}

	public void setRegdate(Timestamp regdate) {
		this.regdate = regdate;
	}

	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "Asia/Seoul")
	public Timestamp getReceive() {

		return receive;
	}

	//@DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "Asia/Seoul")
	public void setReceive(Timestamp receive) {

		this.receive = receive;
	}
	
//	// java.sql.Date → java.util.Date 변환	
//	//@DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")
//	@JsonFormat(pattern = "yyyy-MM-DD HH:mm:ss", timezone = "Asia/Seoul")
//	public java.util.time getToDate(){		//${member.toDate}
//		return new java.util.Ti(receive.getTime());	// getTime() : 기준 날짜이후 밀리세컨단위 long타입으로 리턴
//	}


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
		return "Item [iidx=" + iidx + ", title=" + title + ", price=" + price + ", count_m=" + count_m + ", count_w="
				+ count_w + ", regdate=" + regdate + ", receive=" + receive + ", addr=" + addr + ", location="
				+ location + ", content=" + content + ", photo=" + photo + ", state=" + state + ", view_count="
				+ view_count + ", category=" + category + ", midx=" + midx + "]";
	}


	
	
	
	
}
