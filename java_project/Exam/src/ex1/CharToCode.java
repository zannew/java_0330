package ex1;

public class CharToCode {

	public static void main(String[] args) {
		char ch = 'A';	//char ch=\u0041';로 바꿔도 같다
		int code =(int)ch; //ch에 저장된 값을 int형으로 변환해 저장
		
		System.out.println(ch);		//문자타입으로 출력
		System.out.println(code);	//int타입으로 출력
		
		
	}

}

