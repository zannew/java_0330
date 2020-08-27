package w1f1.ksy.login.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import w1f1.ksy.login.model.MemberRegRequest;
import w1f1.ksy.login.service.MemberRegService;

@Controller
@RequestMapping("/member/memberReg")
public class MemberRegController {
	
	@Autowired
	private MemberRegService regService;
	
	@RequestMapping(method = RequestMethod.GET)
	public String getMemberRegForm() {
		return "member/memberRegForm";	
		}
	
	@RequestMapping(method = RequestMethod.POST)
	public String getMemberReg(
			MemberRegRequest regRequest,
			HttpServletRequest request,
			Model model
			) {
		
		System.out.println("컨트롤러 확인 : >>>>>>>>> " + regRequest);
		
		model.addAttribute("result", regService.memberReg(regRequest, request));
		
		return "member/memberReg";
	}
	
}
