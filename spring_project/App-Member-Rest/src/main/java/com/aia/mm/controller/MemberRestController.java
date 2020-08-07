package com.aia.mm.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.aia.mm.model.Member;
import com.aia.mm.model.MemberDelRequest;
import com.aia.mm.model.MemberEditRequest;
import com.aia.mm.model.MemberRegRequest;
import com.aia.mm.service.MemberDeleteService;
import com.aia.mm.service.MemberEditService;
import com.aia.mm.service.MemberListService;
import com.aia.mm.service.MemberRegService;
import com.aia.mm.service.MemberViewService;

@RestController
@RequestMapping("/members")			//	ex) /members?pageNum=1&cnt=10
public class MemberRestController {

	@Autowired
	private MemberListService listService;
	@Autowired
	private MemberRegService regService;
	@Autowired
	private MemberViewService viewService;
	@Autowired
	private MemberEditService editService;
	@Autowired
	private MemberDeleteService deleteService;
	
	
	// 회원의 리스트 : JSON으로 응답
	@GetMapping			// GET방식으로 들어올 때만 처리하는 메서드 : GET| /members
	public List<Member> getMemberList(){
		
		return listService.getMemberList();
	}
	
	// 회원가입의 결과를 반환
	@PostMapping		// POST방식으로 들어올 때만 처리하는 메서드 : POST| /members
	public int reg(MemberRegRequest regRequest, HttpServletRequest request) {
		
		return regService.regMember(regRequest, request);
	}
	
	
	// 한 명의 회원 정보 보기 - 경로(idx) 필요 → @PathVariable
	@GetMapping("/{idx}")
	public Member getMember(@PathVariable("idx") int idx) {
		
		return viewService.getMember(idx);
	}
	
	
	// 한 명의 회원 정보 수정 - 경로(idx) 필요  → @PathVariable
	// PUT방식으로 처리하는 메서드 : PUT| /members/{idx}
	//@PostMapping("/{idx}")
	@PutMapping("/{idx}")
	public int edit(@PathVariable("idx") int idx,
				MemberEditRequest editRequest,
				HttpServletRequest request
			) {
	
		editRequest.setIdx(idx);
		
		return editService.editMember(editRequest, request);
	}
	
	
	// 한 명의 회원 정보 삭제 - 경로(idx) 필요  → @PathVariable		
	// DELETE방식으로 처리하는 메서드 : DELETE| /members/{idx}
	@DeleteMapping("/{idx}")
	public int delete(@PathVariable("idx") int idx) {
		
		return deleteService.deleteMember(idx);
	}
	
}
