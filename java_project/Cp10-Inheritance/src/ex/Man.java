package ex;

public class Man {

	String name;
	
	//생성자(인스턴스 초기화 메서드)
	public Man(String name) {
		//매개변수 통한 초기화
		this.name=name;
	
	}
	//void타입 tellYourName메서드
	void tellYourName() {
		System.out.println("나의 이름은 "+name+"입니다.");
	}
	
	
}
