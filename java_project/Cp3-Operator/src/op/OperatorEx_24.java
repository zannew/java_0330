package op;

public class OperatorEx_24 {
	public static void main(String[] args) {
		
		char x = 'j';
		//1. x의 문자코드값이 'a'문자코드값과 같거나 크고, 'z'문자코드값과 같거나 작다면
		//2. x의 문자코드값이 'A'문자코드값과 같거나 크고, 'Z'문자코드값과 같거나 작다면
		//1과 2 둘 중 하나만 참이어도 true
		if((x>='a' && x <='z') || (x>='A' && x <='Z')) {
		System.out.println("유효한 문자입니다.");
		} else {
		//1과 2 모두 거짓이라면
		System.out.println("유효하지 않은 문자입니다.");
		}
		
		
	}
}
