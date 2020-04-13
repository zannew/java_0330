package cond_and_loop_1;

public class Quiz_16_DoWhile {
	public static void main(String[] args) {
		
		int i=1;
		int sum = 0;
		
		do {
			sum=sum+i;
			i++;
		}
		while(i<100); 
			
		System.out.println("1부터 99까지의 합 : "+sum);
		
		
	}
}
