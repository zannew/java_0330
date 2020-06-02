package manager;

import java.util.List;
import java.util.Scanner;

public class Manager_Main {

	static Scanner sc = new Scanner(System.in);
	
	public static void main(String[] args) throws ClassNotFoundException {
		
		Class.forName("oracle.jdbc.driver.OracleDriver");
		System.out.println("드라이버 로드 완료");

		EmpManager eManager = new EmpManager();
		DeptManager dManager = new DeptManager();
		

//		EMP_INSERT eInsert = EMP_INSERT.getInstance();
//		EMP_UPDATE eUpdate = EMP_UPDATE.getInstance();
//		EMP_DELETE eDelete = EMP_DELETE.getInstance();
//		EMP_SHOWALL eShowAll = EMP_SHOWALL.getInstance();
//		EMP_SEARCH eSearch = EMP_SEARCH.getInstance();
//		DEPT_INSERT dInsert = DEPT_INSERT.getInstance();
//		DEPT_UPDATE dUpdate = DEPT_UPDATE.getInstance();
//		DEPT_DELETE dDelete = DEPT_DELETE.getInstance();
//		DEPT_SHOWALL dShowAll = DEPT_SHOWALL.getInstance();
//		DEPT_SEARCH dSearch = DEPT_SEARCH.getInstance();

		while (true) {

			System.out.println("==========테이블을 선택하세요==========");
			System.out.println("1. 사원테이블 | 2. 부서테이블 | 3. 종료");

			int choice = sc.nextInt();
			sc.nextLine();

			if (choice == 3) {
				System.out.println("프로그램을 종료합니다.");
				System.exit(choice);
			}

				switch (choice) {

				case 1:
					eManager.empManager();
					break;
				case 2:
					dManager.deptManager();
					break;

				

				}

			}
		}

	}

