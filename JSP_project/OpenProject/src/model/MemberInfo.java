package model;
//Open Project - MemberInfo.java
public class MemberInfo {
	
	private String uid;
	private String upw;
	private String uname;
	private String email;
	
	public MemberInfo(String uid, String upw, String uname, String email) {
		super();
		this.uid = uid;
		this.upw = upw;
		this.uname = uname;
		this.email = email;
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

	public String getEmail() {
		return email;
	}

	@Override
	public String toString() {
		return "MemberInfo [uid=" + uid + ", upw=" + upw + ", uname=" + uname + ", email=" + email + "]";
	}
	
	

}
