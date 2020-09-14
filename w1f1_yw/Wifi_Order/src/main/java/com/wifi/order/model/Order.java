package com.wifi.order.model;

import java.sql.Timestamp;

import com.fasterxml.jackson.annotation.JsonFormat;

public class Order {

	
	private int oidx;
	private int state;
	private Timestamp orderdate;
	private int midx;
	private int iidx;
	
	
	
	public Order() {
	}

	public Order(int oidx, int state, Timestamp orderdate, int midx, int iidx) {
		super();
		this.oidx = oidx;
		this.state = state;
		this.orderdate = orderdate;
		this.midx = midx;
		this.iidx = iidx;
	}
	
	// OrderRegRequest에서 객체로 변환하기 위한 생성자(midx, iidx만 있음)
	public Order(int midx, int iidx) {
		this(0,0, null, midx, iidx);
	}
	

	public int getOidx() {
		return oidx;
	}

	public void setOidx(int oidx) {
		this.oidx = oidx;
	}

	public int getState() {
		return state;
	}

	public void setState(int state) {
		this.state = state;
	}

	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "Asia/Seoul")
	public Timestamp getOrderdate() {
		return orderdate;
	}

	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "Asia/Seoul")
	public void setOrderdate(Timestamp orderdate) {
		this.orderdate = orderdate;
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

	@Override
	public String toString() {
		return "Order [oidx=" + oidx + ", state=" + state + ", orderdate=" + orderdate + ", midx=" + midx + ", iidx="
				+ iidx + "]";
	}
	
	
	
	
}
