package phoneNumBook_ver_5_3;

public class PhoneSocietyInfo extends PhoneInfo {

	String nameOfSociety;
	String nickName;
	
	public PhoneSocietyInfo(String name, String phoneNum, String address, String email, String nameOfSociety, String nickName) {
		super(name, phoneNum, address, email);
		this.nameOfSociety=nameOfSociety;
		this.nickName=nickName;
	
	}
	
	
	
	@Override
	void showDetail() {
		showData();
		System.out.println("CafeName : "+this.nameOfSociety);
		System.out.println("NickName : "+this.nickName);
	}

}
