package cond_and_loop_1;

public class Quiz_12 {
	public static void main(String[] args) {
		
		int num=0;
		int sum=0;
		
		while(true) {
			if(num%2!=0 ||(num%3==0 && num%2==0)) {					//홀수이거나 (3의배수면서 짝수)
				sum=sum+num;
				num++;
			}else {	num++; }
			
			if(sum>1000){
				System.out.println(sum);
				break;
			}
		}
	}
	
}

