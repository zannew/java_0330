package com.wifi.comment.model;

import java.util.List;

public class CommentListView {

	private int commentTotalCount;
	private int cureentPageNumber;
	private List<Comment> commentList;
	private int pageTotalCount;
	private int commentCountPerPage;
	private int startRow;
	
	
	
	// 생성자 ( pageTotalCount는 함수호출 )
	public CommentListView(int commentTotalCount, int cureentPageNumber, List<Comment> commentList,
			int commentCountPerPage, int startRow) {
		super();
		this.commentTotalCount = commentTotalCount;
		this.cureentPageNumber = cureentPageNumber;
		this.commentList = commentList;
		this.commentCountPerPage = commentCountPerPage;
		this.startRow = startRow;
		calcPageTotalCount();
	}
	

	public void calcPageTotalCount() {
		if(commentTotalCount == 0) {
			pageTotalCount = 0;
		} else {
			pageTotalCount = commentTotalCount / commentCountPerPage;
			System.out.println("코멘트 토탈 % 코멘트퍼페이지의 나머지 : " + commentTotalCount % commentCountPerPage);
			if(commentTotalCount % commentCountPerPage > 0) {
				pageTotalCount++;
			}
				System.out.println("페이지토탈카운트 : " + pageTotalCount);		
			}
	}

	// only getter
	public int getCommentTotalCount() {
		return commentTotalCount;
	}


	public int getCureentPageNumber() {
		return cureentPageNumber;
	}


	public List<Comment> getCommentList() {
		return commentList;
	}


	public int getPageTotalCount() {
		return pageTotalCount;
	}


	public int getCommentCountPerPage() {
		return commentCountPerPage;
	}


	public int getStartRow() {
		return startRow;
	}


	@Override
	public String toString() {
		return "CommentListView [commentTotalCount=" + commentTotalCount + ", cureentPageNumber=" + cureentPageNumber
				+ ", commentList=" + commentList + ", pageTotalCount=" + pageTotalCount + ", commentCountPerPage="
				+ commentCountPerPage + ", startRow=" + startRow + "]";
	} 
	
	
	
}
