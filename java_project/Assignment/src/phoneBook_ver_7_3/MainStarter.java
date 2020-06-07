package phoneBook_ver_7_3;

import java.sql.SQLException;
import java.util.Scanner;

public class MainStarter {

	public static void main(String[] args) throws SQLException {

		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("DB 드라이버 로드 완료");
			
			Scanner sc = new Scanner(System.in);
			
			AllDTO allDto = new AllDTO();
			BasicDTO bDto = new BasicDTO();
			UnivDTO uDto = new UnivDTO();
			ComDTO cDto = new ComDTO();
			
			Manager_PB pManager = new Manager_PB();
			
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
					pManager.pbInsert();
					break;
				case 2:
					pManager.pbSearch();
					break;
				case 3:
					pManager.pbDelete();
					break;
				case 4:
					pManager.pbEdit();
					break;
				case 5:
					pManager.showInfo();
					break;
				case 6:
					System.out.println("▶PHONEBOOK 종료◀");
					System.exit(opt);
				
				}
				
				
			}
			
			
		} catch (ClassNotFoundException e) {
			System.out.println("드라이버 로드 실패/n▶프로그램을 종료합니다.");
			e.printStackTrace();
		}
		
	}

}
