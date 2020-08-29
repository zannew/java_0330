package com.wifi.order.model;

public class Rvs {

	private int midx;
	private int score_s;
	
	
	public Rvs() {
	}


	public Rvs(int midx, int score_s) {
		this.midx = midx;
		this.score_s = score_s;
	}


	public int getMidx() {
		return midx;
	}


	public void setMidx(int midx) {
		this.midx = midx;
	}


	public int getScore_s() {
		return score_s;
	}


	public void setScore_s(int score_s) {
		this.score_s = score_s;
	}


	@Override
	public String toString() {
		return "Rvs [midx=" + midx + ", score_s=" + score_s + "]";
	}
	
	
	
}
