package phoneNumBook_ver_5_3;

public abstract class PhoneInfo {
	
	//private키워드 - 다른 클래스에서 변수의 직접 참조를 방지	
	private String name;
	private String phoneNum;
	private String address;
	private String email;


	PhoneInfo(String name, String phoneNum, String address, String email) {
		this.name=name;
		this.phoneNum=phoneNum;
		this.address=address;
		this.email=email;
	
	}
		
//	PhoneInfo(String name, String phoneNum){
//		this.name=name;
//		this.phoneNum=phoneNum;
//		this.bDay="생일이 입력되지 않았습니다.";
//	}
		
	void showData() {
		System.out.println("name : "+this.name);
		System.out.println("phoneNum : "+this.phoneNum);
		System.out.println("address : "+this.address);
		System.out.println("email : "+this.email);
		System.out.println("-----------------------------");
	}
	
	abstract void showDetail();
}
	
