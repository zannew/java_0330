package op;

public class OperatorEx_8 {
	public static void main(String[] args) {
		
		 byte a = 10; 		//byte타입 변수 a를 선언하고 10으로 초기화
		 byte b = 20; 		//byte타입 변수 b를 선언하고 20으로 초기화
		 byte c = (byte)(a+b); // byte c = a + b; → 에러 , 타입변환 필요
		 System.out.println(c); //c를 출력 : 30
		
	}
}
