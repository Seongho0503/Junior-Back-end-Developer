package hello.core.discount;

// static ���� ���� �� ���� �ִ� Assertions
import static org.assertj.core.api.Assertions.assertThat;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import hello.core.member.Grade;
import hello.core.member.Member;


// �׽�Ʈ�� ���� ���� ���� �׽�Ʈ �Ӹ� �ƴ϶� ���� �׽�Ʈ�� �� �������Ѵ�.
public class RateDiscountPolicyTest {
	
	RateDiscountPolicy discountPolicy = new RateDiscountPolicy();

	@Test
	@DisplayName("[VIP.10%.����.����]VIP�� 10% ������ ����Ǿ�� �Ѵ�.")
	//vip_o
	void vip_success() {
	
	//given
	Member member =	new Member( 1L, "memberVIP" , Grade.VIP );
	
	//when
	int discount = discountPolicy.discount(member, 10000);
	
	// then (when���� ���� �ݾ��� ���� �ְ� , given���� ����� VIP�̴ϱ� 10% ���ε� �ݾ��� õ���� ���;���)
	Assertions.assertThat(discount).isEqualTo(1000);
		
	}
	
	@Test
	@DisplayName("VIP �ƴϸ� ������ ������� �ʾƾ� �Ѵ� ")
	//vip_x
	void vip_fail() {
		//given
		Member member =	new Member( 2L, "memberBASIC" , Grade.BASIC );
		
		//when
		int discount = discountPolicy.discount(member, 10000);
		
		// then (when���� ���� �ݾ��� ���� �ְ� , given���� ����� BASIC�̴ϱ� ������ �Ǹ� �ȵǴϱ� 0���� ���;���)
		Assertions.assertThat(discount).isEqualTo(1000);	
	}
	
	@Test
	@DisplayName("BASIC/����/X/����")

	void basic_success() {
		// given
		Member member = new Member(2L, "memberBASIC", Grade.BASIC);

		// when
		int discount = discountPolicy.discount(member, 10000);

		// then (when���� ���� �ݾ��� ���� �ְ� , given���� ����� BASIC�̴ϱ� ������ �Ǹ� �ȵǴϱ� 0���� ���;���)
		assertThat(discount).isEqualTo(0);
	}
}
