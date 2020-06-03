package phoneBook_ver_7_2;

import java.util.Scanner;

public class Manager_Main {

	static Scanner sc = new Scanner(System.in);
	
	public static void main(String[] args) throws ClassNotFoundException {
		
		
		Class.forName("oracle.jdbc.driver.OracleDriver");
		System.out.println("DB 드라이버 로드 완료");
		
		Manager_PhoneInfo infoManager = new Manager_PhoneInfo();
		
		
		while(true) {
			System.out.println();
			System.out.println("\t▶ PHONEBOOK ◀");
			System.out.println("\t메뉴를 선택하세요.");
			System.out.println("-------------------------------");
			System.out.println("\t1.친구의 정보 저장");
			System.out.println("\t2.친구의 정보 검색");
			System.out.println("\t3.친구의 정보 삭제");
			System.out.println("\t4.친구의 정보 수정");
			System.out.println("\t5.친구의 정보 보기");
			System.out.println("\t6.프로그램 종료");
			System.out.println("-------------------------------");
			
			int opt = sc.nextInt();
			
			switch(opt) {
			
			case 1:
				infoManager.pbInsert();
				break;
			case 2:
				infoManager.pbSearch();
				break;
			case 3:
				infoManager.pbDelete();
				break;
			case 4:
				infoManager.pbEdit();
				break;
			case 5:
				infoManager.pbShowAll();
				break;
			case 6:
				System.out.println("▶PHONEBOOK 종료◀");
				System.exit(opt);
			
			}
			
			
		}
		
	}
}
