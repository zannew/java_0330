package ex;

public class AutoBoxingUnBoxtion {

	public static void main(String[] args) {
		
		
		Integer iValue=10;	//new Integer(10) : Auto Unboxing
		Double dValue=3.14;//new double(3.14);
		
		
		System.out.println(iValue.toString());
		System.out.println(dValue.toString());
		
		int num1 = iValue;		//대입연산 ok - Auto unboxing
		double num2 = dValue;	//대입 ok - Auto unboxing
		
		System.out.println(num1);
		System.out.println(num2);
		
		
	}
	
	
}
