package algorithm_1;

public class Quiz_9 {
	public static void main(String[] args) {
		int a = 1;
		int b = 11;
		int sum = 0;
		
//		if(a%3 == 0) {
//			sum = a;
//		}else {
			for (int i = 0; a+i <= b; i++) {
				if((a+i)%3==0) {
					sum = sum+(a+i);
				}
			} 
		System.out.println(sum);
		
	}
}
