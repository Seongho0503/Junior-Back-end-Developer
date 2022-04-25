package hello.core.order;

import hello.core.discount.DiscountPolicy;
import hello.core.discount.FixDiscountPolicy;
import hello.core.member.Member;
import hello.core.member.MemberRepository;
import hello.core.member.MemoryMemberRepository;

// �ֹ� -> (id ��ȸ, ���� ��ȸ)
public class OderServiceImpl implements OderService {
	
	//��� �������͸����� ȸ�� ã��
	private final MemberRepository memberRepository = new MemoryMemberRepository();
	
	//���� ���αݾ� ã��
	private final DiscountPolicy discountPolicy = new FixDiscountPolicy();

	@Override
	public Order createOrder(Long memberId, String itemName, int itemPrice) {
		// TODO Auto-generated method stub
		// �ϴ� ����� ã��
		Member member = memberRepository.findById(memberId);
		// discountpolicy�� �ϴ� ��� �Ѱܼ� ���� �ݾ� �˾ƺ��� (������å�� �ϴ� ȸ���� �ѱ��) -> ���αݾ�, ������ ��ȯ�� ������Ʈ ��Ȳ������ �����ڰ� ����� ����
		int discountPrice = discountPolicy.discount(member, itemPrice);
		
		// �ֹ��� ���� ��ȯ
		return new Order(memberId, itemName, itemPrice, discountPrice);
	}

}
