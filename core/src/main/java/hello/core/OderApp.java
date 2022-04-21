package hello.core;

import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;

public class OderApp {
	
	public static void main(String[] args) {
		
		MemberService memberService = new MemberServiceImpl();
		OrderService oderService = new OrderServiceImpl();
		
		Long memberId = 1L;
		
	}
}
