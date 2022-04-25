package hello.core;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import hello.core.discount.DiscountPolicy;
import hello.core.discount.RateDiscountPolicy;
import hello.core.member.MemberRepository;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;
import hello.core.member.MemoryMemberRepository;
import hello.core.order.OrderService;
import hello.core.order.OrderServiceImpl;

// 애플리케이션 전체를 설정하고 구성함
// 인터페이스의 구현체를 설정

@Configuration
public class AppConfig {
	
	@Bean
	public MemberRepository memberRepository() {
		return new MemoryMemberRepository();
	}
	
	@Bean
	public MemberService memberService() {
		return new MemberServiceImpl(memberRepository()); 
		// new 가  밑에 중복이라 없앰
		//return new MemberServiceImpl(new MemoryMemberRepository());
	}
	
	@Bean
	public OrderService orderService() {
		return new OrderServiceImpl(memberRepository(), discountPolicy());
		//return new OrderServiceImpl(new MemoryMemberRepository(), new FixDiscountPolicy());
	}
	
	@Bean
	public DiscountPolicy discountPolicy() {
		return new RateDiscountPolicy();
		//return new FixDiscountPolicy(); 
		//고정할인
		
	}

}
