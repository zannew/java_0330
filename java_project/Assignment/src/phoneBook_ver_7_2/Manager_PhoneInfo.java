package phoneBook_ver_7_2;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

//저장(대학,회사, 카페), 검색, 삭제, 수정(대학, 회사,ㅋㅏ페), 모두 보기, 종료
public class Manager_PhoneInfo {
	
	Scanner sc = new Scanner(System.in);
	
	Dao_PhoneInfo infoDao = new Dao_PhoneInfo();
	int choice =0;
	

	//////// INSERT
	public void pbInsert() {

		Dto_PhoneInfo info=null;
		
		String PBType, major, companyName, dept, job, cafeName, nickName;
		int year;
		int pbidx = 0;
		int resultCnt=0;
		
		System.out.println("▶ 어떤 친구의 정보를 저장하시겠습니까?");
		System.out.println("1. com | 2. univ | 3. cafe ");
		choice=Integer.parseInt(sc.nextLine());
		
		// (공통)기본 정보 입력
		System.out.println("저장할 정보 입력단계입니다.");

		// 공통 기본 정보 입력 - 이름, 전화번호, 주소, 이메일
		System.out.println("이름을 입력하세요 : ");
		String name = sc.nextLine();

		System.out.println("전화번호를 입력하세요 : ");
		String phoneNum = sc.nextLine();

		System.out.println("주소를 입력하세요 : ");
		String address = sc.nextLine();

		System.out.println("이메일을 입력하세요 : ");
		String email = sc.nextLine();
		
		if(choice==1) {
			
			PBType="com";
			
			System.out.println("회사명을 입력하세요 : ");
			companyName = sc.nextLine();
			System.out.println("부서를 입력하세요 : ");
			dept = sc.nextLine();
			System.out.println("직급을 입력하세요 : ");
			job = sc.nextLine();
			
			
			info = new Dto_PhoneInfo(pbidx, name, phoneNum, address, email, PBType, companyName, dept, job);
			
			//DAO
			resultCnt = infoDao.pbInsert(info);
		}
		
		else if(choice==2) {
			
			PBType="univ";
			
			System.out.println("전공을 입력하세요 : ");
			major = sc.nextLine();
			
			System.out.println("학년을 입력하세요 : ");
			year = Integer.parseInt(sc.nextLine());
			
			info = new Dto_PhoneInfo(pbidx, name, phoneNum, address, email, PBType, major, year);
			
			//DAO
			resultCnt = infoDao.pbInsert(info);
			
			
		}else if(choice==3) {
			
			PBType="cafe";
			
			System.out.println("동호회 이름을 입력하세요 : ");
			cafeName = sc.nextLine();
			System.out.println("닉네임을 입력하세요 : ");
			nickName = sc.nextLine();
			
			info = new Dto_PhoneInfo(pbidx, name, phoneNum, address, email, PBType, cafeName, nickName);
			
			//DAO
			resultCnt = infoDao.pbInsert(info);
			
		}

		if (resultCnt > 0) {
			System.out.println("입력이 완료됐습니다.");
			System.out.println(resultCnt + "행이 입력되었습니다.");
		} else {
			System.out.println("입력실패. 다시 시도해주세요.");
		}

	}

