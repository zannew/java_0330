package op;

public class OperatorEx_12 {
	public static void main(String[] args) {
		
		int a = 1000000 * 100000 / 1000000;	//int타입으로 연산
		int b = 1000000 / 100000 * 1000000;	//int타입으로 연산
		System.out.println(a);				//곱셈연산부터 값의 왜곡이 생김
		System.out.println(b);				//정상 출력

	}
}
