package phoneNumBook_ver_5_3;

public class PhoneCompanyInfo extends PhoneInfo {

	String company;
	String department;
	String position;
	
	public PhoneCompanyInfo(String name, String phoneNum, Stirgn address, String email, String company, String dept, String position) {
		super(name, phoneNum, address, email);
		this.company=company;
		this.department=dept;
		this.position=position;
	}
	
	
	@Override
	void showDetail() {
		

	}

}
