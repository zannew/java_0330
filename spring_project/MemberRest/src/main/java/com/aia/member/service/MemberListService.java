package com.aia.member.service;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aia.member.dao.MemberDao;
import com.aia.member.model.Member;


@Service
public class MemberListService {

	private MemberDao dao;
	
	@Autowired
	private SqlSessionTemplate sTemplate;
	
	public List<Member> getMemberList(){
		
		dao = sTemplate.getMapper(MemberDao.class);
		
		return dao.selectList();
	}
	
	
}
