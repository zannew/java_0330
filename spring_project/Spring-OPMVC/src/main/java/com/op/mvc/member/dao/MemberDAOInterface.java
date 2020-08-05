package com.op.mvc.member.dao;

import java.util.List;
import java.util.Map;

import com.op.mvc.member.model.Member;

public interface MemberDAOInterface {
	
	public Member selectByIdpw(String uid, String upw);  
	public int insertMember(Member member);

	// 전체 게시물의 개수 : 검색 포함
	public int totalCount(Map search);
	
	// 전체 게시물의 리스트 : List<Member>로 리턴
	public List<Member> selectList(Map search);	
	
//	trying....
	public int selectTotalCount();

}
