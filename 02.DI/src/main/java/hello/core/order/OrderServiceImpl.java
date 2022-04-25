package hello.core.order;

import hello.core.discount.DiscountPolicy;
//import hello.core.discount.RateDiscountPolicy; 구현체 import 
import hello.core.member.Member;
import hello.core.member.MemberRepository;
import hello.core.member.MemoryMemberRepository;

// 주문 -> (id 조회, 할인 조회)
public class OrderServiceImpl implements OrderService {
	
	private final MemberRepository memberRepository;
	private DiscountPolicy discountPolicy;
	
	// 생성자를 통해 할당
	public OrderServiceImpl(MemberRepository memberRepository, DiscountPolicy discountPolicy) {
		super();
		this.memberRepository = memberRepository;
		this.discountPolicy = discountPolicy;
	}

	//멤버 레포지터리에서 회원 찾기
	//private final MemberRepository memberRepository = new MemoryMemberRepository();
	
	/*--------------- 구현체에 의존 [DIP, OCP 위반]----------------------- */
	//고정 할인금액 찾기
	//private final DiscountPolicy discountPolicy = new FixDiscountPolicy();
	
	// 정율할인 (10%)
	//private final DiscountPolicy discountPolicy = new RateDiscountPolicy();

	
    /*------------------- 인터페이스(추상화)에만 의존   --------------------------*/
	// => 구현체가 없어서 nullpointException 뜬다 
	// final 있으면 무조건 값을 할당해야해서 없앤다. 
	//private DiscountPolicy discountPolicy;
	
	@Override
	public Order createOrder(Long memberId, String itemName, int itemPrice) {
		// TODO Auto-generated method stub
		// 일단 멤버를 찾고
		Member member = memberRepository.findById(memberId);
		// discountpolicy에 일단 멤버 넘겨서 할인 금액 알아보기 (할인정책에 일단 회원을 넘기고) -> 할인금액, 멤버등급 반환은 프로젝트 상황에따라 개발자가 고민할 문제
		int discountPrice = discountPolicy.discount(member, itemPrice);
		                    // null인 discountPolicy에 점을 찍어서 nullpointException 뜬다   		
		
		// 주문을 만들어서 반환
		return new Order(memberId, itemName, itemPrice, discountPrice);
	}

}
