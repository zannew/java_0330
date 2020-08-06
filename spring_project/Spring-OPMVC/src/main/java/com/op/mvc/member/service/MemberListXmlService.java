package com.op.mvc.member.service;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.op.mvc.member.dao.MemberDAOInterface;
import com.op.mvc.member.model.MemberXML;
import com.op.mvc.member.model.MemberXmlList;

@Service
public class MemberListXmlService {

	private MemberDAOInterface dao;
	
	@Autowired
	private SqlSessionTemplate sTemplate;
	
	public MemberXmlList getXmlList() {
		
		dao = sTemplate.getMapper(MemberDAOInterface.class);
		
		List<MemberXML> memberList = dao.selectTotalListXml();
		
		MemberXmlList list = new MemberXmlList(memberList);
		
		//MemberXmlList list = new MemberXmlList(dao.selectTotalListXml());
		
		return list;
	}
	
	
}
