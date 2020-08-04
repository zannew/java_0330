package com.op.mvc.member.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.op.mvc.member.dao.JdbcTemplateMemberDAO;

@Service
public class MemberListService {

	@Autowired
	JdbcTemplateMemberDAO dao;
	
	
}
