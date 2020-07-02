package model;

public class LoginInfo {

	// access modifier → private
	private String uid;
	private String name;

	// 빈즈 클래스는 default 생성자 필수
	public LoginInfo() {
//		uid="cool";
//		name="손흥민";
	}

	public LoginInfo(String uid, String name) {
		super();
		this.uid = uid;
		this.name = name;
	}

	//getter, setter
	public String getUid() {
		return uid;
	}

	public void setUid(String uid) {
		this.uid = uid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "LoginInfo [uid=" + uid + ", name=" + name + "]";
	}
	
	

}
