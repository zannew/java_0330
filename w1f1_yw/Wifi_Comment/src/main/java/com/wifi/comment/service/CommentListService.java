package com.wifi.comment.service;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wifi.comment.dao.CommentDao;
import com.wifi.comment.model.Comment;
import com.wifi.comment.model.CommentListView;

@Service
public class CommentListService {

	
	private CommentDao dao;
	
	@Autowired
	private SqlSessionTemplate sTemplate;
	
	
	public CommentListView getCommentList(HttpServletRequest request) {
		
		dao = sTemplate.getMapper(CommentDao.class);
		
		//쿼리문으로 던져줄 조건들 map
		Map<String, Object> search = new HashMap<String, Object>();
		CommentListView listView = null;
		int iidx = Integer.parseInt(request.getParameter("iidx"));
		
		search.put("iidx", iidx);
		
		int commentTotalCnt = dao.totalCountByiidx(search);
		
		final int COMMENT_CNT_PER_PAGE = 20;
		
		int currentPageNumber = 1;
		String page = request.getParameter("page");
		System.out.println("▶comment_page : " + page);
		
		if (page != null) {
			try {
				currentPageNumber = Integer.parseInt(page);
			} catch (NumberFormatException e) {
				System.out.println("숫자 타입의 문자열이 전달되지 않아 예외 발생");
			}
		}
		
		int startRow = 0;
		
		List<Comment> commentList = null;
		
		if(commentTotalCnt > 0) {
			startRow = (currentPageNumber - 1)* COMMENT_CNT_PER_PAGE;
			
			System.out.println("startRow ▶" + startRow);
			search.put("startRow", startRow);
			search.put("count", COMMENT_CNT_PER_PAGE);	
			
			commentList = dao.selectCommentByiidx(search);
			System.out.println("commentList ▶" + commentList);

		} else {
			currentPageNumber = 0;
			commentList = Collections.emptyList();
		}
		
		listView = new CommentListView(commentTotalCnt, currentPageNumber, commentList, COMMENT_CNT_PER_PAGE, startRow);
		System.out.println("comment - listView ▶" + listView);
		
		return listView;
	}

}
