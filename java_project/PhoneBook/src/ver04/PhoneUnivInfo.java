package ver04;

//PhoneInfo클래스를 상속해서 새로운 클래스를 정의
public class PhoneUnivInfo extends PhoneInfo{

	String major;		//친구의 전공
	String grade;		//친구의 학년
	
	//인스턴스 변수 초기화
	PhoneUnivInfo(String name, String phoneNum, String address, String email, String major, String grade) {
		super(name, phoneNum, address, email);
		this.major=major;
		this.grade=grade;		//수치 계산 목적이 아니라면 String타입으로 받아도 ok
		
	}


	@Override
	void showAllInfo() {
		super.showAllInfo(); 	//상위클래스 메서드 호출
		System.out.println("전공 : "+this.major);
		System.out.println("학년 : "+this.grade);
	}

	

}
