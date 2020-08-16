package com.wifi.sell.model;

public class ItemRvs {

	private int irsIdx;
	private int scoreS;
	// 평가자의 회원번호
	private int mIdx;
	private int iIdx;
	
	// 디폴트 생성자
	public ItemRvs() {
		super();
	}

	public ItemRvs(int irsIdx, int scoreS, int mIdx, int iIdx) {
		super();
		this.irsIdx = irsIdx;
		this.scoreS = scoreS;
		this.mIdx = mIdx;
		this.iIdx = iIdx;
	}

	public int getIrsIdx() {
		return irsIdx;
	}

	public void setIrsIdx(int irsIdx) {
		this.irsIdx = irsIdx;
	}

	public int getScoreS() {
		return scoreS;
	}

	public void setScoreS(int scoreS) {
		this.scoreS = scoreS;
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
		return "ItemRvs [irsIdx=" + irsIdx + ", scoreS=" + scoreS + ", mIdx=" + mIdx + ", iIdx=" + iIdx + "]";
	}

	
	
	
}
