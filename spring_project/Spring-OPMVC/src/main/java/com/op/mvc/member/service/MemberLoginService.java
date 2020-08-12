package com.op.mvc.member.service;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;

import com.op.mvc.member.dao.MemberDAOInterface;
import com.op.mvc.member.model.LoginInfo;
import com.op.mvc.member.model.LoginRequest;
import com.op.mvc.member.model.Member;
import com.op.mvc.util.CookieBox;

import org.springframework.stereotype.Service;

@Service
public class MemberLoginService {

//	@Autowired
//	MemberDAO dao;

	private MemberDAOInterface dao;
	
	@Autowired
	private SqlSessionTemplate sessionTemplate;
	
	public String login(
			LoginRequest loginRequest, 
			HttpSession session, 
			HttpServletResponse response) {

		// interface의 Mapper객체 생성
		// type : MemberDAOInterface로 넣으면 MybatisMemberDAO에 있는 sql처리를 만들어 줄 수 있다.
		dao = sessionTemplate.getMapper(MemberDAOInterface.class);
		
		String loginResult = "";

		// 로그인 처리
		Member member = null;

			
			member = dao.selectByIdpw(loginRequest.getUid(), loginRequest.getUpw());

			System.out.println("LoginService Member : " + member);

			if (member != null && member.getVerify() == 'Y') {

				LoginInfo loginInfo = new LoginInfo(member.getUid(), member.getUname(), member.getUphoto());

				session.setAttribute("loginInfo", loginInfo);

				// 쿠키 설정에 사용한 변수
				String cookieName = "uid";
				String cookiepath = session.getServletContext().getContextPath();

				// 회원 아이디 쿠키 설정
				if (loginRequest.getRemember() != null) {
					response.addCookie(CookieBox.createCookie(cookieName, loginRequest.getUid(), cookiepath, 60 * 60 * 24 * 365));
				} else {
					response.addCookie(CookieBox.createCookie(cookieName, loginRequest.getUid(), cookiepath, 0));
				}

				// 로그인 이 필요했던 이전 페이지
				loginResult = "<script>" + "alert('로그인되었습니다.');" + "location.href='" + loginRequest.getRedirecUri() + "'" + "</script>";
				

			} else if(member != null && member.getVerify() == 'N') {

				loginResult = "<script>"; 
				loginResult += "	if(confirm('회원 가입 후 메일인증이 안되었습니다.\n인증메일을 다시 보내시겠습니까?')) {";
				loginResult += "		$.ajax(\'../member/verify/reMailSend?email="+member.getUid()+"\',{})";
				loginResult += "	}";
				loginResult += "	location.href=\'" + loginRequest.getRedirecUri() + "\';"; 
				loginResult += "</script>";
				
			} else {
				loginResult = "<script>" + "alert('아이디 또는 비밀번호가 틀립니다.');" + "history.go(-1);" + "</script>";
			}

		return loginResult;

	}

}
