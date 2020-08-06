package com.op.mvc.member.controller;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.op.mvc.member.service.MemberViewService;

@Controller
public class MemberViewController {

	@Inject
	private MemberViewService viewService;
	
	
	// ex) http://localhost:8080/opmvc/member/view/12
	@RequestMapping("/member/view/{idx}")
	public String getMemberInfo(@PathVariable("idx") int idx, Model model) {
		
		model.addAttribute("member", viewService.getMemberInfo(idx));
		
		return "member/memberView";
	}
	
}
