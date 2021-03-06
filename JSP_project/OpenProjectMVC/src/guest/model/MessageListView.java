package guest.model;

import java.util.List;

public class MessageListView {

	// 전체 게시물의 개수
	private int messageTotalCount;
	// 현재 페이지 번호
	private int currentPageNumber;
	// 메시지 리스트
	private List<Message> messageList;
	// 전체 페이지의 개수
	private int pageTotalCount;
	// 페이지 당 표현 게시물의 개수
	private int messageCountPerPage;
	// 게시물의 시작 행
	private int startRow;
	// 게시물의 마지막 행
	private int endRow;
	
	/*
	 * 생성자와 getter만 가지도록 처리 
	 * start, endRow는 생성자에서 메서드 calTotalPageCount();를 호출해서 얻는다.
	 */
	
	public MessageListView(int messageTotalCount, int currentPageNumber, List<Message> messageList,
			int messageCountPerPage, int startRow, int endRow) {
		super();
		this.messageTotalCount = messageTotalCount;
		this.currentPageNumber = currentPageNumber;
		this.messageList = messageList;
		this.messageCountPerPage = messageCountPerPage;
		this.startRow = startRow;
		this.endRow = endRow;
		calTotalPageCount();
		
	}
	
	// new MessageListView(); : 생성시 변수, 메서드 호출 가능해진다.
	
	private void calTotalPageCount() {
		
		if(messageTotalCount == 0) {
			pageTotalCount = 0;
		}else {
			pageTotalCount = messageTotalCount / messageCountPerPage;
			if(messageTotalCount % messageCountPerPage > 0) {
				pageTotalCount++;
			}
		}
	}

	public int getMessageTotalCount() {
		return messageTotalCount;
	}

	public int getCurrentPageNumber() {
		return currentPageNumber;
	}

	public List<Message> getMessageList() {
		return messageList;
	}

	public int getPageTotalCount() {
		return pageTotalCount;
	}

	public int getMessageCountPerPage() {
		return messageCountPerPage;
	}

	public int getStartRow() {
		return startRow;
	}

	public int getEndRow() {
		return endRow;
	}

	@Override
	public String toString() {
		return "MessageListView [messageTotalCount=" + messageTotalCount + ", currentPageNumber=" + currentPageNumber
				+ ", messageList=" + messageList + ", pageTotalCount=" + pageTotalCount + ", messageCountPerPage="
				+ messageCountPerPage + ", startRow=" + startRow + ", endRow=" + endRow + "]";
	}
	
	public boolean isEmpty() {
		return messageTotalCount == 0;
	}
	
	
}
