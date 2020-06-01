package assignment;

/*
 * 		 입력(전체컬럼), 
	      수정(이름, 부서번호, 급여), 
	      삭제(사원번호), 
	      리스트(전체), 
	      검색(이름)*/
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class CRUD_MANAGER_EMPandDEPT {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		EMP_INSERT eInsert = EMP_INSERT.getInstance();
		EMP_UPDATE eUpdate = EMP_UPDATE.getInstance();
		EMP_DELETE eDelete = EMP_DELETE.getInstance();
		EMP_SHOWALL eShowAll = EMP_SHOWALL.getInstance();
		EMP_SEARCH eSearch = EMP_SEARCH.getInstance();
		DEPT_INSERT dInsert = DEPT_INSERT.getInstance();
		DEPT_UPDATE dUpdate = DEPT_UPDATE.getInstance();
		DEPT_DELETE dDelete = DEPT_DELETE.getInstance();
		DEPT_SHOWALL dShowAll = DEPT_SHOWALL.getInstance();
		DEPT_SEARCH dSearch = DEPT_SEARCH.getInstance();

		while (true) {

			System.out.println("=====테이블을 선택하세요=====");
			System.out.println("1. 사원테이블 | 2. 부서테이블 | 3. 종료");

			int choice = sc.nextInt();
			sc.nextLine();
			
			if(choice==3) {
				System.out.println("프로그램을 종료합니다.");
				System.exit(choice);
			}

			System.out.println("메뉴를 선택하세요.");
			System.out.println("1.입력 | 2.수정 | 3.삭제 | 4.리스트보기 | 5.검색 | 6.뒤로가기");

			int opt = sc.nextInt();
			sc.nextLine();

			switch (choice) {

			case 1:

				// 사원테이블
				switch (opt) {
				case 1:
					eInsert.emp_insert();
					break;
				case 2:
					eUpdate.emp_update();
					break;
				case 3:
					eDelete.emp_delete();
					break;
				case 4:
					eShowAll.emp_showAll();
					break;
				case 5:
					eSearch.emp_search();
					break;
				case 6:
					continue;
				}

				break;

			case 2:

				// 사원테이블
				switch (opt) {
				case 1:
					dInsert.dept_insert();
					break;
				case 2:
					dUpdate.dept_update();
					break;
				case 3:
					dDelete.dept_delete();
					break;
				case 4:
					dShowAll.dept_showAll();
					break;
				case 5:
					dSearch.dept_search();
					break;
				case 6:
					continue;
				}

				break;

				
			}

		}

	}
}
