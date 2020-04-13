package op;

public class OperatorEx_17 {
	public static void main(String[] args) {
		
		float pi = 3.141592f;		//float타입 변수 pi를 선언하고 값을 저장(3.141592f)
		float shortPi = (int)(pi * 1000) / 1000f;	
		//float타입 변수 shortPi를 선언하고
		//pi의 값에 1000곱한 값을 int타입으로 변환하고 
		//다시 1000f로 나누고 float타입으로 변환
		System.out.println(shortPi);	//float타입 3.141 출력
		
		
	}
}
