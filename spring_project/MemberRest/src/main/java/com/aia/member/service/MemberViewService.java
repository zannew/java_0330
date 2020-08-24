package com.aia.member.service;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aia.member.dao.MemberDao;
import com.aia.member.model.Member;


@Service
public class MemberViewService {

	private MemberDao dao;

	@Autowired
	private SqlSessionTemplate sTemplate;
	
	public Member getMember(int idx) {
		
		dao = sTemplate.getMapper(MemberDao.class);
		
		return dao.selectByIdx(idx);
	}
	
	
	
}
