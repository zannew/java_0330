package algorithm_1;

public class Quiz_10 {
	public static void main(String[] args) {
		int a = 1;
		int sum = 0;
		
		for (int i = 0; i < 10; i++) {
			if((a+i)%2==0) {
				sum = sum + (a+i)*-1;
			}else {
				sum = sum + (a+i);
			}
		}System.out.println(sum);
		
	}
}
