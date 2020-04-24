package phoneNumBook_ver_4_2;

import java.util.Scanner;

public class PhoneInfoHandler {

	Scanner sc;
	
	PhoneInfo info=null;
	
	
	
	PhoneInfo getInstance(){
		
		System.out.println("이름을 입력하세요");
		info.name=sc.nextLine();
		System.out.println("전화번호를 입력하세요");
		info.phoneNum=sc.nextLine();
		
		return info;
	}
	
	
	
}
