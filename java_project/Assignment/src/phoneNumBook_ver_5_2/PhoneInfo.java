package phoneNumBook_ver_5_2;

/*
Project ver 0.50
PhoneBookManager 클래스의 인스턴스수가 최대 하나를 넘지 않도록 코드를
변경.
‘interface’기반의 상수 표현을 바탕으로 메뉴 선택과 그에 따른 처리가, 이름에 부여된 상 수를 기반으로 진행되도록 변경.
PhoneInfor 클래스의 구조에서 “interface”를 추가하여 “추상 클래스”로 구성해봅시다
이 인터페이스에는 오버라이딩을 위한 메서드만 포한하는 인터페이스로 구성합니다

*/
//Info인터페이스 상속중
public abstract class PhoneInfo implements Info  {

	private String name;
	private String phoneNum;
	private String address;
	private String email;
	
	//생성자
	public PhoneInfo(String name, String phoneNum, String address, String email) {
		this.name=name;
		this.phoneNum=phoneNum;
		this.address=address;
		this.email=email;
	}
	
	void showBasicInfo() {
		System.out.println("-----기본 정보-----");
		System.out.println("이름: "+this.name);
		System.out.println("전화번호: "+this.phoneNum);
		System.out.println("주소: "+this.address);
		System.out.println("이메일: "+this.email);
	
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	//오버라이딩을 위해 상위클래스에 생성
//	abstract void showDetail();
	
	
	
	//매개변수로 받은 문자열과 name변수에 저장된 문자열 비교메서드
	public boolean checkName(String name) {
		return this.name.equals(name);
	}		
	
}	
	
	
