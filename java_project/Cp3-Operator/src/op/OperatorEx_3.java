package op;

public class OperatorEx_3 {
	public static void main(String[] args) {
		
		int i=5, j=5;					//int타입 변수 i와 j를 선언하고 둘다 5로 값을 초기화
		System.out.println(i++);		//i의 현재 값을 출력(5)한 후에 값을 1 증가 시킨다.
		System.out.println(++j);		//j의 값을 먼저 증가시킨 후 현재의 값을 출력
		System.out.println("i = " + i + ", j = " +j);	// i와 j 모두 현재는 1 증가한 상태
	}
	
	
}
