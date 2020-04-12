package op;

public class OperatorEx_4 {
	public static void main(String[] args) {
		
		int i = -10;			//int타입 변수 i를 선언하고 -10으로 초기화
		i = +i;					//i의 현재 값(-10)에 양수 1을 곱해준 값을 다시 i에 저장				
		System.out.println(i);	//현재 i의 값을 출력 : -10
		i=-10;					//i를 -10으로 다시 초기화
		i = -i;					//i의 현재 값(-10)에 음수 -1을 곱해준 값을 다시 i에 저장
		System.out.println(i);	//현재 i의 값을 출력 : 10
		
		
	}
}
