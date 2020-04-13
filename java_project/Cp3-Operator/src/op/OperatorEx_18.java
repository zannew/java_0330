package op;

public class OperatorEx_18 {
	public static void main(String[] args) {
		
		float pi = 3.141592f;	//float타입 변수 pi를 선언하고 값을 저장(3.141592f)
		float shortPi = Math.round(pi * 1000) / 1000f;
		//float타입 변수 shortPi를 선언하고
		//반올림함수 math.round사용 변수pi의 값에 1000을 곱하고 반올림한다.
		//반올림한 값(3142)에 1000f를 나누면서 float타입으로 다시 변환
		System.out.println(shortPi);
		//float타입 3.142출력
		
	}
}
