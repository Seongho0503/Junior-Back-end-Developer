package hello.core.discount;

import hello.core.member.Grade;
import hello.core.member.Member;

public class FixDiscountPolicy implements DiscountPolicy{
// 22-04월 정책 : 무조건 1000원 할인
	
	//1000원 할인
	private int discountFixAmount = 1000;
	
	@Override
	public int discount(Member member, int price) {
		// enum은 == 쓰는 게 맞다
		// a.equals(SomeEnum.SOME_ENUM_VALUE) 써도 되지만
		// null일 때  enum 비교는 ==가 더 안전하다.
		if (member.getGrade() == Grade.VIP) {
			return discountFixAmount;
		}else {
			return 0;
		}
		
	}

}
