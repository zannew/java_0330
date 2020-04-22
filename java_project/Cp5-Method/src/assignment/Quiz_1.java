package assignment;

public class Quiz_1 {
	public static void main(String[] args) {
/*주석 : 문제풀이*/		
		//calc(10,20);
		
		add(1,4);
		substract(5,3);
		multiply(6,4);
		divide(6,3);
		remain(6,4);
		
	}
	
//	static void calc(int a, int b) {
//		  int add = a+b;
//		  int min = a-b;
//		  int mul = a*b;
//		  int div = a/b;
//		  int rem = a%b;

//	  System.out.println(a+"+"+b+"="+add);
//	  System.out.println(a+"-"+b+"="+min);
//	  System.out.println(a+"x"+b+"="+mul);
//	  System.out.println(a+"/"+b+"="+"몫:"+div+"나머지:"+rem);
	
	
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
