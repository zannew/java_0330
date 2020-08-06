package com.op.mvc.member.controller;

import java.sql.SQLException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.op.mvc.member.model.Member;
import com.op.mvc.member.model.MemberXmlList;
import com.op.mvc.member.service.MemberListJsonService;
import com.op.mvc.member.service.MemberListService;
import com.op.mvc.member.service.MemberListXmlService;

@Controller
public class MemberListController {

	@Autowired
	MemberListService listService;
	
	@Autowired
	MemberListXmlService xmlListService;
	
	@Autowired
	MemberListJsonService jsonListService;
	
	//요청한 url
	@RequestMapping("/member/memberList")
	public String getMemberList(HttpServletRequest request, HttpServletResponse response, Model model) throws SQLException {
		
		model.addAttribute("listView", listService.getView(request, response));
		
		return "member/memberList";
	}
	
	@RequestMapping("/member/memberList.xml")
	@ResponseBody
	public MemberXmlList getMemberXml() {
		
		return xmlListService.getXmlList();
	}
	
	@RequestMapping("/member/memberList.json")
	@ResponseBody
	public List<Member> getMemberJson(){
		
		return jsonListService.getMemberList();
	}
	
	
	
}
