package phoneBook_ver_7;

//Info인터페이스 상속중
public class PhoneInfo {

	private String name;
	private String phoneNum;
	private String address;
	private String email;
	private String major;
	private int year;
	private String companyName;
	private String PBType;
//	private String dept;
//	private String cafeName;
//	private String nickName;
	
	
	
	
	//생성자
	public PhoneInfo(String name, String phoneNum, String address, String email
					, String major, int year, String companyName, String PBType) {
		this.name = name;
		this.phoneNum = phoneNum;
		this.address = address;
		this.email = email;
		this.major = major;
		this.year = year;
		this.companyName = companyName;
		this.PBType=PBType;
//		this.dept = dept;
//		this.cafeName = cafeName;
//		this.nickName = nickName;
	}

	
	
	void showBasicInfo() {
		System.out.println("-----친구 정보-----");
		System.out.println("이름: "+this.name);
		System.out.println("전화번호: "+this.phoneNum);
		System.out.println("주소: "+this.address);
		System.out.println("이메일: "+this.email);
		System.out.println("전공 : "+this.major);
		System.out.println("학년 : "+this.year);
		System.out.println("회사이름 : "+this.companyName);
		System.out.println("폰북타입 : "+this.PBType);
//		System.out.println("부서 : "+this.dept);
//		System.out.println("카페명 : "+this.cafeName);
//		System.out.println("닉네임 : "+this.nickName);
	
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
	
	public String getMajor() {
		return major;
	}

	public int getYear() {
		return year;
	}

	public String getCompanyName() {
		return companyName;
	}
	
	public String getPBType() {
		return PBType;
	}
	
	
//
//	public String getDept() {
//		return dept;
//	}
//
//	public String getCafeName() {
//		return cafeName;
//	}
//
//	public String getNickName() {
//		return nickName;
//	}



	



	


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

	public void setMajor(String major) {
		this.major = major;
	}



	public void setYear(int year) {
		this.year = year;
	}



	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	
	public void setPBType(String pBType) {
		PBType = pBType;
	}

	
//
//
//
//	public void setDept(String dept) {
//		this.dept = dept;
//	}
//
//
//
//	public void setCafeName(String cafeName) {
//		this.cafeName = cafeName;
//	}
//
//
//
//	public void setNickName(String nickName) {
//		this.nickName = nickName;
//	}



	//매개변수로 받은 문자열과 name변수에 저장된 문자열 비교메서드
	public boolean checkName(String name) {
		return this.name.equals(name);
	}
}	
	
	
