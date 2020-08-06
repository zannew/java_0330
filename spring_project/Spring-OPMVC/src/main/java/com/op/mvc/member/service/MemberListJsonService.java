package com.op.mvc.member.service;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.op.mvc.member.dao.MemberDAOInterface;
import com.op.mvc.member.model.Member;

@Service
public class MemberListJsonService {

	private MemberDAOInterface dao;

	@Autowired
	private SqlSessionTemplate sTemplate;
	
	public List<Member> getMemberList(){
		
		dao = sTemplate.getMapper(MemberDAOInterface.class);
		
		return dao.selectTotalList();
	}
	
	
}
