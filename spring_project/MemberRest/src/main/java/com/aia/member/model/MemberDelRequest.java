package com.aia.member.model;

import org.springframework.web.multipart.MultipartFile;


// Http요청 파라미터를 저장한 객체 
// 입력 파라미터와 변수명 일치시켜야...
public class MemberDelRequest {

	private int idx;
	private String uid;
	private String upw;
	private String uname;
	private MultipartFile photo;
	
	
	
	public int getIdx() {
		return idx;
	}
	public void setIdx(int idx) {
		this.idx = idx;
	}
	public String getUid() {
		return uid;
	}
	public void setUid(String uid) {
		this.uid = uid;
	}
	public String getUpw() {
		return upw;
	}
	public void setUpw(String upw) {
		this.upw = upw;
	}
	public String getUname() {
		return uname;
	}
	public void setUname(String uname) {
		this.uname = uname;
	}
	public MultipartFile getPhoto() {
		return photo;
	}
	public void setPhoto(MultipartFile photo) {
		this.photo = photo;
	}
	
	
	// MemberRegRequest를 Member객체로 변환하는 메서드
	public Member toMember() {
		
		return new Member(uid, upw, uname);
	}
	
	
	@Override
	public String toString() {
		return "MemberRegRequest [uid=" + uid + ", upw=" + upw + ", uname=" + uname + ", photo=" + photo + "]";
	}
	
	
	
	
}
