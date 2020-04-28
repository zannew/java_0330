package ex;

import java.util.Scanner;

public class ExceptionEx {

	public static void main(String[] args) {

	
		try {
			int age = readAge();
			System.out.println("나이는 "+age+"세 입니다.");
			
		}catch(AgeInputException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
//		catch(Exception e) {
//			System.out.println("에러메시지 : "+e.getMessage());
//			e.printStackTrace();
//		}
		System.out.println("프로그램이 정상 종료되었습니다.");
	}
	//예외클래스는 Throwable의 하위클래스인 Exception클래스를 상속해서 정의
	static int readAge() throws AgeInputException {
		
		Scanner kb = new Scanner(System.in);
		
		System.out.println("나이를 입력해주세요.");
		int age=kb.nextInt();
		
		if(age<0) {
//		Exception e = new Exception("고의로 발생시킴");
		AgeInputException e = new AgeInputException();
			throw e;	//강제적 예외 발생 지점 - 예외타입의 참조값을 던진다.JVM이 받아서 catch로 전달
		}
		return age;
	}
	
	}	
