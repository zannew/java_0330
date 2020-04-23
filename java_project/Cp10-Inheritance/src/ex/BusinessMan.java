package ex;

public class BusinessMan extends Man {
	//iv추가
	String company;
	String position;
	
//매개변수 없는 상위클래스 디폴트 생성자를 호출중(에러주의)
//조상클래스의 생성자가 있다면 자손클래스의 생성자에서 값을 받아 
//조상 클래스의 생성자를 호출해서 초기화 해준다.
	BusinessMan(String name, String company, String position){	//생성자
		super(name);	//상위클래스의 생성자호출
		this.company=company;	//매개변수 통한 초기화
		this.position=position;
		
	}
	//void타입 tellYourInfo메서드
	void tellYourInfo() {
//		super.tellYourName();
		tellYourName(); 	//상속했기때문에 바로 사용 가능
		System.out.println("나의 직장 이름은 "+company+"입니다.");
		System.out.println("나의 직급은 "+position+"입니다.");
		
	}
	
}
