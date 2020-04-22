package newPhoneBook;

public class PhoneInfo_Show {

	String name;
	String phoneNum;
	String bDay;
	
	
	
	void showInfo() {
		System.out.println("이름: "+this.name);
		System.out.println("전화번호: "+this.phoneNum);
		System.out.println("생일: "+this.bDay);
	}
	
}
