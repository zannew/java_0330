package phoneNumBook_ver_6_2_submit;

public class PhoneSocietyInfor extends PhoneInfo {

	String nickName;
	
	public PhoneSocietyInfor(String name, String phoneNum, String address, String email, String nickName) {
		super(name, phoneNum, address, email);
		this.nickName=nickName;
	}
		
		
	public void showDetail() {
//		showBasicInfo();
		System.out.println("-----details-----");
		System.out.println("활동 닉네임: "+this.nickName);
		System.out.println("-----------------");

	}
}
