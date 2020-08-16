package com.wifi.sell.model;

import java.sql.Date;

import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.annotation.JsonFormat;

public class ItemRegRequest {

	// iIdx와 regDate 뻄 → default값으로 auto-create
	private String title;
	private int price;
	private int countM;
	private int countW;
	@JsonFormat(pattern = "YYYY-MM-DD HH:mm:ss", timezone = "Asia/Seoul")
	private Date receive;
	private String addr;
	private String location;
	private String content;
	private MultipartFile photo;
	//거래중/거래완료/게시기간만료/수령대기중?/추천공구 / 일반공구 - 통합 상태값
	private int state;
	private int viewCount;
	private int category;
	private int midx;
	
	public ItemRegRequest() {
	}

	public ItemRegRequest(String title, int price, int countM, int countW, Date receive, String addr, String location,
			String content, MultipartFile photo, int state, int viewCount, int category, int midx) {
		this.title = title;
		this.price = price;
		this.countM = countM;
		this.countW = countW;
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

	public Date getReceive() {
		return receive;
	}

	public void setReceive(Date receive) {
		this.receive = receive;
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
	
	
	public Item toItem() {
		return new Item(0, title, price, countM, countW, null, receive, addr, 
				location, content, null, state, viewCount, category, midx);
	}

	@Override
	public String toString() {
		return "ItemRegRequest [title=" + title + ", price=" + price + ", countM=" + countM + ", countW=" + countW
				+ ", receive=" + receive + ", addr=" + addr + ", location=" + location + ", content=" + content
				+ ", photo=" + photo + ", state=" + state + ", viewCount=" + viewCount + ", category=" + category
				+ ", midx=" + midx + "]";
	}
	
	
	
	
}
