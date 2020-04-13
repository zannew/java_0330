package op;

public class OperatorEx_13 {
	public static void main(String[] args) {
		
		char c1 = 'a'; // c1에는 문자 'a'의 코드 값인 97이 저장된다.
		char c2 = c1; // c1에 저장되어 있는 값이 c2에 저장된다.
		char c3 =' '; // c3를 공백으로 초기화 한다.
		int i = c1 + 1; // 'a'+1 → 97+1 → 98
		c3 = (char)(c1 + 1);	//c1의 값에 1을 더하고 char타입으로 변환
		c2++;					//1 증가시킴
		c2++;					//1 증가시킴
		System.out.println("i=" + i);	//int타입 i를 출력 : 98
		System.out.println("c2=" + c2);	//char타입 c2를 출력 : 'c'
		System.out.println("c3=" + c3);	//char타입 c3를 출력 : 'b'
		
	}
}
