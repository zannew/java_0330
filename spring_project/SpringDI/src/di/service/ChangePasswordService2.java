package di.service;

import di.dao.Dao;
import di.domain.Member;
import di.exception.IdPasswordNotMatchingException;
import di.exception.MemberNotFoundException;

public class ChangePasswordService2 {
	
	private Dao dao;
	
	// 메서드 주입 방식
	// public :  반드시! 아니면 메서드가 호출할 수 없다.
	public void setDao(Dao dao) {
		this.dao=dao;
	}


	public void changePassword(String email, String oldPwd, String newPwd) throws IdPasswordNotMatchingException, MemberNotFoundException {
		Member member = dao.selectByEmail(email);
		if (member == null)
			throw new MemberNotFoundException();

		member.changePassword(oldPwd, newPwd);

		dao.update(member);
	}

}
