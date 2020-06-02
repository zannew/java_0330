package manager;

import java.util.List;

public class EmpManager {

	EmpDao eDao;
	int opt;

	public EmpManager() {
		eDao = new EmpDao();
	}

	public void empManager() {

		System.out.println("메뉴를 선택하세요.");
		System.out.println("1.입력 | 2.수정 | 3.삭제 | 4.리스트보기 | 5.검색 | 6.뒤로가기");

		opt = Manager_Main.sc.nextInt();
		Manager_Main.sc.nextLine();

		// 사원테이블
		switch (opt) {
		case 1:
//			eInsert.emp_insert();
			break;
		case 2:
//			eUpdate.emp_update();
			break;
		case 3:
//			eDelete.emp_delete();
			break;
		case 4:
			empList();
			break;
		case 5:
//			eSearch.emp_search();
			break;

		}

	}

///////////////// SHOW LIST
	public void empList() {

		List<Emp> empList = eDao.emp_showAll();

		if (empList != null && !empList.isEmpty()) {

			for (int i = 0; i < empList.size(); i++) {
				
				System.out.printf("%s", empList.get(i).getEmpno() + "\t");
				System.out.printf("%s", empList.get(i).getEname() + "\t");
				System.out.printf("%10s", empList.get(i).getJob() + "\t");
				System.out.printf("%s", empList.get(i).getMgr() + "\t");
				System.out.printf("%s", empList.get(i).getHiredate() + "\t");
				System.out.printf("%s", empList.get(i).getSal() + "\t");
				System.out.printf("%s", empList.get(i).getComm() + "\t");
				System.out.printf("%s", empList.get(i).getDeptno() + "\n");

			}

		} else {
			System.out.println("입력된 데이터가 없음");
		}

	}

}
