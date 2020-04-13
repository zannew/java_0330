package cond_and_loop_1;

public class Quiz_12 {
	public static void main(String[] args) {
		
		int num1=0;
		int num2=0;
		int sum=0;
		
		while(true) {
			if(num1%2!=0) {					//홀수
				sum=sum+num1;
				num1++;
			}else if(num1%3==0 && num1%2==0) {	//3의 배수면서 짝수
				sum=sum+num1;
				num1++;
			}
			
			if(sum>1000){
				System.out.println(sum);
				break;
			}
		
		
		
		
		}
		
	}
}
