package manager;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

public class DeptManager {
	// DAO 반드시 필요 - 데이터를 받아옴
	DeptDao dDao;
	int opt;

	public DeptManager() {
		dDao = new DeptDao();
	}

	public void deptManager() {

		System.out.println("메뉴를 선택하세요.");
		System.out.println("1.입력 | 2.수정 | 3.삭제 | 4.리스트보기 | 5.검색 | 6.뒤로가기");

		opt = Manager_Main.sc.nextInt();
		Manager_Main.sc.nextLine();

		switch (opt) {
		case 1:
			deptInsert(); 	//사용자의 입력데이터 dept객체에 담아서 Dao에 있는 insert메서드로 전달하면
			break;
		case 2:
			deptUpdate();	//	1. 수정하고자하는 데이터 유무 확인 → 2. 사용자로부터 데이터 받아서 전달
			break;
		case 3:
			deptDelete(); // 이름 또는 부서번호 (보통 pk로 처리) Dao에 있는 delete메서드로 전달
			break;
		case 4:
			deptList();
			break;
		case 5:
			deptSearch(); // 사용자가 입력한 이름은 Dao serach쪽으로 전달
			break;

		}

	}

/////////////INSERT	
	public void deptInsert() {

		System.out.println("새로운 부서의 정보를 입력합니다>>");

		System.out.println("부서번호를 입력하세요.");
		int deptno = Integer.parseInt(Manager_Main.sc.nextLine());
		System.out.println("부서 이름을 입력하세요.");
		String dname = Manager_Main.sc.nextLine();
		System.out.println("위치를 입력하세요.");
		String loc = Manager_Main.sc.nextLine();

		Dept dept = new Dept(deptno, dname, loc);

		int resultCnt = dDao.dept_insert(dept);

		if (resultCnt > 0) {
			System.out.println("정상적으로 입력 ");
			System.out.println(resultCnt + "행이 입력되었습니다.");
		} else {
			System.out.println("다시 시도해주세요.");
		}

	}

/////////////UPDATE
	public void deptUpdate() {
		
		Connection conn=null;
		int resultCnt=0;
		//블럭 체크!!!
		try {
			conn= ConnectionProvider.getConnection();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			conn.setAutoCommit(false);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		//기본값 true : 자동 커밋
		
//		1. 수정하고자하는 데이터 유무 확인 → 2. 사용자로부터 데이터 받아서 전달
		
		//1. 수정하고자하는 데이터 유무 확인
		System.out.println("수정하고자 하는 부서의 이름을 입력>>");
		String searchName=Manager_Main.sc.nextLine();
		
		int rowCnt = dDao.dept_searchCount(searchName, conn);
		//System.out.println(rowCnt);
		
		if(rowCnt>0) {
			Dept dept = dDao.deptSearchName(searchName, conn);
			
			if(dept==null) {
				System.out.println("찾으시는 이름의 정보가 존재하지 않습니다.");
				return;
			}
			// 사용자 입력 변수
			
			System.out.println("수정하실 부서의 정보를 입력합니다>>");
			System.out.println("부서번호 : "+ dept.getDeptno());
			System.out.println("수정하실 부서("+dept.getDname()+")의 이름을 입력하세요.");
			String dname = Manager_Main.sc.nextLine();
			
			System.out.println("수정하실 부서의 위치("+dept.getLoc()+")를 입력하세요.");
			String loc = Manager_Main.sc.nextLine();
		
			Dept newDept = new Dept(dept.getDeptno(), dname, loc);
			
			resultCnt = dDao.dept_update(newDept, conn);
			
			
		}else {
			System.out.println("찾으시는 이름의 정보가 존재하지 않습니다.");
		}
		
		
		
		
		
		if (resultCnt > 0) {
			System.out.println("정상적으로 수정 ");
			System.out.println(resultCnt + "행이 수정되었습니다.");
		} else {
			System.out.println("다시 시도해주세요.");
		}
	}

/////////////DELETE
	public void deptDelete() {

		System.out.println("삭제하실 부서의 번호을 입력하세요.");
		int deptno = Integer.parseInt(Manager_Main.sc.nextLine());

		int resultCnt = dDao.dept_delete(deptno);

		if (resultCnt > 0) {
			System.out.println("정상적으로 삭제 ");
			System.out.println(resultCnt + "행이 삭제되었습니다.");
		} else {
			System.out.println("삭제할 정보가 없습니다. 다시 시도해주세요.");
		}

	}

///////////////// SHOW LIST(출력 로직)
	public void deptList() {

		List<Dept> deptList = dDao.dept_showAll();

		if (deptList != null && !deptList.isEmpty()) {

			for (int i = 0; i < deptList.size(); i++) {
				System.out.printf("%5s", deptList.get(i).getDeptno() + "\t");
				System.out.printf("%12s", deptList.get(i).getDname() + "\t");
				System.out.printf("%12s", deptList.get(i).getLoc() + "\n");

			}

		} else {
			System.out.println("입력된 데이터가 없음");
		}

	}

////////////////SEARCH

	public void deptSearch() {

		// 사용자 입력정보 변수

		System.out.println("검색하실 부서의 이름을 입력하세요.");
		String searchName = Manager_Main.sc.nextLine();
//		System.out.println("검색하실 부서의 위치를 입력하세요.");
//		String loc = Manager_Main.sc.nextLine();

		List<Dept> list = dDao.dept_search(searchName);

		System.out.println("=================검색결과=================");
		for (Dept d : list) {
			System.out.printf("%5s", d.getDeptno() + "\t");
			System.out.printf("%12s", d.getDname() + "\t");
			System.out.printf("%12s", d.getLoc() + "\n");
		}
	}

}
