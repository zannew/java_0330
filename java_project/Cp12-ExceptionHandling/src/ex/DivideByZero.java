package ex;

public class DivideByZero {

	public static void main(String[] args) {
		
		int num1=10;
		int num2=0;
		
		
		//try&catch : transaction(하나의 일의 단위) check!
		try {
		//여기가 예외 발생 지점
		int divide = num1/num2;
		//println메서드는 위의 문장이 정상적으로 실행될 때 
		System.out.println("연산의 결과는 : "+divide);
		}
		catch(ArithmeticException e){
			System.out.println("0으로 나눌 수 없습니다.");
			System.out.println(e.getMessage());			//ArithmeticException클래스가 가진 예외메시지
			e.printStackTrace(); 	//
			return;
		}
		finally {
			System.out.println("무조건 실행하는 finally블럭");
		}
		
		System.out.println("프로그램을 종료합니다.");
		
		
	}
	
	
}
