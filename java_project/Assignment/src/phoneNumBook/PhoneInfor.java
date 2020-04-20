package phoneNumBook;

import java.util.Scanner;

public class PhoneInfor {


	static String name;
	static String phoneNum;
	static String bDay;
	
	PhoneInfor(){}
	
	PhoneInfor(String name, String number){
		this.name="";
		this.phoneNum="";
	}
	
	
	static void input_Info(){
		Scanner sc = new Scanner(System.in);

		System.out.println("이름 입력 : ");
		name=sc.next();
		System.out.println("전화번호 입력 : ");
		phoneNum=sc.next();
		System.out.println("생일 입력 : ");
		bDay=sc.next();
	}
	

	static void show_Info() {
		System.out.println("이름 : "+name+", 전화번호 : "+phoneNum+", 생일 :"+bDay);
		
	}
	
	
	public static void main(String[] args) {
		 
		PhoneInfor info = new PhoneInfor();
		
		while(true) {
		info.input_Info();
		info.show_Info();
		}
		
	}
	
	
}
