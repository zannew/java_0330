package cond_and_loop_2;

public class Quiz_5 {
	public static void main(String[] args) {
		
// while로 바꾸기
		
//	for(int i=0; i<=10;i++)
//		for(int j=0; j<=i;j++)
//			System.out.println("*");
//		System.out.println();
	
		int i=0;
		int j;
		
		while(i<=10)	{
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
