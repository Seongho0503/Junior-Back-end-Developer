package hello.core.member;

public interface MemberRepository {
	
	// 회원을 저장하는 기능
	void save(Member member);

	// 회원의 id를 찾는 기능
	Member findById(Long memberId);
}
