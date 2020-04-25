package phoneNumBook_ver_4_1;

public class PhoneSocietyInfor extends PhoneInfo {

	String nickname;
	
	public PhoneSocietyInfor(String name, String phoneNum, String address, String email, String nickname) {
		super(name, phoneNum, address, email);
		this.nickname=nickname;
	}
		
		
	void showDetail() {
//		showBasicInfo();
		System.out.println("-----details-----");
		System.out.println("활동 닉네임: "+this.nickname);
		System.out.println("-----------------");

	}
}
