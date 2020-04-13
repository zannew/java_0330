package operator_2;

public class Quiz_1{
	public static void main(String[] args) {
		
        int x = 2;
		int y = 5;
		char c = 'A'; // 'A'의문자코드는 65
		
		System.out.println(y+= 10 - x++);   //y초기값 5에 10을 더한 값에서 x의 현재 값인 2를 뺀다. 그리고 x는 1증가 = 3
//		대입연산 규칙에 따라 괄호안의 연산 먼저 이뤄지고 대입연산.
//		System.out.println(y+= (10 - x++));
		System.out.println(x+=2);    		//1증가한 x값 3에 2를 더한 값
		System.out.println(!('A' <= c && c <='Z') );
		//1.'A'의 문자코드 값이 c의 값과 같고, 2.c의 값이 'Z'의 문자코드 값보다 작거나 같을 경우
		//1과 2의 결과 값을 부정(true의 부정이므로 false출력)
		System.out.println('C'-c);    		//'C'의 문자코드값 67에서 c의 'A'문자코드값 65를 뺀다. 
		System.out.println('5'-'0');    	//'5'의 문자코드값 53에서 '0'의 문자코드값 48을 뺀다.
		System.out.println(c+1);    		//c의 값 65에 1을 더한다.
		System.out.println(++c);    		//'A'문자코드값에서 1 증가하지만 char타입의 변화가 없다. 
		System.out.println(c++);    		//직전의 c의 값을 그대로 출력하고 1 증가시킨다.
		System.out.println(c);     			//이전에 증가한 c의 값을 출력
		
	}
	
	
}
