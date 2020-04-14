package ex;

public class Quiz_1 {
	public static void main(String[] args) {
		
		add(1,4);
		substract(5,3);
		multiply(6,4);
		divide(6,3);
		remain(6,4);
		
	}
	
	static void add(int a, int b) {
		System.out.println(a+"+"+b+"= "+ (a+b));
	}
	static void substract(int a, int b) {
		System.out.println(a+"-"+b+"= "+ (a-b));
	}
	static void multiply(int a, int b) {
		System.out.println(a+"*"+b+"= "+ (a*b));
	}
	static void divide(int a, int b) {
	System.out.println(a+"/"+b+"= "+ (a/b));
	}
	static void remain(int a, int b) {
		System.out.println(a+"%"+b+"= "+ (a%b));
	}
	
}
