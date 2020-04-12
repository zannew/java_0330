package op;

public class OperatorEx_1 {
	public static void main(String[] args) {
		
		
		int i=5;	//int타입 변수i를 선언하고 5로 초기화
		i++;
		 // i=i+1;과 같은 의미이다. ++i;로 바꿔 써도 결과는 같다.
		System.out.println(i);		//i의 현재 값을 출력 : 6
		i=5; 						//다시 i를 5로 초기화
		 // 결과를 비교하기 위해 i값을 다시 5로 변경.
		++i;						//i의 값을 1 증가시킨다.
		System.out.println(i);		//i의 현재 값을 출력 : 6
		
	}
}
