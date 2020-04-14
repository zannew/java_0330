package cond_and_loop_2;

public class Quiz_4 {
	public static void main(String[] args) {
		//1+(-2)+3+(-4)+... 과 같은 식으로 계속 더해나갔을 때, 
		//몇까지 더해야 총합이 100이상이되는지 구하시오.
		
		int num = 1;
		int sum = 0;
		int i=0;
		
		while(true) {
			if((num + i)%2==0) {
			sum+=((num+i)*-1);
			}
			else {
				sum+=(num+i);
			}
			System.out.println(i);
			System.out.println(sum);
			i++;
			if(sum>100)
				break;
		}System.out.println(sum);
		
		
		
	}
}
