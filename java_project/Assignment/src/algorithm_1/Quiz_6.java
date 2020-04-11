package algorithm_1;

import java.util.Scanner;

public class Quiz_6 {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);

		int result = 0;
		int before_num;
		int now_num = 0;
		int max = 0;
		
		for(int i=1; i <=5; i++) {
			System.out.println("숫자를 입력하세요. : ");
			now_num = sc.nextInt();
			
			if (max < now_num) {
				max = now_num;
			}else {
				before_num = now_num;
		}
		System.out.println("최대값은? : "+max);
		}
	}
}