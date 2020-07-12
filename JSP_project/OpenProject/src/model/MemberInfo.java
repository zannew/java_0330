package model;
//Open Project - MemberInfo.java
public class MemberInfo {
	
	private String mid;
	private String mpw;
	private String mname;
	private String mphoto;
	
	public MemberInfo() {}

	public MemberInfo(String mid, String mpw, String mname, String mphoto) {
		super();
		this.mid = mid;
		this.mpw = mpw;
		this.mname = mname;
		this.mphoto = mphoto;
	}

	public String getMid() {
		return mid;
	}

	public void setMid(String mid) {
		this.mid = mid;
	}

	public String getMpw() {
		return mpw;
	}

	public void setMpw(String mpw) {
		this.mpw = mpw;
	}

	public String getMname() {
		return mname;
	}

	public void setMname(String mname) {
		this.mname = mname;
	}

	public String getMphoto() {
		return mphoto;
	}

	public void setMphoto(String mphoto) {
		this.mphoto = mphoto;
	}

	@Override
	public String toString() {
		return "MemberInfo [mid=" + mid + ", mpw=" + mpw + ", mname=" + mname + ", mphoto=" + mphoto + "]";
	}
	
	
	

}
