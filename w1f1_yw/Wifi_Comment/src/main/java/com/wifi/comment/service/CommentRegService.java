package com.wifi.comment.service;

import javax.servlet.http.HttpServletRequest;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wifi.comment.dao.CommentDao;
import com.wifi.comment.model.Comment;
import com.wifi.comment.model.CommentRegRequest;

@Service
public class CommentRegService {

	private CommentDao dao;
	
	@Autowired
	private SqlSessionTemplate sTemplate;
	
	
	public int regComment(CommentRegRequest regRequest, HttpServletRequest request) {
		
		dao=sTemplate.getMapper(CommentDao.class);
		
		int result = 0;
		
		Comment comment = regRequest.toComment();
		
		System.out.println("입력전 cidx : "+comment.getCidx());
		System.out.println("●CommentRegRequest : "+ regRequest);
		System.out.println("●comment : "+ comment);
		
		// 댓글 등록 후 결과를 반환
		result = dao.insertComment(comment);
		
		return result;
	}
	
}
