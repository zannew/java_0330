package cond_and_loop_2;

public class Quiz_15 {
	public static void main(String[] args) {
		
		
		int number = 12321;
		int tmp = number;
		int result = 0; // 변수 number를 거꾸로 변환해서 담을 변수

		while(tmp !=0) {
			for (int i = 1; i < number; i*=10) {
					
				System.out.println(i);
				result=tmp%(10*i);
				System.out.println(tmp);
				System.out.println(result);
		}
			System.out.println(number);
			
			if(tmp>=number)
				return;
		
			
		if(number == result)
		System.out.println( number + "는 회문수 입니다.");

		else
		System.out.println( number + "는 회문수가 아닙니다.");
		
		
		}
		
	}
}
