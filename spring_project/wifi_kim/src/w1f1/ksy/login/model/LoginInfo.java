package w1f1.ksy.login.model;

public class LoginInfo {
	
	private int midx;
	private String id;
	private String name;
	private String addr;
	private String phone;
	
	public LoginInfo() {
		
	}
	
	public LoginInfo(int midx, String id, String name, String addr, String phone) {
		this.midx = midx;
		this.id = id;
		this.name = name;
		this.addr = addr;
		this.phone = phone;
	}
	
	
	
	public int getMidx() {
		return midx;
	}

	public void setMidx(int midx) {
		this.midx = midx;
	}

	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddr() {
		return addr;
	}
	public void setAddr(String addr) {
		this.addr = addr;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}

	@Override
	public String toString() {
		return "LoginInfo [midx=" + midx + ", id=" + id + ", name=" + name + ", addr=" + addr + ", phone=" + phone + "]";
	}

	
	
}
