package ex;

public class AgeInputException extends Exception {

	//Exception 클래스의 생성자로 전달되는 문자열이 getMessage 메소드 호출 시 반환되는 문자열
	public AgeInputException() {
		super("유효하지 않은 나이가 입력되었습니다.");
		
	}

	
	
	
}
