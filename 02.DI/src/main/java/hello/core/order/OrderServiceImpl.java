package hello.core.order;

import hello.core.discount.DiscountPolicy;
//import hello.core.discount.RateDiscountPolicy; ����ü import 
import hello.core.member.Member;
import hello.core.member.MemberRepository;
import hello.core.member.MemoryMemberRepository;

// �ֹ� -> (id ��ȸ, ���� ��ȸ)
public class OrderServiceImpl implements OrderService {
	
	private final MemberRepository memberRepository;
	private DiscountPolicy discountPolicy;
	
	// �����ڸ� ���� �Ҵ�
	public OrderServiceImpl(MemberRepository memberRepository, DiscountPolicy discountPolicy) {
		super();
		this.memberRepository = memberRepository;
		this.discountPolicy = discountPolicy;
	}

	//��� �������͸����� ȸ�� ã��
	//private final MemberRepository memberRepository = new MemoryMemberRepository();
	
	/*--------------- ����ü�� ���� [DIP, OCP ����]----------------------- */
	//���� ���αݾ� ã��
	//private final DiscountPolicy discountPolicy = new FixDiscountPolicy();
	
	// �������� (10%)
	//private final DiscountPolicy discountPolicy = new RateDiscountPolicy();

	
    /*------------------- �������̽�(�߻�ȭ)���� ����   --------------------------*/
	// => ����ü�� ��� nullpointException ��� 
	// final ������ ������ ���� �Ҵ��ؾ��ؼ� ���ش�. 
	//private DiscountPolicy discountPolicy;
	
	@Override
	public Order createOrder(Long memberId, String itemName, int itemPrice) {
		// TODO Auto-generated method stub
		// �ϴ� ����� ã��
		Member member = memberRepository.findById(memberId);
		// discountpolicy�� �ϴ� ��� �Ѱܼ� ���� �ݾ� �˾ƺ��� (������å�� �ϴ� ȸ���� �ѱ��) -> ���αݾ�, ������ ��ȯ�� ������Ʈ ��Ȳ������ �����ڰ� ����� ����
		int discountPrice = discountPolicy.discount(member, itemPrice);
		                    // null�� discountPolicy�� ���� �� nullpointException ���   		
		
		// �ֹ��� ���� ��ȯ
		return new Order(memberId, itemName, itemPrice, discountPrice);
	}

}
