package hello.core.discount;

import hello.core.member.Grade;
import hello.core.member.Member;

public class FixDiscountPolicy implements DiscountPolicy{
// 22-04�� ��å : ������ 1000�� ����
	
	//1000�� ����
	private int discountFixAmount = 1000;
	
	@Override
	public int discount(Member member, int price) {
		// enum�� == ���� �� �´�
		// a.equals(SomeEnum.SOME_ENUM_VALUE) �ᵵ ������
		// null�� ��  enum �񱳴� ==�� �� �����ϴ�.
		if (member.getGrade() == Grade.VIP) {
			return discountFixAmount;
		}else {
			return 0;
		}
		
	}

}
