package ex;

public class FlowEx_2 {
	public static void main(String[] args) {
		
		int visitCount = 5; 				//visitCount를 선언 후 5로 초기화
		
		 if (visitCount < 1) { // 5 < 1의 연산결과는 false. 
		 System.out.println("처음 오셨군요. 방문해 주셔서 감사합니다.") ; 
		 } else { 				//visitCount이 1보다 작지 않다면
		 System.out.println("다시 방문해 주셔서 감사합니다.") ; 
		 } 
		 System.out.println("방문횟수는 " + ++visitCount + "번 입니다.");
		 //visitCount에 저장된 값을 출력
		 
		
	}
}
