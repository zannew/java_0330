package assignment;

import java.util.List;
/*
 * 		 입력(전체컬럼), 
	      수정(이름, 부서번호, 급여), 
	      삭제(사원번호), 
	      리스트(전체), 
	      검색(이름)*/
import java.util.Scanner;

public class CRUD_MANAGER {

	
	public static void main(String[] args) throws ClassNotFoundException {
		DEPTDao dDao = new DEPTDao();
		DeptManager dManager = new DeptManager();

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("드라이버 로드 완료");
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		Scanner sc = new Scanner(System.in);

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

					// 사원테이블
//					switch (opt) {
//					case 1:
//						eInsert.emp_insert();
//						continue;
//					case 2:
//						eUpdate.emp_update();
//						continue;
//					case 3:
//						eDelete.emp_delete();
//						continue;
//					case 4:
//						eShowAll.emp_showAll();
//						continue;
//					case 5:
//						eSearch.emp_search();
//						continue;
//
//					}

					break;

				case 2:
					dManager.deptManager();//남을 애
					break;

				

				}

			}
		}

	}

