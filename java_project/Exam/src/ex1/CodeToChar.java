package ex1;

public class CodeToChar {

	public static void main(String[] args) {
		int code =65;	//또는 int code = 0x0041;
		char ch = (char)code;	//명시적형변환
		
		System.out.println(code);	//int타입으로 출력
		System.out.println(ch);		//문자타입으로 출력
		
	}

}

