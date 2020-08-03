package com.op.mvc.member.model;

import java.util.List;

public class MemberListView {

	private MemberListView() {}
	
	private static MemberListView memberListView  = new MemberListView();
	public static MemberListView getInstance() {
		return memberListView;
	}
	
	
	//전체 회원 수
	private int memberTotalCount;
	//현재 페이지번호
	private int currentPageNumber;
	//멤버 리스트
	private List<Member> memberList;
	//전체 페이지 개수
	private int pageTotalCount;
	//페이지 당 표현 회원 수(=endRow)
	private int memberCountPerPage;
	//멤버리스트 시작 행
	private int startRow;
	private int endRow;
	

	public MemberListView(int memberTotalCount, int currentPageNumber, List<Member> memberList, int memberCountPerPage,
			int startRow, int endRow) {
		this.memberTotalCount = memberTotalCount;
		this.currentPageNumber = currentPageNumber;
		this.memberList = memberList;
		this.memberCountPerPage = memberCountPerPage;
		this.startRow = startRow;
		this.endRow = endRow;
		calcTotalPageCount();
	}



	//pageTotalCount는 메서드를 통해 얻는다.
	private void calcTotalPageCount() {
		if(memberTotalCount <=0) {
			pageTotalCount=0;
		} else {
			pageTotalCount = memberTotalCount / memberCountPerPage;
			if(memberTotalCount % memberCountPerPage > 0) {
				pageTotalCount++;
			}
		}
	}
	

	public int getMemberTotalCount() {
		return memberTotalCount;
	}

	public int getCurrentPageNumber() {
		return currentPageNumber;
	}

	public List<Member> getMemberList() {
		return memberList;
	}

	public int getPageTotalCount() {
		return pageTotalCount;
	}

	public int getMemberCountPerPage() {
		return memberCountPerPage;
	}

	public int getStartRow() {
		return startRow;
	}
	

	public int getEndRow() {
		return endRow;
	}

	
	
	public boolean isEmpty() {
		return memberTotalCount == 0;
	}


	@Override
	public String toString() {
		return "MemberListView [memberTotalCount=" + memberTotalCount + ", currentPageNumber=" + currentPageNumber
				+ ", memberList=" + memberList + ", pageTotalCount=" + pageTotalCount + ", memberCountPerPage="
				+ memberCountPerPage + ", startRow=" + startRow + ", endRow=" + endRow + "]";
	}



	
}
