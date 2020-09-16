package com.wifi.order.model;

import java.sql.Timestamp;

import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.annotation.JsonFormat;

// 공구글 정보 : view에서 db로 등록할 때 DTO
public class ItemRegRequest {
	
	// private int iidx;				// 게시물 번호 -PK
	private String title;			// 게시글 제목
	private int price;				// 가격
	private int count_m;			// 모집 인원
	private int count_w;			// 대기 정원
	// private Timestamp regdate;		// 게시글 등록일시(현재시간)
	@JsonFormat(pattern = "YYYY-MM-DD HH:mm:ss", timezone = "Asia/Seoul")
	private Timestamp receive;		// 물품수령일시
	private String addr;			// 판매처
	private String location;		// 좌표
	private String content;			// 게시글 본문
	private MultipartFile photo;	// 첨부사진
	private int state;				// 게시글 현황
	private int view_count;			// 조회수
	private int category;			// 판매물품 카테고리 : 0 과일, 1 육류, 2 해산물, 3 채소, 4 생필품, 5 음료, 6 전체
	private int midx;				// 작성자(회원번호) - FK
	
	
	
	public ItemRegRequest() {
	}



	public ItemRegRequest(String title, int price, int count_m, int count_w, Timestamp receive, String addr,
			String location, String content, MultipartFile photo, int state, int category, int midx) {
		this.title = title;
		this.price = price;
		this.count_m = count_m;
		this.count_w = count_w;
		this.receive = receive;
		this.addr = addr;
		this.location = location;
		this.content = content;
		this.photo = photo;
		this.state = state;
		this.view_count = 0;
		this.category = category;
		this.midx = midx;
	}

	

	// ItemRequest ㅡ> Item
	// ItemRegRequest에서 객체로 변환하기 위한 생성자(iidx, regdate없음)
	// iidx=0, regdate=null, photo=null 
	public Item toItem() {
		return new Item(0, title, price, count_m, count_w, null, receive, addr, 
				location, content, null, state, view_count, category, midx);
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


	@JsonFormat(pattern = "YYYY-MM-DD HH:mm:ss", timezone = "Asia/Seoul")
	public Timestamp getReceive() {
		return receive;
	}


	@JsonFormat(pattern = "YYYY-MM-DD HH:mm:ss", timezone = "Asia/Seoul")
	public void setReceive(Timestamp receive) {
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



	@Override
	public String toString() {
		return "ItemRequest [title=" + title + 
				"    	   , price=" + price + 
				"  		   , count_m=" + count_m + 
				"		   , count_w=" + count_w+ 
				"          , receive=" + receive + 
				"          , addr=" + addr + 
				"          , location=" + location + 
				"          , content=" + content+ 
				"          , photo=" + photo + 
				"          , state=" + state + 
				"          , view_count=" + view_count + 
				"          , category=" + category+ 
				"          , midx=" + midx + "]";
	}
	
	
	
	
	
		
	
	
	
	
	
}
