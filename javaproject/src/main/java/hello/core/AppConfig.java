package hello.core;

import hello.core.discount.DiscountPolicy;
import hello.core.discount.RateDiscountPolicy;
import hello.core.member.MemberRepository;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;
import hello.core.member.MemoryMemberRepository;
import hello.core.order.OrderService;
import hello.core.order.OrderServiceImpl;

// ���ø����̼� ��ü�� �����ϰ� ������
// �������̽��� ����ü�� ����
public class AppConfig {
	
	private MemberRepository memberRepository() {
		return new MemoryMemberRepository();
	}
	
	public MemberService memberService() {
		return new MemberServiceImpl(memberRepository()); 
		// new ��  �ؿ� �ߺ��̶� ����
		//return new MemberServiceImpl(new MemoryMemberRepository());
	}
	
	public OrderService orderService() {
		return new OrderServiceImpl(memberRepository(), discountPolicy());
		//return new OrderServiceImpl(new MemoryMemberRepository(), new FixDiscountPolicy());
	}
	
	public DiscountPolicy discountPolicy() {
		return new RateDiscountPolicy();
		//return new FixDiscountPolicy(); 
		//��������
		
	}
	

}
