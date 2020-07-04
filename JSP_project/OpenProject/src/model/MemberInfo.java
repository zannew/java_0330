package model;
//Open Project - MemberInfo.java
public class MemberInfo {
	
	private String uid;
	private String upw;
	private String uname;
	private String uphoto;
	
	public MemberInfo(String uid, String upw, String uname, String uphoto) {
		super();
		this.uid = uid;
		this.upw = upw;
		this.uname = uname;
		this.uphoto = uphoto;
	}

	public String getUid() {
		return uid;
	}

	public String getUpw() {
		return upw;
	}

	public String getUname() {
		return uname;
	}

	public String getUphoto() {
		return uphoto;
	}

	@Override
	public String toString() {
		return "MemberInfo [uid=" + uid + ", upw=" + upw + ", uname=" + uname + ", uphoto=" + uphoto + "]";
	}

	
	

}
