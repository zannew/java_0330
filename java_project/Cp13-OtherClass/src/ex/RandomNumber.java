package ex;

import java.util.Random;

public class RandomNumber {
	public static void main(String[] args) {
		
		Random rand = new Random(1);
		
		for(int i=0;i<20;i++) {
//			System.out.println(rand.nextBoolean());
			System.out.println(rand.nextInt(45)+1);
//			System.out.println(rand.nextDouble());
			System.out.println("----------------------");
			
			
		}
		
		
		
		
	}
}
