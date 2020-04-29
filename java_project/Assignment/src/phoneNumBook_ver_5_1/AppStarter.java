package phoneNumBook_ver_5_1;

import java.util.InputMismatchException;
import java.util.Scanner;

import phoneNumBook_ver_5_1_exception.BadNumException;

public class AppStarter {
	
	
	public static Scanner sc = new Scanner(System.in);
	
	private static BadNumException e = new  BadNumException("잘못된 메뉴 선택입니다.");

	
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
			
			
			int selectOpt=0;
			
			//예외처리 1
			try {
				//입력 시 예외 발생 가능성있는 문장
				selectOpt = sc.nextInt();
				//if문 - 입력받은 숫자 예외 처리, BadNumException객체 생성하고 오류메시지 입력
				if(!(selectOpt>=Menu.INSERT_INFO && selectOpt<=Menu.EXIT)) {
					throw e;
				}
			//전달받은 e로 예외타입 체크
			}catch(InputMismatchException e) {
				System.out.println("잘못된 메뉴 입력입니다.\n다시 입력해주세요.");
				continue;
			}catch(BadNumException e) {
				System.out.println(e.getMessage());
				continue;
			}catch(Exception e) {
				System.out.println("잘못된 메뉴 입력입니다.\n다시 입력해주세요.");
				continue;
			}finally {
				sc.nextLine();
			}
			
		
			switch(selectOpt) {
			
				//정보 입력 선택 시 분기 (대학교 친구, 직장 친구, 동호회 친구)
				case Menu.INSERT_INFO:
					
					System.out.println("어떤 친구의 정보를 저장하시겠습니까?");
					System.out.println(Menu.INSERT_UNIV+".대학교");
					System.out.println(Menu.INSERT_COMPANY+".직장");
					System.out.println(Menu.INSERT_SOCIETY+".동호회");
					
					int selectOpt2=0;
					
					//예외 처리 2
					try {
						selectOpt2=sc.nextInt();

						if(!(1<=selectOpt2 && selectOpt2<=3)) {
//							BadNumException e = new  BadNumException("잘못된 메뉴 선택입니다.");
							throw e;
						}
					}catch(InputMismatchException e) {
						System.out.println("잘못된 메뉴 입력입니다.\n다시 입력해주세요.");
						continue;
					}catch(BadNumException e) {
						System.out.println(e.getMessage());
						continue;
					}catch(Exception e) {
						System.out.println("잘못된 메뉴 입력입니다.\n다시 입력해주세요.");
						continue;
					}finally {
						sc.nextLine();
					}
					
			//1.대학교 친구 정보 저장 및 객체 생성
			if(selectOpt2==Menu.INSERT_UNIV) {
				main.storeInst(main.createInst(selectOpt2));
			//2.직장 친구 정보 저장 및 객체 생성
			}else if(selectOpt2==Menu.INSERT_COMPANY) {
				main.storeInst(main.createInst(selectOpt2));
			//3.동호회 친구 정보 저장 및 객체 생성
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
