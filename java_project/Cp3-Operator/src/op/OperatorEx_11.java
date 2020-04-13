package op;

public class OperatorEx_11 {
	public static void main(String[] args) {
		
		long a = 1000000 * 1000000;
		long b = 1000000 * 1000000L; // long형 리터럴
		
		System.out.println(a);		//int타입으로 출력돼서 값의 왜곡이 생김
		System.out.println(b);		//1조 출력
		
		
		
	}
}
