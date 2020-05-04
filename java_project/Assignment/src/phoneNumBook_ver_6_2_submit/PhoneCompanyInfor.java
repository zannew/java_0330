package phoneNumBook_ver_6_2_submit;

public class PhoneCompanyInfor extends PhoneInfo {

	String company;
	
	
	public PhoneCompanyInfor(String name, String phoneNum, String address, String email, String company) {
		super(name, phoneNum, address, email);
		this.company=company;
	}
	public void showDetail() {
		System.out.println("-----details-----");
		System.out.println("직장: "+this.company);
		System.out.println("-----------------");
	}
	
}
