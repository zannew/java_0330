package com.aia.mvc.search.model;

public class SearchType {

	
	// [ 1. 제목, 2. 내용, 3. 제목+내용 ]으로 검색
	private int tno;
	private String type;
	
	//default constructor
	public SearchType() {
		super();
	}
	
	//constructor
	public SearchType(int tno, String type) {
		super();
		this.tno = tno;
		this.type = type;
	}


	public int getTno() {
		return tno;
	}
	public void setTno(int tno) {
		this.tno = tno;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	
	@Override
	public String toString() {
		return "SearchType [tno=" + tno + ", type=" + type + "]";
	}
	
	
	
	
}