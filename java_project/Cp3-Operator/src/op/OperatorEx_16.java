package op;

public class OperatorEx_16 {
	public static void main(String[] args) {
		
		char lowerCase = 'a';		//char타입 변수 lowerCase에 'a'를 저장
		char upperCase = (char)(lowerCase - 32);//char타입 변수 upperCase에 lowerCase-32한 int타입 값을 char로 형변환해서 저장
		System.out.println(upperCase);	//upperCase에 저장된 값 출력
		
		
	}
}
