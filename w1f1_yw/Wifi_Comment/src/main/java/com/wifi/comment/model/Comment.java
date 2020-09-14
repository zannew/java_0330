package com.wifi.comment.model;

import java.sql.Timestamp;

import com.fasterxml.jackson.annotation.JsonFormat;

public class Comment {

	// 댓글 번호
	private int cidx;
	// 작성시간
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "Asia/Seoul")
	private Timestamp regdate;
	// 수정시간
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "Asia/Seoul")
	private Timestamp updated;
	// 내용
	private String content;
	// 댓글 상태 ( 0 : 게시중 / 1: 삭제된 댓글 )
	private int state;
	// 작성자 번호
	private int midx;
	// 작성자 이름
	private String name;
	// 공구 번호
	private int iidx;
	
	
	// 디폴트 생성자
	public Comment () {}

	// CommentRegRequest에서 객체로 변환하기 위한 생성자(cidx, regdate, updated없음)
	public Comment(String content, int midx, String name, int iidx) {
		this(0, null, null, content, 0 , midx, name, iidx);
	}
	// CommentEditRequest에서 객체로 변환하기 위한 생성자(cidx, regdate, updated없음)
	public Comment(int cidx, String content) {
		this(cidx, null, null, content, 0 , 0, null, 0);
	}


	public Comment(int cidx, Timestamp regdate, Timestamp updated, String content, int state, int midx, String name,
			int iidx) {
		super();
		this.cidx = cidx;
		this.regdate = regdate;
		this.updated = updated;
		this.content = content;
		this.state = state;
		this.midx = midx;
		this.name = name;
		this.iidx = iidx;
	}

	public int getCidx() {
		return cidx;
	}

	public void setCidx(int cidx) {
		this.cidx = cidx;
	}

	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "Asia/Seoul")
	public Timestamp getRegdate() {
		return regdate;
	}
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "Asia/Seoul")
	public void setRegdate(Timestamp regdate) {
		this.regdate = regdate;
	}

	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "Asia/Seoul")
	public Timestamp getUpdated() {
		return updated;
	}
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "Asia/Seoul")
	public void setUpdated(Timestamp updated) {
		this.updated = updated;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public int getState() {
		return state;
	}

	public void setState(int state) {
		this.state = state;
	}

	public int getMidx() {
		return midx;
	}

	public void setMidx(int midx) {
		this.midx = midx;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getIidx() {
		return iidx;
	}

	public void setIidx(int iidx) {
		this.iidx = iidx;
	}

	@Override
	public String toString() {
		return "Comment [cidx=" + cidx + ", regdate=" + regdate + ", updated=" + updated + ", content=" + content
				+ ", state=" + state + ", midx=" + midx + ", name=" + name + ", iidx=" + iidx + "]";
	}
	
	
	


	
	
}
