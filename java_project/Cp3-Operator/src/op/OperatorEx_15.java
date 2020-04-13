package op;

public class OperatorEx_15 {
	public static void main(String[] args) {
		
		char c = 'a';			//char타입 변수c 선언하고 'a'로 초기화
		for(int i=0; i<26; i++) { // 블럭{} 안의 문장을 26번을 반복한다.
		System.out.print(c++); //'a'부터 26개의 문자를 출력한다.
		}
		System.out.println(); // 줄 바꿈을 한다.
		c = 'A';				//변수 c에 'A'를 저장
		for(int i=0; i<26; i++) { // 블럭{} 안의 문장을 26번을 반복한다.
		System.out.print(c++); //'A'부터 26개의 문자를 출력한다.
		}
		System.out.println();	//줄 바꿈
		c='0';					//변수 c에 '0'을 저장
		for(int i=0; i<10; i++) {
		// 블럭{} 안의 문장을 10번을 반복한다.
		System.out.print(c++); //'0'부터 10개의 문자를 출력한다.
		}
		System.out.println();	//줄 바꿈
		
	}
}
