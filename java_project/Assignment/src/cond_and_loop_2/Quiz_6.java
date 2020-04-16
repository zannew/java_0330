package cond_and_loop_2;

public class Quiz_6 {
	public static void main(String[] args) {
	//두 개의 주사위를 던졌을 때, 눈의 합이 6이 되는 모든 경우의 수를 출력하는 프로그램을작성하시오.
		
		int sum = 0;
		
		for(int dice_1=1;dice_1<=6;dice_1++) {
			for(int dice_2=1;dice_2<=6;dice_2++) {
				sum = dice_1+dice_2;
				if(sum==6) {
					System.out.println("첫번째 주사위 "+dice_1+"과 두번째 주사위"+dice_2+"의 합은 6");
				}
			}
		}
		
	}
}
