package com.wifi.order.model;

import java.sql.Timestamp;

import com.fasterxml.jackson.annotation.JsonFormat;

public class MyItem {

	private int midx;		//o.midx
	private int iidx;
	private int oidx;
	private int pidx;
	private String title;
	private int price;
	private int count_m;
	private int count_w;
	@JsonFormat(pattern = "YYYY-MM-DD HH:mm:ss", timezone = "Asia/Seoul")
	private Timestamp regdate;
	@JsonFormat(pattern = "YYYY-MM-DD HH:mm:ss", timezone = "Asia/Seoul")
	private Timestamp receive;
	private String addr;
	private String location;
	private String content;
	private String photo;
	//거래중/거래완료/게시기간만료/수령대기중?/추천공구 / 일반공구 - 통합 상태값
	private int view_count;
	private int category;
	private int score_s;
	private String name;
	private int istate;
	private int ostate;
	private int pstate;
	
	
	// 디폴트 생성자
	public MyItem() {}








	public MyItem(int midx, int iidx, int oidx, int pidx, String title, int price, int count_m, int count_w,
			Timestamp regdate, Timestamp receive, String addr, String location, String content, String photo,
			int view_count, int category, int score_s, String name, int istate, int ostate, int pstate) {
		super();
		this.midx = midx;
		this.iidx = iidx;
		this.oidx = oidx;
		this.pidx = pidx;
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
		this.view_count = view_count;
		this.category = category;
		this.score_s = score_s;
		this.name = name;
		this.istate = istate;
		this.ostate = ostate;
		this.pstate = pstate;
	}








	public int getMidx() {
		return midx;
	}


	public void setMidx(int midx) {
		this.midx = midx;
	}


	public int getIidx() {
		return iidx;
	}


	public void setIidx(int iidx) {
		this.iidx = iidx;
	}


	public int getOidx() {
		return oidx;
	}


	public void setOidx(int oidx) {
		this.oidx = oidx;
	}


	public int getPidx() {
		return pidx;
	}


	public void setPidx(int pidx) {
		this.pidx = pidx;
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


	public Timestamp getRegdate() {
		return regdate;
	}


	public void setRegdate(Timestamp regdate) {
		this.regdate = regdate;
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


	public int getIstate() {
		return istate;
	}


	public void setIstate(int istate) {
		this.istate = istate;
	}


	public int getOstate() {
		return ostate;
	}


	public void setOstate(int ostate) {
		this.ostate = ostate;
	}


	public int getPstate() {
		return pstate;
	}


	public void setPstate(int pstate) {
		this.pstate = pstate;
	}

	
	
	public int getScore_s() {
		return score_s;
	}


	public void setScore_s(int score_s) {
		this.score_s = score_s;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}





	@Override
	public String toString() {
		return "MyItem [midx=" + midx + ", iidx=" + iidx + ", oidx=" + oidx + ", pidx=" + pidx + ", title=" + title
				+ ", price=" + price + ", count_m=" + count_m + ", count_w=" + count_w + ", regdate=" + regdate
				+ ", receive=" + receive + ", addr=" + addr + ", location=" + location + ", content=" + content
				+ ", photo=" + photo + ", view_count=" + view_count + ", category=" + category + ", score_s=" + score_s
				+ ", name=" + name + ", istate=" + istate + ", ostate=" + ostate + ", pstate=" + pstate + "]";
	}






	
	
}
