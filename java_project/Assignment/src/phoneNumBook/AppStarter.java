package phoneNumBook;

import java.util.Scanner;

public class AppStarter {

	public static void main(String[] args) {
		
	
	PhonebookMain main = new PhonebookMain();
	
	
	
	while(true) {
	
		System.out.println("★★친구목록 만들기입니다.★★");
		System.out.println("번호를 선택하세요>>");
		System.out.println("----------------");
		System.out.println("1. 친구의 정보 저장");
		System.out.println("2. 친구의 정보 검색");
		System.out.println("3. 친구의 정보 삭제");
		System.out.println("4. 친구의 정보 모두 보기");
		System.out.println("5. 목록 만들기 종료");
		System.out.println("----------------");
		
		
		Scanner sc = new Scanner(System.in);
		
		int selectOpt=sc.nextInt();
		
		switch(selectOpt) {
		
		case 1:
			main.storeInst(main.createInst());
			break;
		case 2:
			main.searchName();
			break;
		case 3:
			main.deleteName();
			break;
		case 4:
			main.showAllInfo();
			break;
		case 5:
			return;
		
		}	
	
	}
	
	
	}
	
}
