package com.wifi.comment.service;

import javax.servlet.http.HttpServletRequest;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wifi.comment.dao.CommentDao;
import com.wifi.comment.model.Comment;
import com.wifi.comment.model.CommentEditRequest;

@Service
public class CommentEditService {

	private CommentDao dao;
	
	@Autowired
	private SqlSessionTemplate sTemplate;
	
	public int editComment(CommentEditRequest editRequest, HttpServletRequest request) {
		
		int result=0;
		dao=sTemplate.getMapper(CommentDao.class);
		
		Comment comment = editRequest.toComment();
		
		String editContent = request.getParameter("content");
		System.out.println("수정될 메시지 : "+editContent);
		//int cidx = Integer.parseInt(request.getParameter("cidx"));
		
		
		result = dao.editComment(comment);
		
		return result;
	}

}
