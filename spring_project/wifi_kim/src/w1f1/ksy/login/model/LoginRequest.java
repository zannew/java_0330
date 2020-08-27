package w1f1.ksy.login.model;

public class LoginRequest {
	
	private String id;
	private String remember;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getRemember() {
		return remember;
	}
	public void setRemember(String remember) {
		this.remember = remember;
	}

	@Override
	public String toString() {
		return "LoginRequest [id=" + id + ", remember=" + remember + "]";
	}
	
	
	

}
