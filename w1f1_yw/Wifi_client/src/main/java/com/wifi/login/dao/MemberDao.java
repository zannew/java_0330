package com.wifi.login.dao;

import com.wifi.login.model.Member;

public interface MemberDao {

	Member selectById(String id);	

	int insertMember(Member member);
	
}
