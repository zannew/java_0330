package com.op.mvc.member.model;

//sql로 받음 : DB에서 받아옴
import java.sql.Date;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;
// xml타입을 위한 bean생성
// 멤버를 반환해주는 클래스 별도로 필요 - MemberXmlList.java
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name="", propOrder= {"idx", "uid", "upw", "uname","uphoto","regdate"})
public class MemberXML {
	
	private int idx;
	private String uid;
	private String upw;
	private String uname;
	private String uphoto;
	private Date regdate;
	
	//default constructor
	public MemberXML() {}
	
	// MemberRegRequest를 Member객체로 받아오기 위한 contructor
	public MemberXML(String uid, String upw, String uname) {
		this(0, uid, upw, uname, null, null);
	}
	
	//constructor
	public MemberXML(int idx, String uid, String upw, String uname, String uphoto, Date regdate) {
		super();
		this.idx = idx;
		this.uid = uid;
		this.upw = upw;
		this.uname = uname;
		this.uphoto = uphoto;
		this.regdate = regdate;
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

	public void setRegdate(Date regdate) {
		this.regdate = regdate;
	}
	
	// java.sql.Date → java.util.Date 변환	
	public java.util.Date getToDate(){		//${member.toDate}
		return new java.util.Date(regdate.getTime());	// getTime() : 기준 날짜이후 밀리세컨단위 long타입으로 리턴
	}

	@Override
	public String toString() {
		return "Member [idx=" + idx + ", uid=" + uid + ", upw=" + upw + ", uname=" + uname + ", uphoto=" + uphoto
				+ ", regdate=" + regdate + "]";
	}
		
	
}
