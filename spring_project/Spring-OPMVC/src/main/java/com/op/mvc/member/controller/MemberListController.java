package com.op.mvc.member.controller;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import com.op.mvc.member.service.MemberListService;

@Controller
public class MemberListController {

	@Autowired
	MemberListService listService;
	
	//요청한 url
	@RequestMapping("/member/memberList")
	public String getMemberList(HttpServletRequest request, HttpServletResponse response, Model model) throws SQLException {
		
		model.addAttribute("listView", listService.getView(request, response));
		
		return "member/memberList";
	}
	
	
}