	//////// SEARCH(완)
	public void pbSearch() {

		System.out.println("검색할 친구의 이름>>");
		String searchName = sc.nextLine();

		List<Dto_PhoneInfo> infoList = infoDao.pbSearch(searchName);

		
		
		if (infoList.isEmpty() || infoList == null) {
			System.out.println("입력하신 이름으로 검색한 결과가 없습니다.");
		} else {

			if(infoDao.searchTypeNum(searchName)==2) {
				
				System.out.println("\t\t\t\t\t▶ 검색한 결과 ◀");
				System.out.println("-------------------------------------------------------------------------------------------");

				for (int i = 0; i < infoList.size(); i++) {
					
					System.out.printf("%2s", infoList.get(i).getPbidx()+"\t");
					System.out.printf("%5s", infoList.get(i).getPbname()+"\t");
					System.out.printf("%10s", infoList.get(i).getPbNumber()+"\t");
					System.out.printf("%10s", infoList.get(i).getPbaddr()+"\t");
					System.out.printf("%10s", infoList.get(i).getPbmail()+"\t");
					System.out.printf("%10s", infoList.get(i).getPBType()+"\t");
					System.out.printf("%10s", infoList.get(i).getPbmajor()+"\t");
					System.out.printf("%2s", infoList.get(i).getPbgrade()+"\n");

				System.out.println("-------------------------------------------------------------------------------------------");
				
				}
			}else if(infoDao.searchTypeNum(searchName)==2) {
				
				System.out.println("\t\t\t\t\t▶ 검색한 결과 ◀");
				System.out.println("-------------------------------------------------------------------------------------------");
				for (int i = 0; i < infoList.size(); i++) {
					System.out.printf("%2s", infoList.get(i).getPbidx()+"\t");
					System.out.printf("%5s", infoList.get(i).getPbname()+"\t");
					System.out.printf("%10s", infoList.get(i).getPbNumber()+"\t");
					System.out.printf("%10s", infoList.get(i).getPbaddr()+"\t");
					System.out.printf("%10s", infoList.get(i).getPbmail()+"\t");
					System.out.printf("%10s", infoList.get(i).getPBType()+"\t");
					System.out.printf("%10s", infoList.get(i).getPbcomName()+"\t");
					System.out.printf("%10s", infoList.get(i).getPbComDept()+"\t");
					System.out.printf("%10s", infoList.get(i).getPbComJob()+"\n");

				}
				
			}else if(infoDao.searchTypeNum(searchName)==3) {
				
				System.out.println("\t\t\t\t\t▶ 검색한 결과 ◀");
				System.out.println("-------------------------------------------------------------------------------------------");
				for (int i = 0; i < infoList.size(); i++) {
					System.out.printf("%2s", infoList.get(i).getPbidx()+"\t");
					System.out.printf("%5s", infoList.get(i).getPbname()+"\t");
					System.out.printf("%10s", infoList.get(i).getPbNumber()+"\t");
					System.out.printf("%10s", infoList.get(i).getPbaddr()+"\t");
					System.out.printf("%10s", infoList.get(i).getPbmail()+"\t");
					System.out.printf("%10s", infoList.get(i).getPBType()+"\t");
					System.out.printf("%10s", infoList.get(i).getPbcafeName()+"\t");
					System.out.printf("%10s", infoList.get(i).getPbNickName()+"\n");
//					System.out.printf("%10s", infoList.get(i).getPbmajor()+"\t");
//					System.out.printf("%2s", infoList.get(i).getPbgrade()+"\t");
//					System.out.printf("%10s", infoList.get(i).getPbcomName()+"\n");

				}
				
			}
			
		 }
	}


	//////// DELETE
	public void pbDelete() {

		System.out.println("삭제할 친구의 이름 >>");
		String searchName = sc.nextLine();

		//DAO
		int resultCnt = infoDao.pbDelete(searchName);

		if (resultCnt > 0) {
			System.out.println(resultCnt + "행이 삭제되었습니다.");
		} else {
			System.out.println("삭제할 정보를 찾지 못했습니다.");
		}

	}

	//////// UPDATE(EDIT)-일단 기본정보만 수정
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
			int existCnt = infoDao.searchNameCnt(searchName, conn);
			
