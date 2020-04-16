package ex;

public class Quiz_4 {

//	전달되는 값이 소수(prime number)인지 아닌지를 판단하여, 소수인경우
//	true를, 소수가 아닌 경우 false를 반환하는 메서드를 정의하고, 이를 이용해
//	서 1이상 100 이하의 소수를 전부 출력할 수 있도록 main 메서드를 정의하
//	자.

	
	public static void main(String[] args) {
		
		prime_number(6);
		
		
	}
	
	static void prime_number(int num) {
		
		boolean result = false;
		
		if(num<=1) {
			System.out.println(result);
		
		for (int i=2; i < num ; i++) {
			if(num%i==0) {
				System.out.println(result);

			}else {
				result=true;
				System.out.println(result);

			}
		}
		}
//		System.out.println(result);
		
		
		
		
		
		
//		if(num%2==0) {
//			result = false;
//			System.out.println(result);
//
//		}else if(num%3==0) {
//			result = false;
//			System.out.println(result);
//			
//		}else if(num%5==0) {
//			result = false;
//			System.out.println(result);
//			
//		}else if(num%7==0){
//			result = false;
//			System.out.println(result);
//			
//		}else {
//			result = true;
//			System.out.println(result);
//
//		}
//	}
	
//	static void print_prime() {
//		
//		
//		for (int i=1; i<=100; i++) {
//			
//			
//		}
//	}
	
	
	}
	
	
	
}
