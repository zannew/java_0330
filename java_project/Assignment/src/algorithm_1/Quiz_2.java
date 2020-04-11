package algorithm_1;

public class Quiz_2 {
	public static void main(String[] args) {
		
		int num1;
		int num2;
		int result;
		
		num1 = 18;
		num2 = 9;
		
		result = num1 - num2;
		
		if (result < 0) {
			System.out.println(result*-1);
		}else {
			System.out.println("절대값은? : "+result);
		}
		
	}
}
