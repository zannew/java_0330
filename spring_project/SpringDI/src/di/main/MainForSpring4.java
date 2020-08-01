package di.main;

import java.util.Scanner;

import org.springframework.context.support.GenericXmlApplicationContext;

import di.domain.RegisterRequest;
import di.exception.AlreadyExistingMemberException;
import di.exception.IdPasswordNotMatchingException;
import di.exception.MemberNotFoundException;
import di.service.ChangePasswordService2;
import di.service.MemberRegisterService2;

public class MainForSpring4 {
	
	private static GenericXmlApplicationContext ctx = null;
	//scope 비교 :  singleton & prototype
	public static void main(String[] args) {
		
		ctx = new GenericXmlApplicationContext("classpath:appCtx7.xml");

		MemberRegisterService2 mrService1 = ctx.getBean("memberregSvc", MemberRegisterService2.class);
		MemberRegisterService2 mrService2 = ctx.getBean("memberregSvc", MemberRegisterService2.class);
		
		// prototype으로 생성된 빈 객체 - 빈을 요청할 때마다 새롭게 생성한다.
		boolean chk1 = mrService1==mrService2;
		System.out.println("mrService1==mrService2 → "+chk1);
		
		System.out.println("-------------------------------------------------------------------");
		
		ChangePasswordService2 cpService1 = ctx.getBean("memberPwSvc", ChangePasswordService2.class);
		ChangePasswordService2 cpService2 = ctx.getBean("memberPwSvc", ChangePasswordService2.class);
	
		// singleton으로 생성된 빈 객체 - 컨테이너에 하나의 객체만 생성된다.
		boolean chk2 = cpService1==cpService2;
		System.out.println("cpService1==cpService2 → "+chk2);
		
		
		
		
	}


}
