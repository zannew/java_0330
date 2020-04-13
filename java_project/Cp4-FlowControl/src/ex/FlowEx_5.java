package ex;

public class FlowEx_5 {
	public static void main(String[] args) {
		
		int score = 82;						// int형 score변수 선언과 82로 초기화 
		String grade =""; 					// String형 grade변수 선언과 초기화
		 // 두 문자를 저장할 것이므로 변수의 타입을 String으로 함.
		System.out.println("당신의 점수는 " + score + "입니다.");	//점수 촐력
		if (score >= 90) { 					
		 // score가 90점 보다 같거나 크면 A학점(grade)
			grade = "A";					//grade에 "A"저장
			if ( score >= 98) {
			 // 90점 이상 중에서도 98점 이상은 A+
			grade += "+";// grade = grade + "+";와 같다.
			} else if ( score < 94) {
			grade += "-";
			}
		} else if (score >= 80){ 
			 // score가 80점 보다 같거나 크면 B학점(grade)
			grade = "B";
				if ( score >= 88) {
				grade += "+";
				} else if ( score < 84) {
				grade += "-";
				}
		 } else {
			 // 나머지는 C학점(grade)
			grade = "C";
			 }
			System.out.println("당신의 학점은 " + grade + "입니다.");
		
		
		
	}
}
