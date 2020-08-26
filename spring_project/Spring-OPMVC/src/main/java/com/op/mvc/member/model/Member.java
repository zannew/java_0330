package com.op.mvc.member.model;

//sql로 받음 : DB에서 받아옴
import java.sql.Date;
import java.util.Random;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

public class Member {
	
	private int idx;
	private String uid;
	@JsonIgnore
	private String upw;
	private String uname;
	private String uphoto;
	@JsonFormat(pattern = "yyyy-MM-dd hh:mm:ss", timezone = "Asia/Seoul")
	private Date regdate;
	//이메일 인증코드
	private String code;
	//이메일인증여부 확인
	private char verify;
	
	//default constructor
	public Member() {
		// 2020.08.11 추가
		getRandomSting();
	}
	// MemberRegRequest를 Member객체로 받아오기 위한 contructor
	public Member(String uid, String upw, String uname) {
		this(0, uid, upw, uname, null, null, null);
	}
	
	//constructor
	public Member(int idx, String uid, String upw, String uname, String uphoto, Date regdate) {
		this.idx = idx;
		this.uid = uid;
		this.upw = upw;
		this.uname = uname;
		this.uphoto = uphoto;
		this.regdate = regdate;
		// 2020.08.11 추가
		getRandomSting();
	}
	//constructor
	public Member(int idx, String uid, String upw, String uname, String uphoto, String code, Date regdate) {
		this.idx = idx;
		this.uid = uid;
		this.upw = upw;
		this.uname = uname;
		this.uphoto = uphoto;
		this.code = code;
		this.regdate = regdate;
		// 2020.08.11 추가
		getRandomSting();
	}
	

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

	public String getUphoto() {
		return uphoto;
	}

	public void setUphoto(String uphoto) {
		this.uphoto = uphoto;
	}

	public Date getRegdate() {
		return regdate;
	}

	
	// java.sql.Date → java.util.Date 변환	
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "Asia/Seoul")
	public void setRegdate(Date regdate) {
		this.regdate = regdate;
	}

	// java.sql.Date -> java.util.Date
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "Asia/Seoul")
	public java.util.Date getToDate() {// ${member.toDate}
		return new java.util.Date(regdate.getTime());
	}

	// Member -> LoginInfo : 로그인 처리시 저장할 데이터
	public LoginInfo toLoginInfo() {
		return new LoginInfo(uid, uname, uphoto);
	}
		
	
	// 2020.08.11 추가
	public char getVerify() {
		return verify;
	}	
	// 2020.08.11 추가
	public void setVerify(char verify) {
		this.verify = verify;
	}
	// 2020.08.11 추가
	public String getCode() {
		return code;
	}
	// 2020.08.11 추가
	public void setCode(String code) {
		this.code = code;
	}

	// 2020.08.11 추가
	// 영문 + 숫자 난수 발생
	private void getRandomSting() {
		
		Random r = new Random(System.nanoTime());
		// 문자열 계속 쌓아갈 때
		StringBuffer sb = new StringBuffer();
		
		for(int i=0 ; i<20 ; i++ ) {
			if(r.nextBoolean()) {
				sb.append(r.nextInt(10));
			} else {
				sb.append((char)(r.nextInt(26)+97));
			}
		}
		
		System.out.println("난수 코드 생성 : " + sb) ;
		
		setCode(sb.toString());
		
		//return  sb.toString();		
	}
	
	
}
