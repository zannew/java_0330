package phoneNumBook_ver_5_1;

import java.util.Scanner;

public class AppStarter {
	
	public static Scanner sc = new Scanner(System.in);
	
	public static Scanner getInstance() {
		return sc;
	}
	
	public static void main(String[] args) {
		
	//PhonebookMain 객체 생성 및 매개변수 입력
	PhonebookManager main = new PhonebookManager(100);
	
	
		while(true) {
	
			System.out.println("★★친구목록 만들기입니다.★★");
			System.out.println("번호를 선택하세요>>");
			System.out.println("----------------");
			System.out.println(Menu.INSERT_INFO+". 친구의 정보 저장");
			System.out.println(Menu.SEARCH_INFO+". 친구의 정보 검색");
			System.out.println(Menu.DELETE_INFO+". 친구의 정보 삭제");
			System.out.println(Menu.EDIT_INFO+". 친구의 정보 수정");
			System.out.println(Menu.SHOW_ALLINFO+". 친구의 정보 모두 보기");
			System.out.println(Menu.EXIT+". 목록 만들기 종료");
			System.out.println("----------------");
			
			
			int selectOpt=sc.nextInt();
			sc.nextLine();
			int selectOpt2;
		
			
			switch(selectOpt) {
			
				//정보 입력 선택 시 분기 (기본정보, 대학친구, 직장친구, 동호회친구)
				case Menu.INSERT_INFO:
					System.out.println("어떤 친구의 정보를 저장하시겠습니까?");
					System.out.println(Menu.INSERT_BASIC+".일반 정보");
					System.out.println(Menu.INSERT_UNIV+".대학교");
					System.out.println(Menu.INSERT_COMPANY+".직장");
					System.out.println(Menu.INSERT_SOCIETY+".동호회");
					selectOpt2=sc.nextInt();
					sc.nextLine();
					//1.기본 정보 저장 및 객체 생성
					if(selectOpt2==Menu.INSERT_BASIC) {
//						main.storeInst(main.createInst(selectOpt2));
						System.out.println("현재 기본정보만 입력하실 수 없습니다.");
						break;
					//2.대학교 친구 정보 저장 및 객체 생성
					}else if(selectOpt2==Menu.INSERT_UNIV) {
						main.storeInst(main.createInst(selectOpt2));
					//3.직장 친구 정보 저장 및 객체 생성
					}else if(selectOpt2==Menu.INSERT_COMPANY) {
						main.storeInst(main.createInst(selectOpt2));
					//4.동호회 친구 정보 저장 및 객체 생성
					}else if(selectOpt2==Menu.INSERT_SOCIETY) {
						main.storeInst(main.createInst(selectOpt2));
					}
				
				break;
				//이름으로 정보 검색
				case Menu.SEARCH_INFO:
					main.searchName();
					break;
				//이름 검색으로 정보 삭제
				case Menu.DELETE_INFO:
					main.deleteName();
					break;
				case Menu.EDIT_INFO:
					main.editInfo();
					break;
				//저장된 정보 전부 출력
				case Menu.SHOW_ALLINFO:
					main.showAllInfo();
					break;
				//프로그램 종료
				case Menu.EXIT:
					System.out.println("프로그램을 종료합니다.");
					return;
			}	
		}
	}
}
