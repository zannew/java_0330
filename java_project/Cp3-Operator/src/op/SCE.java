package op;

public class SCE {
	public static void main(String[] args) {
		
		int num1=0, num2=0;									//int타입 num1,num2 선언하고 둘 다 0으로 초기화
		boolean result;										//boolean타입 변수 result선언, false로 자동 초기화
		
		result = (num1+=10)<0 && (num2+=10)>0;				//(num1에 10을 더한 값이 0보다 작다)와(num2에 10을 더한 값이 0보다 크다)는 앞에서부터 거짓이므로 result에 false가 담긴다
		
		System.out.println("result="+result);				//result는 false
		System.out.println("num1="+num1+", num2="+num2);	//num1은 10, num2는 0, SCE규칙으로 첫 연산이 거짓이라면 &&연산의 조건이 false로 결정되므로 남은 연산은 하지 않는다.
		
		result = (num1+=10)>0 || (num2+=10)>0;				//(num1에 10을 더한 값이 0보다 크다)와(num2에 10을 더한 값이 0보다 크다)는 앞에서부터 거짓이므로 result에 false가 담긴다
		
		System.out.println("result="+result);				//result는 false
		System.out.println("num1="+num1+", num2="+num2);	//num1은 10, num2는 0, SCE규칙으로 첫 연산이 참이라면 ||연산의 조건이 참으로 결정 되므로 남은 연산은 하지 않는다.
		
	}
}
