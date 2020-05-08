package ex;

public class Calculator {

	//더하기,빼기 메서드의 실행 횟수 카운트
	int opCnt=0;
	
	//동기화 메서드 처리시 add();실행 시 min();에 접근하지 못한다.
	int add(int n1, int n2){
		System.out.println("덧셈연산");
		synchronized(this) {
			opCnt++;
		}
		return n1+n2;
	}
	
	int min(int n1, int n2) {
		System.out.println("뺄셈연산");
		synchronized(this) {
			opCnt++;
		}
		return n1-n2;
	}
	
	void showOpCnt() {
		System.out.println("연산의 횟수 : "+opCnt+"번입니다.");
	}
	
	
}
