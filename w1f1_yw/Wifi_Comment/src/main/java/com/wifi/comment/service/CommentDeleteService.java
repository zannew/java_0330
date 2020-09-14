package com.wifi.comment.service;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wifi.comment.dao.CommentDao;

@Service
public class CommentDeleteService {

	private CommentDao dao;
	
	@Autowired
	private SqlSessionTemplate sTemplate;
	
	public int deleteComment(int cidx) {
		
		dao=sTemplate.getMapper(CommentDao.class);
		
		int result = dao.deleteComment(cidx);
		
		return result;
	}

}
