package phoneNumBook_ver_4_1;

import java.util.Scanner;

public class AppStarter {
	
	

	public static void main(String[] args) {
		
	Scanner sc = new Scanner(System.in);
	//PhonebookMain 객체 생성 및 매개변수 입력
	PhonebookMain main = new PhonebookMain(100);

	
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
			
			
			int selectOpt=sc.nextInt();
			int selectOpt2;
		
			switch(selectOpt) {
			
				//정보 입력 선택 시 분기 (기본정보, 대학친구, 직장친구, 동호회친구)
				case 1:
					System.out.println("어떤 친구의 정보를 저장하시겠습니까?");
					System.out.println("1.일반 정보");
					System.out.println("2.대학교");
					System.out.println("3.직장");
					System.out.println("4.동호회");
					selectOpt2=sc.nextInt();
					//1.기본 정보 저장 및 객체 생성
					if(selectOpt2==1) {
						main.storeInst(main.createInst(selectOpt2));
					//2.대학교 친구 정보 저장 및 객체 생성
					}else if(selectOpt2==2) {
						main.storeInst(main.createInst(selectOpt2));
					//3.직장 친구 정보 저장 및 객체 생성
					}else if(selectOpt2==3) {
						main.storeInst(main.createInst(selectOpt2));
					//4.동호회 친구 정보 저장 및 객체 생성
					}else if(selectOpt2==4) {
						main.storeInst(main.createInst(selectOpt2));
					}
				
				break;
				//이름으로 정보 검색
				case 2:
					main.searchName();
					break;
				//이름 검색으로 정보 삭제
				case 3:
					main.deleteName();
					break;
				//저장된 정보 전부 출력
				case 4:
					main.showAllInfo();
					break;
				//프로그램 종료
				case 5:
					System.out.println("프로그램을 종료합니다.");
					return;
				
			}	
		}
	}
	
}
