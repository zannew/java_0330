package ver05;

//PhoneInfo클래스를 상속해서 새로운 클래스를 정의
public class PhoneCafeInfo extends PhoneInfo {

	String nameOfCafe;		//동호회 이름
	String nickName;		//닉네임
	
	
	PhoneCafeInfo(String name, String phoneNum, String address, String email, String cafeName, String nickName) {
		super(name, phoneNum, address, email);
		this.nameOfCafe=cafeName;
		this.nickName=nickName;
				
	}


	@Override
	public void showAllInfo() {
		//super.showAllInfo();	//호출할 수 없는 상태
		super.showBasicInfo(); 		//상위클래스 메서드 호출
		System.out.println("동호회 이름 : "+this.nameOfCafe);
		System.out.println("닉네임 : "+this.nickName);
	}

	
	
	

}
