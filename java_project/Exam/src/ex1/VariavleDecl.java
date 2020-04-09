package ex1;

public class VariavleDecl {
	public static void main(String[] args) {
		
		double num1;
		double num2;
		double result;
		
		num1 = 1.0000001;
		num2 = 2.0000001;
//		result = num1 + num2;
		result = num1 * num2;
		
		System.out.println(num1);
		System.out.println(num2);
		System.out.println(result);
		
		double num3 = num1 * 10000000;
		double num4 = num2 * 10000000;
		double result1 = num3 + num4;
		System.out.println(num3);
		System.out.println(num4);
		System.out.println(result1/10000000);
		
		
		
		
		
	}
}
