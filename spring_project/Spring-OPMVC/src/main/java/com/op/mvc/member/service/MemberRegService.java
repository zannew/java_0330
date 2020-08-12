package com.op.mvc.member.service;

import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.op.mvc.jdbc.ConnectionProvider;
import com.op.mvc.member.dao.MemberDAO;
import com.op.mvc.member.dao.MemberDAOInterface;
import com.op.mvc.member.dao.MybatisMemberDAO;
import com.op.mvc.member.model.Member;
import com.op.mvc.member.model.MemberRegRequest;

@Service
public class MemberRegService {

//	@Autowired
//	MemberDAO dao;
	
//	@Autowired
//	MybatisMemberDAO dao;

	private MemberDAOInterface dao;
	
	@Autowired
	private SqlSessionTemplate sessionTemplate;
	
	//2020.08.11 변경
	@Autowired
	private MailSenderService mailService;
	
	public int memberReg(HttpServletRequest request, MemberRegRequest regRequest) {

		
		dao = sessionTemplate.getMapper(MemberDAOInterface.class);
		
		// 1. 파일 업로드 - 사진 (binary file) : 특정 경로에 사진을 저장
		// 2. 사용자 데이터를 받기 - uid, upw, uname, photo
		// 1과 2를 받고 2는 DB에 저장

		int result = 0;

		// 데이터베이스에 입력할 데이터 변수
		Member member = regRequest.toMember(); 
		
		System.out.println("입력 전 idx ▶ "+member.getIdx());

		try {
			
			MultipartFile fileItem = regRequest.getPhoto();
			
			System.out.println("service확인용 : "+regRequest);
			
			System.out.println("fileItem : "+fileItem.getOriginalFilename());
			
			
			//서버 내부 경로
			String uri = request.getSession().getServletContext().getInitParameter("memberUploadPath");
			// 시스템의 실제(절대)경로
			String realPath = request.getSession().getServletContext().getRealPath(uri);
			System.out.println("real path : "+realPath);
			
			System.out.println("fileItem : "+fileItem.getOriginalFilename());
			// Tokenizing 활용 시 → 확장자명 제거 후 새로운 파일 이름 생성 가능
			String newFileName = System.nanoTime() + "_" + fileItem.getOriginalFilename();
			
			
			
			// 서버의 저장소에 실제 저장
			File saveFile = new File(realPath, newFileName);
			
			fileItem.transferTo(saveFile);
		
			member.setUphoto(newFileName);

			//result = dao.insertMember(conn, member); mybatis에서 conn 필요 없음
			result = dao.insertMember(member);
			
			System.out.println("입력 후 idx ▶ "+ member.getIdx());
			

			// 메일 발송
			// 2020.08.11 변경
			mailService.send(member.getUid(), member.getCode());
			
			
		} catch (IllegalStateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			
		}
		

		return result;
	}

}
