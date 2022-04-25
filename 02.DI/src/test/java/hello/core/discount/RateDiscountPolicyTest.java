package hello.core.discount;

// static 으로 빼서 쓸 수도 있다 Assertions
import static org.assertj.core.api.Assertions.assertThat;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import hello.core.member.Grade;
import hello.core.member.Member;


// 테스트를 만들 때는 성공 테스트 뿐만 아니라 실패 테스트도 꼭 만들어야한다.
public class RateDiscountPolicyTest {
	
	RateDiscountPolicy discountPolicy = new RateDiscountPolicy();

	@Test
	@DisplayName("[VIP.10%.할인.성공]VIP는 10% 할인이 적용되어야 한다.")
	//vip_o
	void vip_success() {
	
	//given
	Member member =	new Member( 1L, "memberVIP" , Grade.VIP );
	
	//when
	int discount = discountPolicy.discount(member, 10000);
	
	// then (when에서 물건 금액을 만원 넣고 , given에서 멤버가 VIP이니깐 10% 할인된 금액인 천원이 나와야함)
	Assertions.assertThat(discount).isEqualTo(1000);
		
	}
	
	@Test
	@DisplayName("VIP 아니면 할인이 적용되지 않아야 한다 ")
	//vip_x
	void vip_fail() {
		//given
		Member member =	new Member( 2L, "memberBASIC" , Grade.BASIC );
		
		//when
		int discount = discountPolicy.discount(member, 10000);
		
		// then (when에서 물건 금액을 만원 넣고 , given에서 멤버가 BASIC이니깐 할인이 되면 안되니깐 0원이 나와야함)
		Assertions.assertThat(discount).isEqualTo(1000);	
	}
	
	@Test
	@DisplayName("BASIC/할인/X/성공")

	void basic_success() {
		// given
		Member member = new Member(2L, "memberBASIC", Grade.BASIC);

		// when
		int discount = discountPolicy.discount(member, 10000);

		// then (when에서 물건 금액을 만원 넣고 , given에서 멤버가 BASIC이니깐 할인이 되면 안되니깐 0원이 나와야함)
		assertThat(discount).isEqualTo(0);
	}
}
