package com.wifi.sell.model;

public class Order {

	private int oIdx;
	private int mIdx;	//회원번호
	private int iIdx;	//공구번호
	
	public Order() {
		super();
	}

	
	
	public Order(int oIdx, int mIdx, int iIdx) {
		super();
		this.oIdx = oIdx;
		this.mIdx = mIdx;
		this.iIdx = iIdx;
	}



	public int getoIdx() {
		return oIdx;
	}



	public void setoIdx(int oIdx) {
		this.oIdx = oIdx;
	}



	public int getmIdx() {
		return mIdx;
	}



	public void setmIdx(int mIdx) {
		this.mIdx = mIdx;
	}



	public int getiIdx() {
		return iIdx;
	}



	public void setiIdx(int iIdx) {
		this.iIdx = iIdx;
	}



	@Override
	public String toString() {
		return "Order [oIdx=" + oIdx + ", mIdx=" + mIdx + ", iIdx=" + iIdx + "]";
	}
	
	
	
}
