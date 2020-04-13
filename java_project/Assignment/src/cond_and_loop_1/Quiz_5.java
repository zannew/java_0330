package cond_and_loop_1;

public class Quiz_5 {
	public static void main(String[] args) {
		
		int num = 100;
		
		if(num<0) {
			System.out.println("0 미만");
		}
		switch(num/100) {
		case 0:
			System.out.println("0이상 100 미만");
			break;
		case 1:
			System.out.println("100이상 200 미만");
			break;
		case 2:
			System.out.println("200이상 300 미만");
			break;
		default:
			System.out.println("300이상");
			break;
		}
		
	}
}
