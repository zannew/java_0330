package com.wifi.order.model;

import java.util.List;

public class RvsView {

	List<Rvs> rvsList;
	int rvsCount=0;
	
	
	public RvsView() {
	}


	public RvsView(List<Rvs> rvsList, int rvsCount) {
		this.rvsList = rvsList;
		this.rvsCount = rvsCount;
	}


	public List<Rvs> getRvsList() {
		return rvsList;
	}


	public void setRvsList(List<Rvs> rvsList) {
		this.rvsList = rvsList;
	}


	public int getRvsCount() {
		return rvsCount;
	}


	public void setRvsCount(int rvsCount) {
		this.rvsCount = rvsCount;
	}


	@Override
	public String toString() {
		return "RvsView [rvsList=" + rvsList + ", rvsCount=" + rvsCount + "]";
	}
	
	
}
