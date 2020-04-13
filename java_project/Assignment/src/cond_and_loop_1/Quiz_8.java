package cond_and_loop_1;

public class Quiz_8 {
	public static void main(String[] args) {
		
		int num=1;
		int sum=0;
		
		while(num<=1000) {
			if(num%2==0 && num%7==0) {
				System.out.println(num);
				sum = sum+num;
			}
			num++;
		}
		System.out.println(sum);
		
	}
}
