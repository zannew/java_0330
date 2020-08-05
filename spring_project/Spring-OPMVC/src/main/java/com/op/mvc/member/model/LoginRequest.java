package com.op.mvc.member.model;

public class LoginRequest {

	//커맨드객체
	//변수명과 입력 파라미터 이름과 일치해야함
	private String uid;
	private String upw;
	//0805
	private String redirecUri;
	private String remember;
	
	
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
	
	
	public String getRedirecUri() {
		return redirecUri;
	}
	public void setRedirecUri(String redirecUri) {
		this.redirecUri = redirecUri;
	}
	public String getRemember() {
		return remember;
	}
	public void setRemember(String remember) {
		this.remember = remember;
	}
	@Override
	public String toString() {
		return "LoginRequest [uid=" + uid + ", upw=" + upw + "]";
	}
	
	
	
}