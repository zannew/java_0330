package com.op.opmvc.member.model;

import org.springframework.web.multipart.MultipartFile;

public class RegRequest {
	
	//커맨드 객체
	//변수명과 입력 파라미터명 일치시키기
	private String uid;
	private String upw;
	private String uname;
	private MultipartFile uphoto;
	
	
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
	public MultipartFile getUphoto() {
		return uphoto;
	}
	public void setUphoto(MultipartFile uphoto) {
		this.uphoto = uphoto;
	}
	
	
	@Override
	public String toString() {
		return "RegRequest [uid=" + uid + ", upw=" + upw + ", uname=" + uname + ", uphoto=" + uphoto + "]";
	}
	
	
	
	

}
