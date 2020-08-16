package com.wifi.sell.model;

public class Member {

	private int mIdx;
	private String id;
	private String name;
	private String addr;
	private String phone;
	private int type;	//회원,탈퇴,관리자,강퇴

	// 디폴트 생성자
	public Member() {
		super();
	}

	public Member(int mIdx, String id, String name, String addr, String phone, int type) {
		super();
		this.mIdx = mIdx;
		this.id = id;
		this.name = name;
		this.addr = addr;
		this.phone = phone;
		this.type = type;
	}

	public int getmIdx() {
		return mIdx;
	}

	public void setmIdx(int mIdx) {
		this.mIdx = mIdx;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}


	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddr() {
		return addr;
	}

	public void setAddr(String addr) {
		this.addr = addr;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}


	@Override
	public String toString() {
		return "Member [mIdx=" + mIdx + ", id=" + id + ", name=" + name + ", addr=" + addr + ", phone="
				+ phone + ", type=" + type + "]";
	}
	
	
	
	
	
}
