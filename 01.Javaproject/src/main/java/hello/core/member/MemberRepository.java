package hello.core.member;

public interface MemberRepository {
	
	// ȸ���� �����ϴ� ���
	void save(Member member);

	// ȸ���� id�� ã�� ���
	Member findById(Long memberId);
}
