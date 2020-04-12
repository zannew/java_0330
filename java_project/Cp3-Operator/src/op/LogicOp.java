package op;

public class LogicOp {

	public static void main(String[] args) {
		
		//정수형 데이터 2개를 받는다
		//int num1= 10, num2 = 20;
		int num1 = 10 ;	//사용자에게 받는 첫번째 숫자
		int num2 = 20;  //사용자에게 받는 두번째 숫자
		
		//num1이 num2보다 큰지 확인 
		//큰 경우 -> true, 작은 경우 -> false
		boolean check1 = num1 > num2;		//논리형 변수 check1에 num1 > num2의 값이 담긴다.(참 또는 거짓)
		boolean check2 = num1 == num2;		//논리형 변수 check1에 num1 == num2의 값이 담긴다.(참 또는 거짓)
		
		if(check2) {									// 참이면
			System.out.println("num1과 num2의 값은 같다");	//"같다"출력
		}else {											// 거짓이면
			System.out.println("num1과 num2의 값은 다르다");	//"다르다"출력
		}
		
		
		
		if(check1) {												// 참이면
			System.out.println("num1의 값이 num2의 값보다 크다");			//"num1이 크다."출력
		}else {														// 거짓이면
			System.out.println("num1의 값이 num2의 값보다 작다");			//"num1이 작다."출력
		}
		System.out.println("----------------------------");			// 점선
		
		//성인 
		//여성 
		//기혼자에게만 메시지를 출력합니다
		int age = 20;												//int형 변수 age 선언과 20으로 초기화
		char gender = 'w';											//char형 변수 gender 선언과 'w'로 초기화
		boolean mCheck = true;										//논리형 변수 mCheck 선언과 true로 초기화
		
		boolean result = age>19 && gender=='w' && mCheck;			//논리형 변수 result 선언과 논리연산 값을 저장
		
		if (result) {												//result가 true면
			System.out.println("메시지를 보냅니다.");						//메시지를 보낸다.
		}
		
		
		
	}

}
