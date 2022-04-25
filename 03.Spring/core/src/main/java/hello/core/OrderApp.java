package hello.core;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import hello.core.member.Grade;
import hello.core.member.Member;
import hello.core.member.MemberService;
import hello.core.order.Order;
import hello.core.order.OrderService;

public class OrderApp {
	
	public static void main(String[] args) {
		
		/*
		 * ApplicationContext 는 스프링 컨테이너라 부른다.
		 */
		
		ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
		
		MemberService memberService = applicationContext.getBean("memberService", MemberService.class);
		OrderService orderService = applicationContext.getBean("orderService", OrderService.class);
		
		//AppConfig appConfig = new AppConfig();
		//MemberService memberService = appConfig.memberService();
		//OrderService orderService = appConfig.orderService();
		
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
