package com.wifi.comment.model;

public class CommentEditRequest {

	private int cidx;
	private String content;
	
	
	public CommentEditRequest() {
	}


	public CommentEditRequest(int cidx, String content) {
		super();
		this.cidx = cidx;
		this.content = content;
	}


	public int getCidx() {
		return cidx;
	}


	public void setCidx(int cidx) {
		this.cidx = cidx;
	}


	public String getContent() {
		return content;
	}


	public void setContent(String content) {
		this.content = content;
	}

	
	public Comment toComment() {
		return new Comment(cidx, null, null, content, 0 , 0, null, 0);
	}
	

	@Override
	public String toString() {
		return "CommentEditRequest [cidx=" + cidx + ", content=" + content + "]";
	}
	
	
	
}
