package phoneBook_ver_7;

public class PhoneCompanyInfor extends PhoneInfo_abs {

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
	
	//Getter
	public String getCompany() {
		return company;
	}
	
	//Setter
	public void setCompany(String company) {
		this.company = company;
	}
	
	
	
	
	
}
