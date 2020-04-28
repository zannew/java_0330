package ver05;

//상속을 위한 기본 클래스 구성
public abstract class PhoneInfo implements Info {

	private String name;			//친구의 이름
	private String phoneNum;		//친구의 전화번호
	private String address;			//친구의 주소
	private String email;			//친구의 이메일

	//인스턴스 변수 초기화
	PhoneInfo(String name, String phoneNum, String address, String email){
		this.name=name;
		this.phoneNum=phoneNum;
		this.address=address;
		this.email=email;
	}
	
	//기본 정보 출력메서드
	void  showBasicInfo() {
		System.out.println("이름 : "+ this.name);
		System.out.println("전화번호 : "+ this.phoneNum);
		System.out.println("주소 : "+ this.address);
		System.out.println("이메일 : "+ this.email);
	}
	
	
	//전체 정보 출력메서드(상속 후 오버라이딩을 통해 재구성)
//	abstract void showAllInfo() {
//		showBasicInfo();
//	}
	
	boolean checkName(String name) {
		return this.name.equals(name);
		
		
	}
	//getter로 name값 반환 받아 다른 클래스에서 사용!(지금 name은 private상태)
	public String getName() {
		return name;
	}
	
	
	
}
