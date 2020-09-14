package com.wifi.order.model;

public class OrderRegRequest {

	// 요청자 midx
	private int midx;
	
	// 해당 공구 iidx
	private int iidx;
	
	public OrderRegRequest() {}

	public OrderRegRequest(int midx, int iidx) {
		super();
		this.midx = midx;
		this.iidx = iidx;
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
	
	public Order toOrder() {
		return new Order(0,0, null, midx, iidx);
	}

	@Override
	public String toString() {
		return "OrderRegRequest [midx=" + midx + ", iidx=" + iidx + "]";
	}
	
	
}
