package com.wifi.sell.model;

import java.sql.Date;


public class ItemDeleteRequest {

	// [공구 글 삭제] 물리적 삭제가 아닌 상태값 변경으로 진행
	private int iIdx;
	private String title;
	private int price;
	private int countM;
	private int countW;
	private Date regDate;
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
	
	// getter & setter
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
	public Date getRegDate() {
		return regDate;
	}
	public void setRegDate(Date regDate) {
		this.regDate = regDate;
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
	
	// toItem();
	public Item toItem() {
		return new Item(iIdx, title, price, countM, countW, regDate, receive, addr, location, content, photo, state, viewCount, category, midx);
	}
	
	
	@Override
	public String toString() {
		return "ItemDeleteRequest [iIdx=" + iIdx + ", title=" + title + ", price=" + price + ", countM=" + countM
				+ ", countW=" + countW + ", regDate=" + regDate + ", receive=" + receive + ", addr=" + addr
				+ ", location=" + location + ", content=" + content + ", photo=" + photo + ", state=" + state
				+ ", viewCount=" + viewCount + ", category=" + category + ", midx=" + midx + "]";
	}
	
	
	
}
