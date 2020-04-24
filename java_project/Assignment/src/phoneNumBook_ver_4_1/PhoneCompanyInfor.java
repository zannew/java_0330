package phoneNumBook_ver_4_1;

public class PhoneCompanyInfor extends PhoneInfo {

	String company;
	
	
	public PhoneCompanyInfor(String name, String phoneNum, String address, String email, String company) {
		super(name, phoneNum, address, email);
		this.company=company;
	}

	
	
	
}
