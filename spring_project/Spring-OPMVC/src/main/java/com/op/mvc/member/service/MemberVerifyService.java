package com.op.mvc.member.service;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.op.mvc.member.dao.MemberDAOInterface;
import com.op.mvc.member.model.Member;

@Service("verifyService")
public class MemberVerifyService {
	
	@Autowired
	private MailSenderService mailService;

	@Autowired
	private SqlSessionTemplate template;
	
	private MemberDAOInterface dao;
	
	public String verify(String id, String code) {
		
		dao = template.getMapper(MemberDAOInterface.class);
		
		int rCnt = dao.verify(id, code);
		
		return rCnt>0?"Success":"Fail";
	}

	// 메일 재 발송 요청 
	public int reMailSend(String email) {
				
		dao = template.getMapper(MemberDAOInterface.class);
		
		System.out.println("email : " + email);
		
		Member member = dao.selectMemberById(email);
		System.out.println("check : " + member);
		
		mailService.reSend(member.getUid(), member.getCode());
		
		
		return 1;
	}
	
	

}