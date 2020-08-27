package w1f1.ksy.login.model;

public class MemberRegRequest {
	
	private String id;
	private String name;
	private String addr;
	private String phone;
	
	
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
	
	public Member toMember() {
		return new Member(id, name, addr, phone);
	}
	
	
	@Override
	public String toString() {
		return "MemberRegRequest [id=" + id + ", name=" + name + ", addr=" + addr + ", phone=" + phone + "]";
	}

	
}
