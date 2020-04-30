package phoneNumBook_ver_5_3;

public class PhoneUnivInfo extends PhoneInfo {

	String major;
	String year;
	
	public PhoneUnivInfo(String name, String phoneNum, String address, String email, String major, String year) {
		super(name, phoneNum, address, email);
		this.major=major;
		this.year=year;
	}
	
	@Override
	void showDetail() {
		showData();
		System.out.println("전공 : "+this.major);
		System.out.println("학년 : "+this.year);
	}
	
	
}