			if(existCnt<=0) {
				
				System.out.println("수정할 친구의 정보를 찾을 수 없습니다.");
				
				return;
				
			}else {
				
				Dto_PhoneInfo info = infoDao.searchName(searchName, conn);
				
				if(info == null) {
					System.out.println("수정할 친구의 정보를 찾을 수 없습니당.");
					return;
				}
				
				int editCheckNum = infoDao.searchTypeNum(searchName);
				
				
				System.out.println("새로운 전화번호를 입력하세요 >>");
				String newPhoneNum = sc.nextLine();
				System.out.println("새로운 주소를 입력하세요 >>");
				String newAddr = sc.nextLine();
				System.out.println("새로운 이메일을 입력하세요 >>");
				String newEmail = sc.nextLine();
				
				
				
				switch(editCheckNum) {
				
				case 1:
					System.out.println("새로운 회사이름을 입력하세요 >>");
					String newComName = sc.nextLine();
					System.out.println("새로운 부서를 입력하세요 >>");
					String newComDept = sc.nextLine();
					System.out.println("새로운 직급을 입력하세요 >>");
					String newComJob = sc.nextLine();
					
					//회사
//					info = new PhoneInfo(info.getPbidx(), 
//							searchName,
//							newPhoneNum, 
//							newAddr, 
//							newEmail, 
//							info.getPBType(),
//							info.getPbmajor(), 
//							info.getPbgrade(), 
//							newComName, 
//							newComDept, 
//							newComJob,
//							info.getPbcafeName(), 
//							info.getPbNickName());
					
					//DAO
					resultCnt = infoDao.pbComEdit(searchName, newPhoneNum, newAddr, newEmail, newComName, newComDept, newComJob, conn);
					
					break;
				case 2:
					System.out.println("새로운 전공을 입력하세요 >>");
					String newMajor = sc.nextLine();
					System.out.println("새로운 학년을 입력하세요 >>");
					int newGrade = Integer.parseInt(sc.nextLine());
					
					//학교
					info = new Dto_PhoneInfo(info.getPbidx(), 
							searchName,
							newPhoneNum, 
							newAddr, 
							newEmail, 
							info.getPBType(),
							newMajor, 
							newGrade, 
							info.getPbcomName(), 
							info.getPbComDept(), 
							info.getPbComJob(),
							info.getPbcafeName(), 
							info.getPbNickName());
					
					//DAO
					resultCnt = infoDao.pbUnivEdit(searchName, newPhoneNum, newAddr, newEmail, newMajor, newGrade, conn);
					
					break;
				case 3:
					System.out.println("새로운 동호회 이름을 입력하세요 >>");
					String newCafeName = sc.nextLine();
					System.out.println("새로운 닉네임을 입력하세요 >>");
					String newCafeNickName = sc.nextLine();
					
					//동호회
					
					info = new Dto_PhoneInfo(info.getPbidx(), 
							searchName,
							newPhoneNum, 
							newAddr, 
							newEmail, 
							info.getPBType(),
							info.getPbmajor(), 
							info.getPbgrade(), 
							info.getPbcomName(), 
							info.getPbComDept(), 
							info.getPbComJob(),
							newCafeName, 
							newCafeNickName);
					
					//DAO
					resultCnt = infoDao.pbCafeEdit(searchName, newPhoneNum, newAddr, newEmail, newCafeName, newCafeNickName, conn);
					
					break;
				}
				
			}
			
