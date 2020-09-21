package com.wifi.order.model;

public class Messenger {
	
	private int senderMidx;
	private int receiverMidx;
	private int iidx;

	public Messenger() {
	}

	public Messenger(int senderMidx, int receiverMidx, int iidx) {
		this.senderMidx = senderMidx;
		this.receiverMidx = receiverMidx;
		this.iidx = iidx;
	}
	
	public int getSenderMidx() {
		return senderMidx;
	}
	public void setSenderMidx(int senderMidx) {
		this.senderMidx = senderMidx;
	}
	public int getReceiverMidx() {
		return receiverMidx;
	}
	public void setReceiverMidx(int receiverMidx) {
		this.receiverMidx = receiverMidx;
	}
	public int getIidx() {
		return iidx;
	}
	public void setIidx(int iidx) {
		this.iidx = iidx;
	}

}
