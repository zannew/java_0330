package ex;

import java.util.StringTokenizer;

public class TokenTest {
	public static void main(String[] args) {
		
		String phoneNumber = "Tel 82-02-123-12.3.4";
		//생성자에 구분자를 따로 넣지 않으면 공백으로 구분한다.
		StringTokenizer st1 = new StringTokenizer(phoneNumber, "-.");
		while(st1.hasMoreTokens()) {
			
			System.out.println(st1.nextToken());
			
		}
		
		System.out.println("-------------------------");
		
		StringTokenizer st2 = new StringTokenizer(phoneNumber);
		
		while(st2.hasMoreTokens()) {
			System.out.println(st2.nextToken());
		}
		
		
	}
}
