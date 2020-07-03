package model;

public class MemberInfo {

	private String uid;
	private String upw;
	
	public MemberInfo(String uid, String upw) {
		super();
		this.uid = uid;
		this.upw = upw;
	}

	public String getUid() {
		return uid;
	}

	public void setUid(String uid) {
		this.uid = uid;
	}

	public String getUpw() {
		return upw;
	}

	public void setUpw(String upw) {
		this.upw = upw;
	}

	@Override
	public String toString() {
		return "MemberInfo [uid=" + uid + ", upw=" + upw + "]";
	}
	
	
	
}
