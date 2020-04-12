package op;

public class UnaryAddMin {

	public static void main(String[] args) {
		
		int n1 = 5;					//int타입 n1 변수선언과 5로 초기화
		System.out.println(+n1);	//+1곱하기 n1한 값 출력
		System.out.println(-n1);	//-1곱하기 n1한 값 출력	
		
		short n2 = 7;				//short형 변수 n2에 7을 담는다.
		int n3 = +n2;				//n2 곱하기 +1한 값을 n3에 담는다.
		int n4 = -n2;				//n2곱하기 -1한 값을 n4에 담는다.
		
		System.out.println(n3);		//n3을 출력한다. 
		System.out.println(n4);		//n4을 출력한다. 

	}

}
