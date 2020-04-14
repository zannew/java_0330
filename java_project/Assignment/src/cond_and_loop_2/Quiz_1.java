package cond_and_loop_2;

public class Quiz_1 {
public static void main(String[] args) {
	
	 int x=12;

	 if(x>10 && x<20){

	 }
	
//	 char ch = 'a';
//	 if(ch!=' ' || ch!='\t') {
//		 System.out.println(true);
//	 }
	 
//	 char ch = 'x';
//	if(ch=='x' || ch=='X') {
//		System.out.println(true);
//	}else {System.out.println(false);}
	
//	char ch = 'a';
//	if(ch>='0' && ch<='9') {
//		System.out.println(true);
//	}
	 
	char ch = 'f';
	 if(('a'<=ch && ch<='z')||(ch>='A'&&ch<='Z')) {
		 System.out.println(true);
	 }
	 
	 int year=1992;
	 if((year%400==0 || year%4==0) && year%100!=0) {
		 System.out.println(true);
	 }
	 boolean powerOn = false;
	 if (powerOn!=true) {
		 System.out.println(true);
	 }
	 String str = "yes";
	 if (str=="yes") {
		 System.out.println(true);
	 }
	 
	 
	 
}
}
