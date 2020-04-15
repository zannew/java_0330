package cond_and_loop_2;

import java.util.Scanner;

public class Quiz_5_Test {
	public static void main(String[] args) {
	
//		for(int i=0; i<=10;i++) {
//			for(int j=0; j<=i;j++) 
//				System.out.print("*");
//			System.out.println();
//		}
	
		int line_num;
		
		Scanner input = new Scanner(System.in);
		
		while(true) {
		System.out.println("숫자를 입력 : ");
		line_num = input.nextInt();
		
		if(!(line_num>0)) {
			System.out.println("다시 입력해주세요");
		}else {
			break;
		}
		
		}
		
		int i=0;
		int j;
		
		while(i<=line_num) {
			j=0;
			while(j<=i) {
				System.out.print("*");
				j++;
			}
			System.out.println();
			i++;
		}
		
		
		
	
		
}
}
