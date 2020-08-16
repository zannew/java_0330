package com.wifi.sell.model;

public class ItemRvb {

	private int irbIdx;
	private int scoreB;
	private int mIdx;
	private int iIdx;
	
	// 디폴트 생성자
	public ItemRvb() {
	}

	public ItemRvb(int irbIdx, int scoreB, int mIdx, int iIdx) {
		super();
		this.irbIdx = irbIdx;
		this.scoreB = scoreB;
		this.mIdx = mIdx;
		this.iIdx = iIdx;
	}

	public int getIrbIdx() {
		return irbIdx;
	}

	public void setIrbIdx(int irbIdx) {
		this.irbIdx = irbIdx;
	}

	public int getScoreB() {
		return scoreB;
	}

	public void setScoreB(int scoreB) {
		this.scoreB = scoreB;
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
		return "ItemRvb [irbIdx=" + irbIdx + ", scoreB=" + scoreB + ", mIdx=" + mIdx + ", iIdx=" + iIdx + "]";
	}
	
	
	
}
