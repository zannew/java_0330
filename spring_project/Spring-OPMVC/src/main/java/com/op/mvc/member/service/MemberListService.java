package com.op.mvc.member.service;

import java.sql.SQLException;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.op.mvc.member.dao.JdbcTemplateMemberDAO;
import com.op.mvc.member.dao.MemberDAOInterface;
import com.op.mvc.member.model.Member;
import com.op.mvc.member.model.MemberListView;

@Service
public class MemberListService {

//	@Autowired
//	JdbcTemplateMemberDAO dao;
	
//	@Autowired
//	MybatisMemberDAO dao;

	private MemberDAOInterface dao;
	// 까묵지말자 SST (@Autowired까지)
	@Autowired
	private SqlSessionTemplate sessionTemplate;
	
	public MemberListView getView(HttpServletRequest request, HttpServletResponse response) throws SQLException {
		
		System.out.println("request체크 ▶ "+request);
		System.out.println("response체크 ▶ "+response);
		System.out.println("dao체크 ▶ "+dao);
		System.out.println("sessionTemplate체크 ▶ "+sessionTemplate);
		
		dao = sessionTemplate.getMapper(MemberDAOInterface.class);
		
		System.out.println("dao세컨체크 ▶ "+dao);
		
		
		Map<String, Object> search = new HashMap<String, Object>();
//		search.put("searchType", searchType);
//		search.put("keyword", keyword);
		
		// 검색 데이터 : searchType, keyword
		String searchType=request.getParameter("searchType");
		String keyword=request.getParameter("keyword");
		
		// 값이 공백이라면 null로 전달해주기
		
		if(searchType != null && !searchType.isEmpty()) {
			search.put("searchType", searchType);
		}
		if(keyword != null && !keyword.isEmpty()) {
			search.put("keyword", keyword);
		}
		
		
		// view 로 전달할 결과 데이터
		MemberListView listView = null;

		// 전체 게시물 개수 구하기
		int totalCnt = dao.totalCount(search);

		// 한 페이지 당 노출할 게시물의 개수
		final int MEMBER_CNT_PER_PAGE = 3;

		// 현재 페이지 번호
		int currentPageNumber = 1;
		String page = request.getParameter("page");
		if (page != null) {
			try {
				currentPageNumber = Integer.parseInt(page);
			} catch (NumberFormatException e) {
				System.out.println("숫자 타입의 문자열이 전달되지 않아 예외 발생");
			}
		}

		// 게시물의 첫번째 행의 index
		int startRow = 0;

		// 한 페이지에 누출할 리스트
		List<Member> memberList = null;
		
		if (totalCnt > 0) {
			startRow = (currentPageNumber - 1) * MEMBER_CNT_PER_PAGE;

			System.out.println(startRow);
			search.put("startRow", startRow);
			search.put("count", MEMBER_CNT_PER_PAGE);

			memberList = dao.selectList(search);
		} else {
			currentPageNumber = 0;
			memberList = Collections.emptyList();
		}

		listView = new MemberListView(totalCnt, currentPageNumber, memberList, MEMBER_CNT_PER_PAGE, startRow);

		System.out.println(listView);

		return listView;
		
		
	}
	
	
}
