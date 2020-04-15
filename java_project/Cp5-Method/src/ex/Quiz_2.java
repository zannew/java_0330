package ex;

import java.util.Scanner;

public class Quiz_2 {
	public static void main(String[] args) {
//		두 개의 정수를 전달 받아서, 두수의 절대값을 계산하여 출력하는 메서드와
//		이 메서드를 호출하는 main메서드를 정의해 보자. 단 메서드 호출 시 전달되
//		는 값의 순서에 상관없이 절대값이 계산되어서 출력되어야 한다.
		
		abs(5,-20);
		
	}
	
	static void abs(int a, int b) {
		
		if(a>=0) {
			System.out.println("절대값은 : "+a);
		}else {
			System.out.println("절대값은 : "+(a*-1));
		}

		if(b>=0) {
			System.out.println("절대값은 : "+b);
		}else {
			System.out.println("절대값은 : "+(b*-1));
		}
		
	}
	
	
}
