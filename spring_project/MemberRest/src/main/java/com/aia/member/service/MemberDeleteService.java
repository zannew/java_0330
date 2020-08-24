package com.aia.member.service;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aia.member.dao.MemberDao;


@Service
public class MemberDeleteService {

	private MemberDao dao;
	
	@Autowired
	private SqlSessionTemplate sTemplate;
	
	
	public int deleteMember(int idx) {
		
		dao = sTemplate.getMapper(MemberDao.class);
		
		return dao.deleteMember(idx);
	}
	
	
	
}
