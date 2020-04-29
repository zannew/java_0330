package ver05;

public interface Menu_Interface {

/*
1. 친구 정보  입력		//2020.04.29

	1.대학 2.회사 3.동호회

2. 친구 정보  검색
3. 친구 정보  삭제
4. 친구 정보  수정
5. 친구 정보  전체보기
6. 프로그램 종료
 * 
 * 
 * 
 * */	
	
	
	//상수 : 문자, 문자열, boolean, int 가능 (final여부로 구분)
//	char INSERT_CHAR='i';
	
	
	//public static final 생략
	int INSERT_INFO=1;
//		int INSERT_BASIC=1;			//2020.04.29
		int INSERT_UNIV=1;
		int INSERT_COMPANY=2;
		int INSERT_CAFE=3;
	int SEARCH_INFO=2;
	int DELETE_INFO=3;
	int EDIT_INFO=4;
	int SHOW_ALL=5;
	int EXIT=6;
	
	
	//2020.04.29
//	int INSERT=1;				1. 친구 정보  입력
//	int SEARCH=2;				2. 친구 정보  검색
//	int DELETE=3;				3. 친구 정보  삭제
//	int EDIT=4;					4. 친구 정보  수정
//	int PRINT_ALL=5;			5. 친구 정보  전체보기
//	int EXIT=6;					6. 프로그램 종료
//		
//	
//	int UNIV=1;				1.대학 
//	int COMPANY=2;			2.회사 
//	int CAFE=3;				3.동호회
	
}
