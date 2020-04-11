package algorithm_1;

public class Quiz_4 {
	public static void main(String[] args) {
		
		int a = 11;
		int b = 12;
		int c = a-b;
		
		if(c<0) {
			System.out.println("둘 중 큰 수는 b");
		}else if(c>0){
		System.out.println("둘 중 큰 수는 a");
		}else {
			System.out.println("두 수는 같은 수");
		}
		
	}
}
