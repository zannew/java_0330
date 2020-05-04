package phoneNumBook_ver_6_2_submit;

public class PhoneUnivInfor extends PhoneInfo {

	String major;
	String year;
	
	
	public PhoneUnivInfor(String name, String phoneNum, String address, String email, String major, String year) {
		super(name, phoneNum, address, email);
		this.major=major;
		this.year=year;
		
	}
	
	public void showDetail() {
		System.out.println("-----details-----");
		System.out.println("전공: "+this.major);
		System.out.println("학년: "+this.year);
		System.out.println("-----------------");
	}
	
}
