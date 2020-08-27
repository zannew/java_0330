package w1f1.ksy.login.service;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import w1f1.ksy.login.dao.MemberDao;
import w1f1.ksy.login.model.LoginInfo;
import w1f1.ksy.login.model.LoginRequest;
import w1f1.ksy.login.model.Member;

@Service
public class MemberLoginService {
	
	private MemberDao dao;
	
	@Autowired
	private SqlSessionTemplate template;
	
	public String login(
			LoginRequest loginRequest,
			HttpSession session,
			HttpServletResponse response
			) {
	
		dao = template.getMapper(MemberDao.class);
		
		String loginResult = "";
		
		Member member = null;
		
		member = dao.selectById(loginRequest.getId());
		System.out.println("로그인 서비스 멤버 정보 : " + member);
		
		if(member != null) {
			
			LoginInfo loginInfo = new LoginInfo(
					member.getMidx(),
					member.getId(),
					member.getName(),
					member.getAddr(),
					member.getPhone()
					);
			
			session.setAttribute("loginInfo", loginInfo);
			
			// 쿠키설정은 나중에
			
			// 로그인 성공 시
			loginResult = "<script>location.href=\"/wifi/index\"</script>";
		} else {
			// DB에 email 정보가 저장되어있지 않을 시
			loginResult = "<script>location.href=\"/wifi/member/memberReg\"</script>";
		}
		
		
		return loginResult;
	}
	
	
}
