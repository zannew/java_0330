package ex;

public class Number {

	 int num;
	 
	 //생성자(default)
//	 Number(){
//		 System.out.println("생성자 호출");
//		 num=1000;
//	 }
	
	 Number(int n){
		 System.out.println("생성자 호출");
		 num=n;
	 }
	 
	 
	 
	//반환타입과 메서드 이름은 순서를 지켜야한다.
	 public static void main(String[] args) {
		 
		Number n1 = new Number(100000);
		
		System.out.println(n1.num);
		
//		 new Number();
	 }
	
}
