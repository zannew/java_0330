package op;

public class OperatorEx_25 {
	public static void main(String[] args) {
		
		int x = 3;		//int타입 변수 x에 3 저장
		int y = 5;		//int타입 변수 y에 5 저장
		
		
		System.out.println("x는 " + x + "이고, y는 " + y +"일 때, ");	//x의 값은 3, y의 값은 5
		System.out.println("x | y = " + (x|y));					//
		System.out.println("x & y = " + (x&y));
		System.out.println("x ^ y = " + (x^y));
		System.out.println("true | false = " + (true|false));
		System.out.println("true & false = " + (true&false));
		System.out.println("true ^ false = " + (true^false));
		
	}
}
