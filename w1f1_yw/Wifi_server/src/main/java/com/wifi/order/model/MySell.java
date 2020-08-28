package com.wifi.order.model;

import java.sql.Timestamp;



import com.fasterxml.jackson.annotation.JsonFormat;

public class MySell {

	private int midx;		//i.midx
	private int o_midx;		//o.midx
	private int iidx;		//i.iidx
	private int oidx;
	private int pidx;
	private String title;
	private int category;
	private int istate;
	private int ostate;
	private int pstate;
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "Asia/Seoul")
	private Timestamp ireceive;

	// 디폴트 생성자
	public MySell() {
	}

	public MySell(int midx, int o_midx, int iidx, int oidx, int pidx, String title, int category, int istate,
			int ostate, int pstate, Timestamp ireceive) {
		super();
		this.midx = midx;
		this.o_midx = o_midx;
		this.iidx = iidx;
		this.oidx = oidx;
		this.pidx = pidx;
		this.title = title;
		this.category = category;
		this.istate = istate;
		this.ostate = ostate;
		this.pstate = pstate;
		this.ireceive = ireceive;
	}


	public int getMidx() {
		return midx;
	}

	public void setMidx(int midx) {
		this.midx = midx;
	}
	

	public int getO_midx() {
		return o_midx;
	}

	public void setO_midx(int o_midx) {
		this.o_midx = o_midx;
	}

	public int getIidx() {
		return iidx;
	}

	public void setIidx(int iidx) {
		this.iidx = iidx;
	}

	public int getOidx() {
		return oidx;
	}

	public void setOidx(int oidx) {
		this.oidx = oidx;
	}

	public int getPidx() {
		return pidx;
	}

	public void setPidx(int pidx) {
		this.pidx = pidx;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public int getCategory() {
		return category;
	}

	public void setCategory(int category) {
		this.category = category;
	}

	public int getIstate() {
		return istate;
	}

	public void setIstate(int istate) {
		this.istate = istate;
	}

	public int getOstate() {
		return ostate;
	}

	public void setOstate(int ostate) {
		this.ostate = ostate;
	}

	public int getPstate() {
		return pstate;
	}

	public void setPstate(int pstate) {
		this.pstate = pstate;
	}

	public Timestamp getIreceive() {
		return ireceive;
	}

	//@DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")
	@JsonFormat(pattern = "YYYY-MM-DD HH:mm:ss", timezone = "Asia/Seoul")
	public void setIreceive(Timestamp ireceive) {

		this.ireceive = ireceive;
	}
	
	// java.sql.Date → java.util.Date 변환	
	//@DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")
	@JsonFormat(pattern = "YYYY-MM-DD HH:mm:ss", timezone = "Asia/Seoul")
	public java.util.Date getToDate(){		//${member.toDate}
		return new java.util.Date(ireceive.getTime());	// getTime() : 기준 날짜이후 밀리세컨단위 long타입으로 리턴
	}

	@Override
	public String toString() {
		return "MySell [midx=" + midx + ", iidx=" + iidx + ", oidx=" + oidx + ", pidx=" + pidx + ", title=" + title
				+ ", category=" + category + ", istate=" + istate + ", ostate=" + ostate
				+ ", pstate=" + pstate + ", ireceive=" + ireceive + "]";
	}

	
	
}