			if(resultCnt<0) {
				System.out.println("수정에 실패하였습니다. 다시 시도해주세요.");
			}else {
				System.out.println(resultCnt+"행의 정보가 수정되었습니다.");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	//////// SHOWALL(완)-출력 정리해야됨
	public void pbShowAll() {

		System.out.println("\t\t\t▶친구 정보 보기◀");
		System.out.println("1.회사 친구 | 2. 대학 친구 | 3. 동호회 친구 | 4. 모두 보기");
		System.out.println("번호를 선택하세요>>");
		int opt = Integer.parseInt(sc.nextLine());
		
		//DAO
		List<Dto_PhoneInfo> infoList = infoDao.pbShowAll();
		
		if (infoList != null && !infoList.isEmpty()) {
		
		switch(opt) {
		
		case 1:
			System.out.println("\t\t\t\t▶ 회사 친구 목록 보기 ◀");
			System.out.println("-------------------------------------------------------------------------------------------");
		
			
			
			for (int i = 0; i < infoList.size(); i++) {
			
				if(infoList.get(i).getPBType().equals("com")) {
					
					System.out.printf("%2s", infoList.get(i).getPbidx()+"\t");
					System.out.printf("%5s", infoList.get(i).getPbname()+"\t");
					System.out.printf("%5s", infoList.get(i).getPbNumber()+"\t");
					System.out.printf("%-5s", infoList.get(i).getPbaddr()+"\t");
					System.out.printf("%-20s", infoList.get(i).getPbmail()+"\t");
					System.out.printf("%-5s", infoList.get(i).getPBType()+"\t");
					System.out.printf("%5s", infoList.get(i).getPbcomName()+"\t");
					System.out.printf("%5s", infoList.get(i).getPbComDept()+"\t");
					System.out.printf("%5s", infoList.get(i).getPbComJob()+"\n");
				}

			}
			
			break;
		case 2:
			
			
			System.out.println("\t\t\t\t▶ 대학 친구 목록 보기 ◀");
			System.out.println("-------------------------------------------------------------------------------------------");
			
			
			for (int i = 0; i < infoList.size(); i++) {

				if(infoList.get(i).getPBType().equals("univ")) {
					
				System.out.printf("%2s", infoList.get(i).getPbidx()+"\t");
				System.out.printf("%5s", infoList.get(i).getPbname()+"\t");
				System.out.printf("%5s", infoList.get(i).getPbNumber()+"\t");
				System.out.printf("%-5s", infoList.get(i).getPbaddr()+"\t");
				System.out.printf("%-20s", infoList.get(i).getPbmail()+"\t");
				System.out.printf("%-5s", infoList.get(i).getPBType()+"\t");
				System.out.printf("%5s", infoList.get(i).getPbmajor()+"\t");
				System.out.printf("%-2s", infoList.get(i).getPbgrade()+"\n");

				}
			}
			break;
			
		case 3:
			
			System.out.println("\t\t\t\t▶ 동호회 친구 목록 보기 ◀");
			System.out.println("-------------------------------------------------------------------------------------------");

			for (int i = 0; i < infoList.size(); i++) {
				
				if(infoList.get(i).getPBType().equals("cafe")) {
				
				System.out.printf("%2s", infoList.get(i).getPbidx()+"\t");
				System.out.printf("%5s", infoList.get(i).getPbname()+"\t");
				System.out.printf("%5s", infoList.get(i).getPbNumber()+"\t");
				System.out.printf("%-5s", infoList.get(i).getPbaddr()+"\t");
				System.out.printf("%-20s", infoList.get(i).getPbmail()+"\t");
				System.out.printf("%-5s", infoList.get(i).getPBType()+"\t");
				System.out.printf("%10s", infoList.get(i).getPbcafeName()+"\t");
				System.out.printf("%5s", infoList.get(i).getPbNickName()+"\n");
			
				}	
				
			}
			
			break;
			
		case 4:

				System.out.println("\t\t\t\t▶ 전체 친구 목록 보기 ◀");
				System.out.println("-------------------------------------------------------------------------------------------");
				
				for (int i = 0; i < infoList.size(); i++) {
					
					System.out.printf("%2s", infoList.get(i).getPbidx()+"\t");
					System.out.printf("%5s", infoList.get(i).getPbname()+"\t");
					System.out.printf("%5s", infoList.get(i).getPbNumber()+"\t");
					System.out.printf("%-5s", infoList.get(i).getPbaddr()+"\t");
					System.out.printf("%-20s", infoList.get(i).getPbmail()+"\t");
					System.out.printf("%5s", infoList.get(i).getPBType()+"\t");
					System.out.printf("%5s", infoList.get(i).getPbmajor()+"\t");
					System.out.printf("%-2s", infoList.get(i).getPbgrade()+"\t");
					System.out.printf("%5s", infoList.get(i).getPbcomName()+"\t");
					System.out.printf("%5s", infoList.get(i).getPbComDept()+"\t");
					System.out.printf("%5s", infoList.get(i).getPbComJob()+"\t");
					System.out.printf("%10s", infoList.get(i).getPbcafeName()+"\t");
					System.out.printf("%5s", infoList.get(i).getPbNickName()+"\n");
					

				}
				System.out.println("-------------------------------------------------------------------------------------------");
				break;
			} 
		
		
		}else {
			System.out.println("저장된 친구의 정보가 없습니다.");
			return;
		}
		
		
		

		

	}
	
	
	//이름을 넣으면 

}
