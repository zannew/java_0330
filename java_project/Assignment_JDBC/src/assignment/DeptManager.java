package assignment;

import java.util.List;
import java.util.Scanner;

public class DeptManager {
	DEPTDao dDao;
	Scanner sc;
	int opt;
	
	public DeptManager() {
		dDao = new DEPTDao();
		sc = new Scanner(System.in);
		
	}

	public void deptManager() {

		System.out.println("메뉴를 선택하세요.");
		System.out.println("1.입력 | 2.수정 | 3.삭제 | 4.리스트보기 | 5.검색 | 6.뒤로가기");
		
		opt=sc.nextInt();
		sc.nextLine();
		
		switch (opt) {
		case 1:
//		dDao.dept_insert();
			break;
		case 2:
//		dUpdate.dept_update();
			break;
		case 3:
//		dDelete.dept_delete();
			break;
		case 4:
			deptList();
			break;
		case 5:
//		dSearch.dept_search();
			break;

		}

	}


	public void deptList() {

		List<Dept> deptList = dDao.dept_showAll();

		if (deptList != null && deptList.isEmpty()) {
			for (int i = 0; i < deptList.size(); i++) {
				System.out.printf("%5s", deptList.get(i).getDeptno() + "\t");
				System.out.printf("%12s", deptList.get(i).getDname() + "\t");
				System.out.printf("%12s", deptList.get(i).getLoc() + "\n");

			}

		} else {
			System.out.println("입력된 데이터가 없음");
		}

	}

}
