package cond_and_loop_1;

public class Quiz_15 {
	public static void main(String[] args) {

		
		int n = 13;
		
		if(n==1) {
			System.out.println("현재 인원은 1명 입니다.");
		}else if(n==2) {
			System.out.println("현재 인원은 2명 입니다.");
		}else if(n==3) {
			System.out.println("현재 인원은 3명 입니다.");
		}else {
			System.out.println("현재 많은 사람들이 있습니다.");
		}
		
		switch(n) {
		case 1:
			System.out.println("현재 인원은 1명 입니다.");
			break;
		case 2:
			System.out.println("현재 인원은 2명 입니다.");
			break;
		case 3:
			System.out.println("현재 인원은 3명 입니다.");
			break;
		default:
			System.out.println("현재 많은 사람들이 있습니다.");
			break;
		}
		
		
		
		
		
		
	}
	
}
