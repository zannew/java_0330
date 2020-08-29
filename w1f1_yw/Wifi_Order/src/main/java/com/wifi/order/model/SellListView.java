package com.wifi.order.model;

import java.util.List;

public class SellListView {

	private int sellTotalCnt;
	private int currentPageNumber;
	private List<MySell> sellList;
	private int pageTotalCount;
	private int itemCountPerPage;
	private int startRow;
	
	public SellListView(int sellTotalCnt, int currentPageNumber, List<MySell> sellList, int itemCountPerpage,
			int startRow) {
		this.sellTotalCnt = sellTotalCnt;
		this.currentPageNumber = currentPageNumber;
		this.sellList = sellList;
		this.itemCountPerPage = itemCountPerpage;
		this.startRow = startRow;
		calcPageTotalCount();
	}
	
	public void calcPageTotalCount() {
		
		if(sellTotalCnt==0) {
			pageTotalCount = 0;
		} else {
			pageTotalCount = sellTotalCnt/itemCountPerPage;
			System.out.println("아이템 토탈 % 아이템퍼페이지의 나머지 : "+sellTotalCnt%itemCountPerPage);
			if(sellTotalCnt%itemCountPerPage > 0) {
				pageTotalCount ++;
			}
			System.out.println("페이지토탈카운트 : "+pageTotalCount);
		}
		
	}
	
	// only getter
	public int getSellTotalCount() {
		return sellTotalCnt;
	}

	public int getCurrentPageNumber() {
		return currentPageNumber;
	}

	public List<MySell> getSellList() {
		return sellList;
	}

	public int getPageTotalCount() {
		return pageTotalCount;
	}

	public int getItemCountPerPage() {
		return itemCountPerPage;
	}

	public int getStartRow() {
		return startRow;
	}

	@Override
	public String toString() {
		return "ItemListView [sellTotalCnt=" + sellTotalCnt + ", currentPageNumber=" + currentPageNumber
				+ ", sellList=" + sellList + ", pageTotalCount=" + pageTotalCount + ", itemCountPerPage="
				+ itemCountPerPage + ", startRow=" + startRow + "]";
	}
	
	
	
}
