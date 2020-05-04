package phoneNumBook_ver_6_2_submit;

//Info인터페이스 상속중
public abstract class PhoneInfo implements Info  {

	private String name;
	private String phoneNum;
	private String address;
	private String email;
	
	//생성자
	public PhoneInfo(String name, String phoneNum, String address, String email) {
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
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	//매개변수로 받은 문자열과 name변수에 저장된 문자열 비교메서드
	public boolean checkName(String name) {
		return this.name.equals(name);
	}		
	
}	
	
	
