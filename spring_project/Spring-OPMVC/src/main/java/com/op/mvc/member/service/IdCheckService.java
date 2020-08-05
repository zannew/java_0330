package com.op.mvc.member.service;

import java.sql.Connection;
import java.sql.SQLException;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.op.mvc.jdbc.ConnectionProvider;
import com.op.mvc.member.dao.MemberDAO;
import com.op.mvc.member.dao.MybatisMemberDAO;

@Service
public class IdCheckService {

	@Autowired
	MemberDAO dao;
	
//	@Autowired
//	MybatisMemberDAO dao;
	
	public String IdCheck(String uid) {
		
		// request에 결과갑 Y|N만 보내주면 ok
		//boolean check = false;
		String result = "N";
		
		
		Connection conn = null;
		
		try {
			conn = ConnectionProvider.getConnection();
			int resultCnt = dao.selectById(conn, uid);
			
			if(resultCnt==0) {
				result = "Y";
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return result;
	}
	
	
}
