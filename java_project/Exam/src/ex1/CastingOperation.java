package ex1;

public class CastingOperation {

	public static void main(String[] args) {
		char ch1 ='A';	//문자타입의 변수 ch1선언, 초기화해서 'A'저장
		char ch2 = 'Z';
		
		int num1 = ch1;	//ch1 char -> int (형변환 일어남)
		int num2 = (int)ch2;	//명시적형변환
		
		System.out.println("문자A의 유니코드 값:"+num1);	//유니코드 값 문자열 출력
		System.out.println("문자Z의 유니코드 값:"+num2);	//유니코드 값 문자열 출력
		
	}

}
