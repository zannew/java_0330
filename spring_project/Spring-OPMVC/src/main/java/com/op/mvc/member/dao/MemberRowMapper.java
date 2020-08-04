package com.op.mvc.member.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.op.mvc.member.model.Member;

public class MemberRowMapper implements RowMapper<Member> {

	@Override
	public Member mapRow(ResultSet rs, int rowNum) throws SQLException {

		Member member = new Member();
		
		member.setIdx(rs.getInt("idx"));
		member.setUid(rs.getNString("uid"));
		member.setUpw(rs.getNString("upw"));
		member.setUname(rs.getNString("uname"));
		member.setUphoto(rs.getNString("uphoto"));
		member.setRegdate(rs.getDate("regdate"));
		
		
		return member;
	}

}
