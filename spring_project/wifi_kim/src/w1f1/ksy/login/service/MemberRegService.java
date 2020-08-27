package w1f1.ksy.login.service;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import w1f1.ksy.login.dao.MemberDao;
import w1f1.ksy.login.model.Member;
import w1f1.ksy.login.model.MemberRegRequest;

@Service
public class MemberRegService {

	private MemberDao dao;
	
	@Inject
	SqlSessionTemplate template;
	
	
	public String memberReg(
			MemberRegRequest regRequest,
			HttpServletRequest request
			) {
		
		int result = 0;
		String regResult = "";
		
		dao = template.getMapper(MemberDao.class);
				
		Member member = regRequest.toMember();
		
		result = dao.insertMember(member);
		
		if(result != 0) {
			
			// 회원가입 성공 시
			regResult = "<script>" + "alert('가입이 완료되었습니다.');" + "location.href=\"/wifi/member/loginForm\"</script>";
		} else {
			
			// 회원가입 실패 시
			regResult = "<script>" + "alert('가입에 실패했습니다.');" + "history.go(-1);" + "</script>";
		}
		
		System.out.println(member);
		
		return regResult; 
	}
}
