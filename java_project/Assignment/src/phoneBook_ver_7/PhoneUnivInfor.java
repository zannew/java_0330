package phoneBook_ver_7;

public class PhoneUnivInfor extends PhoneInfo_abs {

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

	//Getter
	public String getMajor() {
		return major;
	}

	public String getYear() {
		return year;
	}

	//Setter
	public void setMajor(String major) {
		this.major = major;
	}

	public void setYear(String year) {
		this.year = year;
	}
	
	
	
	
	
	
}
