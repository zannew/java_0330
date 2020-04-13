package ex;

public class CondToIE {
	public static void main(String[] args) {
	
	int num1=50;
	int num2=100;
	int big,diff;
	
	if(num1>num2) {
		big=num1;
	}else {
		big=num2;
	}
	
	if(num1>num2) {
		diff = num1-num2;
	}else {
		diff = num2-num1;
	}
		System.out.println("둘 중 큰 수는? : "+big);
		System.out.println("두 수의 차이는? : "+diff);
	}
}
