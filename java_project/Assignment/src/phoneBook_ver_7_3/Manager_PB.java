package phoneBook_ver_7_3;

import java.sql.Connection;
import java.sql.Date;
import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

import phoneBook_ver_7_3.ConnectionProvider;

public class Manager_PB {

	AllDAO allDao = new AllDAO();
	Scanner sc = new Scanner(System.in);
	
	// 1. 입력
	public void pbInsert() {
		
		Connection conn=null;
		int resultCnt = 0;
		int pidx = 0;
		int univ_ref = 0;
		int com_ref = 0;
		int grade = 0;
		Date regdate=null;
		AllDTO allDto = null;
		
		String name, phoneNum, addr, email, fr_type, major, comName, dname, comJob=null;

		System.out.println("▶ 어떤 친구의 정보를 저장하시겠습니까?");
		System.out.println("1. BASIC | 2. UNIV | 3. COM | 4. 돌아가기");
		
		int choice = Integer.parseInt(sc.nextLine());
		
			try {
				
				conn=ConnectionProvider.getConnection();
				
				System.out.println("▶정보를 입력을 시작합니다.");
				
				switch (choice) {
				
				case 1:
					
					conn.setAutoCommit(false);
					
					fr_type="basic";
					
					System.out.println("이름을 입력하세요 >>");
					name=sc.nextLine().trim();
					System.out.println("전화번호를 입력하세요 >>");
					phoneNum=sc.nextLine().trim();
					System.out.println("주소를 입력하세요 >>");
					addr=sc.nextLine().trim();
					System.out.println("이메일을 입력하세요 >>");
					email=sc.nextLine().trim();
					System.out.println("등록일을 입력하세요 >>");
					regdate = java.sql.Date.valueOf(sc.nextLine());
					
					allDto = new AllDTO(pidx, name, phoneNum, addr, email, fr_type, regdate);

					//DAO
					resultCnt = allDao.basicInsert(allDto, conn); 
					
					break;
					
				case 2:
					
					conn.setAutoCommit(false);
						
					fr_type="univ";
					
					System.out.println("이름을 입력하세요 >>");
					name=sc.nextLine().trim();
					System.out.println("전화번호를 입력하세요 >>");
					phoneNum=sc.nextLine().trim();
					System.out.println("주소를 입력하세요 >>");
					addr=sc.nextLine().trim();
					System.out.println("이메일을 입력하세요 >>");
					email=sc.nextLine().trim();
					System.out.println("등록일을 입력하세요 >>");
					regdate = java.sql.Date.valueOf(sc.nextLine());
					
					System.out.println("전공을 입력하세요 : ");
					major = sc.nextLine();
					
					System.out.println("학년을 입력하세요 : ");
					grade = Integer.parseInt(sc.nextLine());
					
					allDto = new AllDTO(pidx, name, phoneNum, addr, email, fr_type, regdate, major, grade, univ_ref);
					
					//DAO
					resultCnt = allDao.basicInsert(allDto, conn); 
					resultCnt = allDao.univInsert(allDto, conn);
						
					
					break;
					
				case 3:

					conn.setAutoCommit(false);
					
					fr_type="com";
					
					System.out.println("이름을 입력하세요 >>");
					name=sc.nextLine().trim();
					System.out.println("전화번호를 입력하세요 >>");
					phoneNum=sc.nextLine().trim();
					System.out.println("주소를 입력하세요 >>");
					addr=sc.nextLine().trim();
					System.out.println("이메일을 입력하세요 >>");
					email=sc.nextLine().trim();
					System.out.println("등록일을 입력하세요 >>");
					regdate = java.sql.Date.valueOf(sc.nextLine());
					
					
					System.out.println("회사명을 입력하세요 : ");
					comName = sc.nextLine();
					System.out.println("부서를 입력하세요 : ");
					dname = sc.nextLine();
					System.out.println("직급을 입력하세요 : ");
					comJob = sc.nextLine();
					
					allDto = new AllDTO(pidx, name, phoneNum, addr, email, fr_type, regdate, comName, dname, comJob, com_ref);
					
					//DAO
					resultCnt = allDao.basicInsert(allDto, conn);
					resultCnt = allDao.comInsert(allDto, conn);
					
					break;
				case 4:
					return;

				}
				
				conn.commit();
				
				if (resultCnt > 0) {
					System.out.println("입력이 완료됐습니다.");
					System.out.println(resultCnt + "행이 입력되었습니다.");
				} else {
					System.out.println("입력실패. 다시 시도해주세요.");
				}

				
			} catch (SQLException e) {
				if(conn != null) {
					try {
						conn.rollback();
						
					} catch (SQLException e1) {
						System.out.println("rollback 에러!!");
						e1.printStackTrace();
					}	
				}
				
				e.printStackTrace();
			} finally {
				if(conn != null) {
					try {
						conn.close();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}

	}
	
	// 2. 검색
	public void pbSearch() {


		System.out.println("검색할 친구의 이름>>");
		String searchName = sc.nextLine();
		List<AllDTO> pbList = allDao.searchInfo(searchName);
		
			if (pbList.isEmpty() || pbList == null) {
				System.out.println("입력하신 이름으로 검색한 결과가 없습니다.");
			} else {
				
				if(allDao.searchTypeNum(searchName)==1) {
					
					System.out.println("\t\t\t\t\t▶ 검색한 결과 ◀");
					System.out.println("-------------------------------------------------------------------------------------------");
					////////////////basic
					for (int i = 0; i < pbList.size(); i++) {
						
						System.out.printf("%2s", pbList.get(i).getPidx()+"\t");
						System.out.printf("%5s", pbList.get(i).getName()+"\t");
						System.out.printf("%5s", pbList.get(i).getPhoneNum()+"\t");
						System.out.printf("%-5s", pbList.get(i).getAddr()+"\t");
						System.out.printf("%-20s", pbList.get(i).getEmail()+"\t");
						System.out.printf("%-5s", pbList.get(i).getFr_type()+"\t");
						System.out.printf("%-5s", pbList.get(i).getRegdate()+"\n");
					}
					
					System.out.println("-------------------------------------------------------------------------------------------");
					
				}else if(allDao.searchTypeNum(searchName)==2) {
					////////////////univ
					System.out.println("\t\t\t\t\t▶ 검색한 결과 ◀");
					System.out.println("-------------------------------------------------------------------------------------------");
					for (int i = 0; i < pbList.size(); i++) {
						System.out.printf("%2s", pbList.get(i).getPidx()+"\t");
						System.out.printf("%5s", pbList.get(i).getName()+"\t");
						System.out.printf("%5s", pbList.get(i).getPhoneNum()+"\t");
						System.out.printf("%-5s", pbList.get(i).getAddr()+"\t");
						System.out.printf("%-20s", pbList.get(i).getEmail()+"\t");
						System.out.printf("%-5s", pbList.get(i).getFr_type()+"\t");
						System.out.printf("%-5s", pbList.get(i).getRegdate()+"\t");
						System.out.printf("%5s", pbList.get(i).getMajor()+"\t");
						System.out.printf("%-2s", pbList.get(i).getGrade()+"\n");
						
					}
					
				}else if(allDao.searchTypeNum(searchName)==3) {
					//////////////com
					System.out.println("\t\t\t\t\t▶ 검색한 결과 ◀");
					System.out.println("-------------------------------------------------------------------------------------------");
					for (int i = 0; i < pbList.size(); i++) {
						System.out.printf("%2s", pbList.get(i).getPidx()+"\t");
						System.out.printf("%5s", pbList.get(i).getName()+"\t");
						System.out.printf("%5s", pbList.get(i).getPhoneNum()+"\t");
						System.out.printf("%-5s", pbList.get(i).getAddr()+"\t");
						System.out.printf("%-20s", pbList.get(i).getEmail()+"\t");
						System.out.printf("%-5s", pbList.get(i).getFr_type()+"\t");
						System.out.printf("%-5s", pbList.get(i).getRegdate()+"\t");
						System.out.printf("%5s", pbList.get(i).getComName()+"\t");
						System.out.printf("%5s", pbList.get(i).getDname()+"\t");
						System.out.printf("%5s", pbList.get(i).getComJob()+"\n");
						
					}
					
			}
		}  
	}
	
	
	
	//3. 삭제
	public void pbDelete() {
		
		Connection conn=null;
		int resultCnt=0;
		
		try {
			
			conn = ConnectionProvider.getConnection();
			
//			conn.setAutoCommit(false);
			
			System.out.println("삭제할 친구의 이름>>");
			String searchName = sc.nextLine();
			
			int searchCnt = allDao.searchNameCnt(searchName, conn);
			
			if(searchCnt <= 0) {
				System.out.println("입력하신 이름으로 삭제할 결과가 없습니다.");
				
			}else if(searchCnt == 1) {
				resultCnt = allDao.pbDelete(searchName, conn);
				

			}else {
				
				//DAO
				List<AllDTO> pbList = allDao.searchInfo(searchName);
				
					
					System.out.println("\t\t\t\t\t▶ 검색한 결과 ◀");
					System.out.println("-------------------------------------------------------------------------------------------");
					for (int i = 0; i < pbList.size(); i++) {
						System.out.printf("%2s", pbList.get(i).getPidx()+"\t");
						System.out.printf("%5s", pbList.get(i).getName()+"\t");
						System.out.printf("%5s", pbList.get(i).getPhoneNum()+"\t");
						System.out.printf("%-5s", pbList.get(i).getAddr()+"\t");
						System.out.printf("%-20s", pbList.get(i).getEmail()+"\t");
						System.out.printf("%-5s", pbList.get(i).getFr_type()+"\t");
						System.out.printf("%-5s", pbList.get(i).getRegdate()+"\t");
						System.out.printf("%5s", pbList.get(i).getMajor()+"\t");
						System.out.printf("%-2s", pbList.get(i).getGrade()+"\t");
						System.out.printf("%5s", pbList.get(i).getComName()+"\t");
						System.out.printf("%5s", pbList.get(i).getDname()+"\t");
						System.out.printf("%5s", pbList.get(i).getComJob()+"\n");
						
					}
					
					System.out.println("삭제하실 정보의 번호를 입력하세요 >>");
					int selectPidx = Integer.parseInt(sc.nextLine());
					
					for (int i = 0; i < pbList.size(); i++) {
						if(pbList.get(i).getPidx()==selectPidx) {
							resultCnt = allDao.pidxDelete(selectPidx, conn);
						}
					}
				}  
				
//			conn.commit();
			
			if (resultCnt > 0) {
				System.out.println(resultCnt + "행이 삭제되었습니다.");
			} else {
				System.out.println("삭제할 정보를 찾지 못했습니다.");
			}
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			
			if(conn!=null) {
				
				try {
					conn.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
			
		}
		
	}
	
	//4. 수정
	public void pbEdit() {
		Connection conn=null;
		int resultCnt=0;
		
		try {
			
			conn=ConnectionProvider.getConnection();
			
			conn.setAutoCommit(false);
			
			System.out.println("수정할 친구의 이름 >>");
			System.out.println("(이름은 수정되지 않습니다.)");
			String searchName = sc.nextLine();
			
			//유무 확인
			int existCnt = allDao.searchNameCnt(searchName, conn);
			
			if(existCnt<=0) {
				
				System.out.println("수정할 친구의 정보를 찾을 수 없습니다.");
				
				return;
				
			}else {
				
				AllDTO allDto = allDao.searchName(searchName, conn);
				
				if(allDto == null) {
					System.out.println("수정할 친구의 정보를 찾을 수 없습니당.");
					return;
				}
				
				int editCheckNum = allDao.searchTypeNum(searchName);
		
				switch(editCheckNum) {
				
				case 1:
					
					
					System.out.println("새로운 전화번호를 입력하세요 >>");
					String newPhoneNum = sc.nextLine();
					System.out.println("새로운 주소를 입력하세요 >>");
					String newAddr = sc.nextLine();
					System.out.println("새로운 이메일을 입력하세요 >>");
					String newEmail = sc.nextLine();
					
					resultCnt = allDao.pbBasicEdit(searchName, newPhoneNum, newAddr, newEmail, conn);
					
					break;
				
				case 2:
					
					
					System.out.println("새로운 전화번호를 입력하세요 >>");
					String univPhoneNum = sc.nextLine();
					System.out.println("새로운 주소를 입력하세요 >>");
					String univAddr = sc.nextLine();
					System.out.println("새로운 이메일을 입력하세요 >>");
					String univEmail = sc.nextLine();
					
					
					System.out.println("새로운 전공을 입력하세요 >>");
					String newMajor = sc.nextLine();
					System.out.println("새로운 학년을 입력하세요 >>");
					int newGrade = Integer.parseInt(sc.nextLine());
					
					//DAO
					resultCnt = allDao.pbBasicEdit(searchName, univPhoneNum, univAddr, univEmail, conn);
					System.out.println("기본 입력완료");
					resultCnt = allDao.pbUnivEdit(searchName, newMajor, newGrade, conn);
					System.out.println("추가 입력완료");
					
					
					break;
					
				case 3:
					
					
					System.out.println("새로운 전화번호를 입력하세요 >>");
					String comPhoneNum = sc.nextLine();
					System.out.println("새로운 주소를 입력하세요 >>");
					String comAddr = sc.nextLine();
					System.out.println("새로운 이메일을 입력하세요 >>");
					String comEmail = sc.nextLine();
					
					System.out.println("새로운 회사이름을 입력하세요 >>");
					String newComName = sc.nextLine();
					System.out.println("새로운 부서를 입력하세요 >>");
					String newDname = sc.nextLine();
					System.out.println("새로운 직급을 입력하세요 >>");
					String newComJob = sc.nextLine();
					
					System.out.println("입력까지만 받음");
					
					//DAO
					resultCnt = allDao.pbBasicEdit(searchName, comPhoneNum, comAddr, comEmail, conn);
					System.out.println("기본 입력완료");
					resultCnt = allDao.pbComEdit(searchName, newComName, newDname, newComJob, conn);
					System.out.println("추가 입력완료");
					break;
			
				}
				
				//마지막에 커밋!!
				conn.commit();
			}
			
			if(resultCnt<0) {
				System.out.println("수정에 실패하였습니다. 다시 시도해주세요.");
			}else {
				System.out.println(resultCnt+"행의 정보가 수정되었습니다.");
			}
		} catch (SQLException e) {
			if(conn != null) {
				try {
					conn.rollback();
					
				} catch (SQLException e1) {
					System.out.println("rollback 에러!!");
					e1.printStackTrace();
				}	
			}
			
			e.printStackTrace();
		} finally {
			if(conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		
	}
	
	
	
	//5. 정보보기
	public void showInfo() {

		System.out.println("\t\t\t▶친구 정보 보기◀");
		System.out.println("1. Basic | 2. Com | 3. Univ | 4. All");
		System.out.println("번호를 선택하세요>>");
		int opt = Integer.parseInt(sc.nextLine());
		
		//DAO
		List<AllDTO> pbList = allDao.showInfo();
		
		if (pbList != null && !pbList.isEmpty()) {
		
		switch(opt) {
		
		case 1:
			System.out.println("\t\t\t\t▶ 기본 정보 목록 보기 ◀");
			System.out.println("-------------------------------------------------------------------------------------------");
		
			
			for (int i = 0; i < pbList.size(); i++) {
			
					
					System.out.printf("%2s", pbList.get(i).getPidx()+"\t");
					System.out.printf("%5s", pbList.get(i).getName()+"\t");
					System.out.printf("%5s", pbList.get(i).getPhoneNum()+"\t");
					System.out.printf("%-5s", pbList.get(i).getAddr()+"\t");
					System.out.printf("%-20s", pbList.get(i).getEmail()+"\t");
					System.out.printf("%-5s", pbList.get(i).getFr_type()+"\t");
					System.out.printf("%-5s", pbList.get(i).getRegdate()+"\n");
			}
			
			break;
		
		
		case 2:
			System.out.println("\t\t\t\t▶ 회사 친구 목록 보기 ◀");
			System.out.println("-------------------------------------------------------------------------------------------");
		
			
			for (int i = 0; i < pbList.size(); i++) {
			
				if(pbList.get(i).getFr_type().equals("com")) {
					
					System.out.printf("%2s", pbList.get(i).getPidx()+"\t");
					System.out.printf("%5s", pbList.get(i).getName()+"\t");
					System.out.printf("%5s", pbList.get(i).getPhoneNum()+"\t");
					System.out.printf("%-5s", pbList.get(i).getAddr()+"\t");
					System.out.printf("%-20s", pbList.get(i).getEmail()+"\t");
					System.out.printf("%-5s", pbList.get(i).getFr_type()+"\t");
					System.out.printf("%-5s", pbList.get(i).getRegdate()+"\t");
					System.out.printf("%5s", pbList.get(i).getComName()+"\t");
					System.out.printf("%5s", pbList.get(i).getDname()+"\t");
					System.out.printf("%5s", pbList.get(i).getComJob()+"\n");
				}

			}
			
			break;
		case 3:
			
			
			System.out.println("\t\t\t\t▶ 대학 친구 목록 보기 ◀");
			System.out.println("-------------------------------------------------------------------------------------------");
			
			
			for (int i = 0; i < pbList.size(); i++) {
				
				if(pbList.get(i).getFr_type().equals("univ")) {
					
					System.out.printf("%2s", pbList.get(i).getPidx()+"\t");
					System.out.printf("%5s", pbList.get(i).getName()+"\t");
					System.out.printf("%5s", pbList.get(i).getPhoneNum()+"\t");
					System.out.printf("%-5s", pbList.get(i).getAddr()+"\t");
					System.out.printf("%-20s", pbList.get(i).getEmail()+"\t");
					System.out.printf("%-5s", pbList.get(i).getFr_type()+"\t");
					System.out.printf("%-5s", pbList.get(i).getRegdate()+"\t");
					System.out.printf("%5s", pbList.get(i).getMajor()+"\t");
					System.out.printf("%-2s", pbList.get(i).getGrade()+"\n");

				}
			}
			break;
			
		case 4:

				System.out.println("\t\t\t\t▶ 전체 친구 목록 보기 ◀");
				System.out.println("-------------------------------------------------------------------------------------------");
				
				for (int i = 0; i < pbList.size(); i++) {
					
					System.out.printf("%2s", pbList.get(i).getPidx()+"\t");
					System.out.printf("%5s", pbList.get(i).getName()+"\t");
					System.out.printf("%5s", pbList.get(i).getPhoneNum()+"\t");
					System.out.printf("%-5s", pbList.get(i).getAddr()+"\t");
					System.out.printf("%-20s", pbList.get(i).getEmail()+"\t");
					System.out.printf("%-5s", pbList.get(i).getFr_type()+"\t");
					System.out.printf("%-5s", pbList.get(i).getRegdate()+"\t");
					System.out.printf("%5s", pbList.get(i).getMajor()+"\t");
					System.out.printf("%-2s", pbList.get(i).getGrade()+"\t");
					System.out.printf("%5s", pbList.get(i).getComName()+"\t");
					System.out.printf("%5s", pbList.get(i).getDname()+"\t");
					System.out.printf("%5s", pbList.get(i).getComJob()+"\n");	

				}
				System.out.println("-------------------------------------------------------------------------------------------");
				break;
			} 
		
		
		}else {
			System.out.println("저장된 친구의 정보가 없습니다.");
			return;
		}
		

	}
	
	
	
	
	//입력날짜 Date타입으로 바꿔주는 메서드
//	private Date valueOf(String nextLine) {
//		return regDate;
//	}

}
