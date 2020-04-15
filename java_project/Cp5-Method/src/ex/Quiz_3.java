package ex;

public class Quiz_3 {
	
	
	static float pi = 3.14f;

	public static void main(String[] args) {
//	원의 반지름 정보를 전달하면, 원의 넓이를 계산해서 반환하는 메서드와 원
//	의 둘레를 계산해서 반환하는 메서드를 각각 정의하고, 이를 호출하는 main
//	메서드를 정의하자. (2*π*r), (π*r∧2)
		
		circle_area(4);
		circle_round(4);
		
	}

	static void circle_area(int r) {
		float area = ((r*r)*pi);
		System.out.println("원의 넓이는 : "+area);
	}
	
	static void circle_round(int r) {
		float round = (2*pi*r);
		System.out.println("원의 둘레는 : "+round);
		
	}
	
	
	
	
	
	
}
