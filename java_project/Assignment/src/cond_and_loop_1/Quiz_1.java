package cond_and_loop_1;

public class Quiz_1 {
	public static void main(String[] args) {
		
		int num=120;
		
		if(num<0) {
			System.out.println("음수");
		}else if(num%2==0) {
			System.out.println("양수이면서 짝수");
		}else {
			System.out.println("양수이면서 홀수");
		}

//		if(num>0&&(num%2)==0) {
//			System.out.println("양수이면서 짝수");
//		}
		
	}
}
