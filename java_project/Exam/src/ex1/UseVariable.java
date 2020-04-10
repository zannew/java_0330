package ex1;

public class UseVariable {

	public static void main(String[] args) {

		// 1. 정수형 타입의 변수 num1변수를 선언하자
		int num1;
		
		// 2. 변수 num1에 숫자 데이터 10을 저장하자.
		num1 = 10;
		
		// 3. 정수형 타입의 변수 num2변수를 선언하고
		int num2 = 20;		//변수 선언과 초기화가 동시에
		// 숫자 20을 대입하자.
		
		// 4. 정수형 타입의 변수 num3을 선언하고
		// 변수 num1과 num2를 합하는 연산한 결과를
		// 변수 num3에 대입한다.
		int num3 = num1 + num2;
		
		// 5. 연산의 결과를 출력하자.
		System.out.println(num3);
		System.out.println(num1+"+"+num2+"="+num3);
		
		
		
	}

}

