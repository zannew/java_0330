package com.aia.member.dao;

import java.util.List;

import com.aia.member.model.Member;


public interface MemberDao {

	// public 생략
	List<Member> selectList();

	int insertMember(Member member);
	
	Member selectByIdx(int idx);

	int editMember(Member member);
	
	int deleteMember(int idx);
	
}
