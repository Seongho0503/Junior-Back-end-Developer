package hello.core.member;

public interface MemberService {

	// ȸ������
	void join(Member member);
	
	// ȸ����ȸ
	Member findMember(Long memberId);
}
