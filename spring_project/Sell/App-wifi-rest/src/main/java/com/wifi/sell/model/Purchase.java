package com.wifi.sell.model;

public class Purchase {

	private int pIdx;
	private String qr;
	private int state;	//수령/미수령
	private int oIdx;
	
	// 디폴트 생성자
	public Purchase() {
	}

	public Purchase(int pIdx, String qr, int state, int oIdx) {
		this.pIdx = pIdx;
		this.qr = qr;
		this.state = state;
		this.oIdx = oIdx;
	}

	public int getpIdx() {
		return pIdx;
	}

	public void setpIdx(int pIdx) {
		this.pIdx = pIdx;
	}

	public String getQr() {
		return qr;
	}

	public void setQr(String qr) {
		this.qr = qr;
	}

	public int getState() {
		return state;
	}

	public void setState(int state) {
		this.state = state;
	}

	public int getoIdx() {
		return oIdx;
	}

	public void setoIdx(int oIdx) {
		this.oIdx = oIdx;
	}

	@Override
	public String toString() {
		return "Purchase [pIdx=" + pIdx + ", qr=" + qr + ", state=" + state + ", oIdx=" + oIdx + "]";
	}	
	
	
	
	
}
