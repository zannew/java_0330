package com.wifi.comment.model;

public class CommentRegRequest {

	// 댓글 내용
	private String content;
	// 댓글 작성사 midx
	private int midx;
	// 댓글작성자 이름 (추가)
	private String name;
	// 해당 공구글 iidx
	private int iidx;
	
	
	// 디폴트
	public CommentRegRequest() {}

	public CommentRegRequest(String content, int midx, String name, int iidx) {
		super();
		this.content = content;
		this.midx = midx;
		this.name = name;
		this.iidx = iidx;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
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
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Comment toComment() {
		return new Comment(0, null, null, content, 0, midx, name, iidx);
	}

	@Override
	public String toString() {
		return "CommentRegRequest [content=" + content + ", midx=" + midx + ", iidx=" + iidx + ", name=" + name + "]";
	}

}
