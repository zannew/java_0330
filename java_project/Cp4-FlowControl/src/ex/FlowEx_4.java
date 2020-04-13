package ex;

public class FlowEx_4 {
	public static void main(String[] args) {
		
		int score = 45; 		//변수 score선언하고 45로 초기화
		char grade =' '; 		//변수 grade선언하고 공백으로 초기화
		
		 grade = (score >=90) ? 'A' : ((score >=80) ? 'B' : 'C');	//score의 값이 90보다 크거나 같으면 'A', 아니면 다시 80보다 크거나 같은지 비교
		 //80보다 크거나 같으면 'B', 아니면 'C'를 grade에 저장
		 
		 System.out.println("당신의 학점은 " + grade + "입니다.");
		 //'C'출력
		
		
	}
}
