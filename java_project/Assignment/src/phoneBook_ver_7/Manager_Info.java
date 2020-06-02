package phoneBook_ver_7;

import java.util.List;

//저장, 검색, 삭제, 수정, 모두 보기, 종료
public class Manager_Info {

	Dao_PhoneInfo infoDao = new Dao_PhoneInfo();

	////////////////// phonebookManager////////////////
	public void pbManager() {

		System.out.println("메뉴를 선택하세요.");

		int choice = MainManager.sc.nextInt();

		switch (choice) {

		case 1:
			System.out.println("친구 정보 저장");
			pbInsert();
			break;

		case 2:
			System.out.println("친구 정보 검색");
			break;

		case 3:
			System.out.println("친구 정보 삭제 ");
			break;

		case 4:
			System.out.println("친구 정보 수정 ");
			break;

		case 5:
			System.out.println("친구 정보 모두 보기 ");
			break;

		case 6:
			System.out.println("프로그램 종료");
			break;

		}

	}

	//////// INSERT(완)(완)
	public void pbInsert() {

		// (공통)기본 정보 입력
		System.out.println("저장할 정보 입력단계입니다.");

		// 공통 기본 정보 입력 - 이름, 전화번호, 주소, 이메일
		System.out.println("이름을 입력하세요 : ");
		String name = MainManager.sc.nextLine();
		MainManager.sc.nextLine();

		System.out.println("전화번호를 입력하세요 : ");
		String phoneNum = MainManager.sc.nextLine();

		System.out.println("주소를 입력하세요 : ");
		String address = MainManager.sc.nextLine();

		System.out.println("이메일을 입력하세요 : ");
		String email = MainManager.sc.nextLine();

		System.out.println("전공을 입력하세요 : ");
		String major = MainManager.sc.nextLine();

		System.out.println("학년을 입력하세요 : ");
		int year = Integer.parseInt(MainManager.sc.nextLine());

		System.out.println("회사명을 입력하세요 : ");
		String companyName = MainManager.sc.nextLine();
		
		System.out.println("세가지 타입 중 한가지를 입력하세요('com', 'univ', 'cafe')");
		String PBType=MainManager.sc.nextLine();
		
		PhoneInfo info = new PhoneInfo(name, phoneNum, address, email, major, year, companyName, PBType);

		int resultCnt = infoDao.pbInsert(info);

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
		String searchName = MainManager.sc.nextLine();

		List<PhoneInfo> infoList = infoDao.pbSearch(searchName);

		if (infoList.isEmpty() || infoList == null) {
			System.out.println("입력하신 이름으로 검색한 결과가 없습니다.");
		} else {

			for (int i = 0; i < infoList.size(); i++) {
				System.out.printf("%5s", infoList.get(i).getName());
				System.out.printf("%10s", infoList.get(i).getPhoneNum());
				System.out.printf("%10s", infoList.get(i).getAddress());
				System.out.printf("%10s", infoList.get(i).getEmail());
				System.out.printf("%10s", infoList.get(i).getMajor());
				System.out.printf("%5s", infoList.get(i).getYear());
				System.out.printf("%10s", infoList.get(i).getCompanyName());
				System.out.println("------------------------------------------------");
			}

		}

	}

	//////// DELETE(완)
	public void pbDelete() {

		System.out.println("삭제할 친구의 이름 >>");
		String searchName = MainManager.sc.nextLine();

		int resultCnt = infoDao.pbDelete(searchName);

		if (resultCnt > 0) {
			System.out.println(resultCnt + "행이 삭제되었습니다.");
		} else {
			System.out.println("삭제할 데이터가 없습니다.");
		}

	}

	//////// UPDATE(EDIT)
	public void pbEdit() {

		System.out.println("수정할 친구의 이름 >>");
		System.out.println("(이름은 수정되지 않습니다.)");
		String searchName = MainManager.sc.nextLine();
		System.out.println("새로운 전화번호를 입력하세요.");
		String newPhoneNum = MainManager.sc.nextLine();
		System.out.println("새로운 주소를 입력하세요.");
		String newAddr = MainManager.sc.nextLine();
		System.out.println("새로운 이메일을 입력하세요.");
		String newEmail = MainManager.sc.nextLine();

		int resultCnt = infoDao.pbEdit(searchName, newPhoneNum, newAddr, newEmail);
		
		if(resultCnt<0) {
			System.out.println("수정된 정보 : "+resultCnt);
		}else {
			System.out.println(resultCnt+"행의 정보가 수정되었습니다.");
		}
	}

	//////// SHOWALL(완)
	public void pbShowAll() {

		List<PhoneInfo> infoList = infoDao.pbShowAll();

		if (infoList != null && !infoList.isEmpty()) {

			for (int i = 0; i < infoList.size(); i++) {
				System.out.printf("%5s", infoList.get(i).getName());
				System.out.printf("%10s", infoList.get(i).getPhoneNum());
				System.out.printf("%10s", infoList.get(i).getAddress());
				System.out.printf("%10s", infoList.get(i).getEmail());
				System.out.printf("%10s", infoList.get(i).getMajor());
				System.out.printf("%5s", infoList.get(i).getYear());
				System.out.printf("%10s", infoList.get(i).getCompanyName());

			}
		} else {
			System.out.println("입력된 데이터가 없습니다.");
		}

	}

}
