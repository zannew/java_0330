package cond_and_loop_2;

public class Quiz_10 {
	public static void main(String[] args) {
		
//int타입의 변수 num 이 있을 때, 각 자리의 합을 더한 결과를 출력하는 코드를 완성하라. 
//만일 변수 num의 값이 12345라면, ‘1+2+3+4+5’의 결과인 15를 출력하라. (1)에 알맞은 코드를넣으시오.
//[주의] 문자열로 변환하지 말고 숫자로만 처리해야 한다.
		int num = 12345;
		int sum = 0;
		
		while(true) {			//new
			sum+=num%10;
			num=num/10;
			
			if(num==0)
				break;
				
			
		}
		
//		while(true) {			//old
//			if(num%10==0) {
//				sum+=num%100;
//			}
//			sum += num%10;
//		System.out.println(sum);
//			num = num/10;
//			if(num==0)
//				break;
//		}
		System.out.println("sum="+sum);
		
	}
}
