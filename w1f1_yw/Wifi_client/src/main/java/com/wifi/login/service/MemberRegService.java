package com.wifi.login.service;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wifi.login.dao.MemberDao;
import com.wifi.login.model.Member;
import com.wifi.login.model.MemberRegRequest;

@Service
public class MemberRegService {

	private MemberDao dao;
	
	@Inject
	SqlSessionTemplate sTemplate;
	
	
	public String regMember(MemberRegRequest regRequest, HttpServletRequest request) {
		
		int result = 0;
		String regResult="";
		
		System.out.println("S-dao : "+dao);
		System.out.println("S-sTemplate : "+sTemplate);
		System.out.println("S-regRequest : "+regRequest);
		System.out.println("S-request : "+request);
		
		dao = sTemplate.getMapper(MemberDao.class);
		
		Member member = regRequest.toMember();
		
		System.out.println("member체크 : "+member);
		
		result = dao.insertMember(member);
		
		//가입 성공
		if(result>0) {
			regResult="<script>alert('성공적으로 가입되었습니다.'); location.href=\"/wifi/member/loginForm\"</script>";
		} else {
			regResult="<script>alert('가입에 실패하셨습니다.'); history.go(-1);</script>";
		} 
		
		return regResult;
		
	}
	
}
