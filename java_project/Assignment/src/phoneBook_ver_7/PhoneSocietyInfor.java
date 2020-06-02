package phoneBook_ver_7;

public class PhoneSocietyInfor extends PhoneInfo_abs {

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

	//Getter
	public String getNickName() {
		return nickName;
	}

	//Setter
	public void setNickName(String nickName) {
		this.nickName = nickName;
	}

	
	
	
	
	
	
	
	
	
}
