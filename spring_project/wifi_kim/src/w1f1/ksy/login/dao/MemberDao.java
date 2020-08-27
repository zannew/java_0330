package w1f1.ksy.login.dao;

import w1f1.ksy.login.model.Member;

public interface MemberDao {
	
	public int insertMember(Member member);
	
	public Member selectByMidx(int midx);
	
	public Member selectById(String id);
	
	public int selectByName(String name);

	
	
}
