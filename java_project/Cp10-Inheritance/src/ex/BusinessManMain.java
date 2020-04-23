package ex;

public class BusinessManMain {
	//메인메서드
	public static void main(String[] args) {
		//하위클래스 BusinessMane클래스의 객체 생성
		BusinessMan bMan = new BusinessMan("손흥민", "닭집", "대표");
		//참조변수 bMan통해 메서드 호출
		bMan.tellYourInfo();
		
	}

}
