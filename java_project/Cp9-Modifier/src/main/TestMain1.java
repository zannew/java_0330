package main;

import ex.Member;	//Member클래스가 default상태 : import불가능

public class TestMain1 {

	public static void main(String[] args) {
		
		Member member = new Member();	
		//Member클래스의 생성자가 default상태
		
		System.out.println(member.getId());
		System.out.println(member.getName());
		
	}
	
}
