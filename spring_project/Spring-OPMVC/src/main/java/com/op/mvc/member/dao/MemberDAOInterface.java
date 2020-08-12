package com.op.mvc.member.dao;

import java.util.List;
import java.util.Map;

import com.op.mvc.member.model.Member;
import com.op.mvc.member.model.MemberXML;
import com.op.mvc.member.model.MemberXmlList;

public interface MemberDAOInterface {
	
	// 0806추가
	// 전체 회원리스트 - XML
	public List<MemberXML> selectTotalListXml();
	// 전체 회원리스트 - JSON
	public List<Member> selectTotalList();
	
	// 0806추가
	// idx 기반으로 검색한 회원의 정보 반환
	public Member selectByIdx(int idx);
	
	
	public Member selectByIdpw(String uid, String upw);  
	public int insertMember(Member member);

	// 전체 게시물의 개수 : 검색 포함
	public int totalCount(Map search);
	
	// 전체 게시물의 리스트 : List<Member>로 리턴
	public List<Member> selectList(Map search);	
	
	
//	trying....
	public int selectTotalCount();
	
	// 0812
	public int verify(String id, String code);
	
	// 0812
	public Member selectMemberById(String email);

}
