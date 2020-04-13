package cond_and_loop_1;

public class Quiz_11 {
	public static void main(String[] args) {
		
//		int num=0;
		int count=0;
		
		for (int num=1; num < 100; num++) {
			if(num%5!=0 || num%7!=0) 
				continue;
			count++;
				System.out.println(num);
			
		}System.out.println("count : "+count);
		
		
		
		
//		while((num++)<100){
//			if(num%5!=0 || num%7!=0)
//				continue;
//			count++;
//			System.out.println(num);
//		}
//		System.out.println("count: " + count);
		
		
	}
}
