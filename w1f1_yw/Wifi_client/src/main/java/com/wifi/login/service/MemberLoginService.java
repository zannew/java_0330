package com.wifi.login.service;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wifi.login.dao.MemberDao;
import com.wifi.login.model.LoginInfo;
import com.wifi.login.model.LoginRequest;
import com.wifi.login.model.Member;

@Service
public class MemberLoginService {

	
	private MemberDao dao;
	
	@Autowired
	private SqlSessionTemplate sTemplate;

	public String login(LoginRequest loginRequest, HttpSession session, HttpServletResponse response) {
		
		dao = sTemplate.getMapper(MemberDao.class);
		
		String loginResult = "";
		
		Member member = null;
		
		member = dao.selectById(loginRequest.getId());
		
		if(member!=null) {
			LoginInfo loginInfo = new LoginInfo(
						member.getMidx(),
						member.getId(),
						member.getName(),
						member.getAddr(),
						member.getPhone()
					);
			
			session.setAttribute("loginInfo", loginInfo);
			
			loginResult = "<script>location.href=\"/wifi/index\"</script>";
			
			
		} else {
			loginResult = "<script>location.href=\"/wifi/member/memberReg\"</script>";
		}
		
		return loginResult;
	}
	
}
