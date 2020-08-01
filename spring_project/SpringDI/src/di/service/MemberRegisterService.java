package di.service;

import java.util.Date;

import di.dao.MemberDao;
import di.domain.Member;
import di.domain.RegisterRequest;
import di.exception.AlreadyExistingMemberException;

public class MemberRegisterService {
	
	private MemberDao memberDao;

	// 생성자 주입 방식
	// public :  반드시! 아니면 메서드가 호출할 수 없다.
	public MemberRegisterService(MemberDao memberDao) {
		this.memberDao = memberDao;
	}

	public void regist(RegisterRequest req) throws AlreadyExistingMemberException {
		
		Member member = memberDao.selectByEmail(req.getEmail());
		
		if (member != null) {
			throw new AlreadyExistingMemberException("dup email " + req.getEmail());
		}
		
		Member newMember = new Member(req.getEmail(), req.getPassword(), req.getName(), new Date());
		memberDao.insert(newMember);
	}

}
