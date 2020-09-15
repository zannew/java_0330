package com.wifi.order.model;

import java.sql.Timestamp;


import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.annotation.JsonFormat;

public class ItemRegRequest {

	// iIdx와 regDate 뻄 → default값으로 auto-create
	private String title;
	private int price;
	private int count_m;
	private int count_w;
	@JsonFormat(pattern = "YYYY-MM-DD HH:mm:ss", timezone = "Asia/Seoul")
	private Timestamp receive;
	private String addr;
	private String location_y;
	private String location_x;
	private String content;
	private MultipartFile photo;
	//거래중/거래완료/게시기간만료/수령대기중?/추천공구 / 일반공구 - 통합 상태값
	private int state;
	private int view_count;
	private int category;
	private int midx;
	
	public ItemRegRequest() {
	}

	public ItemRegRequest(String title, int price, int count_m, int count_w, Timestamp receive, String addr,
			String location_y, String location_x, String content, MultipartFile photo, int state, int view_count,
			int category, int midx) {
		super();
		this.title = title;
		this.price = price;
		this.count_m = count_m;
		this.count_w = count_w;
		this.receive = receive;
		this.addr = addr;
		this.location_y = location_y;
		this.location_x = location_x;
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

	public Timestamp getReceive() {
		return receive;
	}

	public void setReceive(Timestamp receive) {
		this.receive = receive;
	}

	public String getAddr() {
		return addr;
	}

	public void setAddr(String addr) {
		this.addr = addr;
	}

	public String getLocation_y() {
		return location_y;
	}

	public void setLocation_y(String location_y) {
		this.location_y = location_y;
	}

	public String getLocation_x() {
		return location_x;
	}

	public void setLocation_x(String location_x) {
		this.location_x = location_x;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public MultipartFile getPhoto() {
		return photo;
	}

	public void setPhoto(MultipartFile photo) {
		this.photo = photo;
	}

	public int getState() {
		return state;
	}

	public void setState(int state) {
		this.state = state;
	}

	public int getView_count() {
		return view_count;
	}

	public void setView_count(int view_count) {
		this.view_count = view_count;
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

	public Item toItem() {
		return new Item(0, title, price, count_m, count_w, null, receive, addr, 
				location_y, location_x, content, null, state, view_count, category, midx);
	}

	
}
