package cond_and_loop_1;

public class Quiz_2 {
	public static void main(String[] args) {
		
		int num = 100;
		
		if(num<0) {
			System.out.println("0 미만");
		}else if(num<100) {
			System.out.println("0이상 100 미만");
		}else if(num<200) {
			System.out.println("100이상 200 미만");
		}else if(num<300) {
			System.out.println("200이상 300 미만");
		}else {
			System.out.println("300이상");
		}
		
	}
}
