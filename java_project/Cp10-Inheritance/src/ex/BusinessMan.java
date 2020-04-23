package ex;

public class BusinessMan extends Man {
	
	String company;
	String position;
	
//매개변수 없는 상위클래스 디폴트 생성자를 호출중(에러주의)
//조상클래스의 생성자가 있다면 자손클래스의 생성자에서 값을 받아 
//조상 클래스의 생성자를 호출해서 초기화 해준다.
	BusinessMan(String name, String company, String position){
		super(name);	//상위클래스의 생성자호출
		this.company=company;
		this.position=position;
		
	}
	
	void tellYourInfo() {
//		super.tellYourName();
		tellYourName(); 	//상속했기때문에 바로 사용 가능
		System.out.println("나의 직장 이름은 "+company+"입니다.");
		System.out.println("나의 직급은 "+position+"입니다.");
		
	}
	
}
