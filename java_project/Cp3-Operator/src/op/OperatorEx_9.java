package op;

public class OperatorEx_9 {
	public static void main(String[] args) {
		
		byte a = 10; 			//byte타입 변수 a를 선언하고 10으로 초기화
		byte b = 30; 			//byte타입 변수 b를 선언하고 30으로 초기화
		byte c = (byte)(a * b);	//a와 b를 곱한 후 int → byte로 형변환(연산하면서 int로 형변환된 상태)
		//int c = a * b; (타입을 변경해서 정확한 값을 출력)
		System.out.println(c);	//c 출력 : 44 → byte의 표현범위를 초과했기 때문에 값이 왜곡됐다. (예상 값 : 300)
		

	}
}
