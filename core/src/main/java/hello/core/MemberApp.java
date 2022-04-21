package hello.core;

import hello.core.member.Grade;
import hello.core.member.Member;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;


public class MemberApp {

	// ���񽺰� �� �Ǵ��� �׽�Ʈ
	public static void main(String[] args) {
		MemberService memberService = new MemberServiceImpl();
		// id�� long Ÿ���̿��� �� L �ٿ���� �Ѵ�. (ȸ������ �� ����)
		Member member = new Member( 1L, "memberA", Grade.VIP);
		// ȸ������ 
		memberService.join(member);
		// ȸ��ã�� (�������͸����� �ӽ� ����� ����, ȸ�����Ե� ����)
		Member findMember = memberService.findMember(1L);
		
		System.out.println("new member =" + member.getName());
		System.out.println("findMember =" + findMember.getName());
		
	}
}
