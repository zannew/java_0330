package phoneBook_ver_7;

//Info인터페이스 상속중
public abstract class PhoneInfo_abs implements Info  {

	private String name;
	private String phoneNum;
	private String address;
	private String email;
	
	//생성자
	public PhoneInfo_abs(String name, String phoneNum, String address, String email) {
		this.name=name;
		this.phoneNum=phoneNum;
		this.address=address;
		this.email=email;
	}
	
	void showBasicInfo() {
		System.out.println("-----기본 정보-----");
		System.out.println("이름: "+this.name);
		System.out.println("전화번호: "+this.phoneNum);
		System.out.println("주소: "+this.address);
		System.out.println("이메일: "+this.email);
	
	}
	

	//Getter
	public String getName() {
		return name;
	}

	public String getPhoneNum() {
		return phoneNum;
	}

	public String getAddress() {
		return address;
	}

	public String getEmail() {
		return email;
	}

	//Setter
	public void setName(String name) {
		this.name = name;
	}

	public void setPhoneNum(String phoneNum) {
		this.phoneNum = phoneNum;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public void setEmail(String email) {
		this.email = email;
	}		

	
	
	//매개변수로 받은 문자열과 name변수에 저장된 문자열 비교메서드
	public boolean checkName(String name) {
		return this.name.equals(name);
	}
}	
	
	
