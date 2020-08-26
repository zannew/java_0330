package com.wifi.login.dao;

import com.wifi.login.model.Member;

public interface MemberDao {

	public Member selectById(String id);
	
}
