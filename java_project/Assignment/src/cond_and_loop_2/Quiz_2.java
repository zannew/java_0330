package cond_and_loop_2;

public class Quiz_2 {
	public static void main(String[] args) {
		
		int sum = 0;
		
		for (int i = 0; i <= 20; i++) {
			if(i%2==0 && i%3==0) {
				
			}else {
				sum= sum+i;
			}
		}System.out.println(sum);
	}
}
