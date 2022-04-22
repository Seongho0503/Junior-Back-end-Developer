package hello.core;

import hello.core.member.Grade;
import hello.core.member.Member;
import hello.core.member.MemberService;
import hello.core.order.Order;
import hello.core.order.OrderService;

public class OrderApp {
	
	public static void main(String[] args) {
		
		AppConfig appConfig = new AppConfig();
		MemberService memberService = appConfig.memberService();
		OrderService orderService = appConfig.orderService();
		
		//MemberService memberService = new MemberServiceImpl();
		//OrderService orderService = new OrderServiceImpl();
		
		Long memberId = 1L;
		// VIP 회원 하나 만들기
		Member member = new Member(memberId, "memberA", Grade.VIP);
		// 가입 -> 레포지터리에  넣기
		memberService.join(member);
		
		// Oder 생성
		Order order = orderService.createOrder(memberId, "itemA", 50000);
		
		System.out.println("order = " + order);
		System.out.println("order.calculatePrice = " + order.calculatePrice());
		
	}
}
