package hello.core.member;

public class MemberServiceImpl implements MemberService{

	// 가입을 하고 회원 조회를 하려면 뭐가 필요하지? -> 멤버 레포지터리 (회원 저장소)
	
	// 추상화와 구체화 둘 다 의존 => DIP 위반
	// MemberServiceImpl 은 인터페이스와 구현체에 모두 의존 (DIP 의존관계)
	//인터 페이스에 의존                                                                          // 구현체에 의존
	//private final MemberRepository memberRepository = new MemoryMemberRepository();
	private final MemberRepository memberRepository;
	
	// 생성자를 만듦 -> 생성자를 통해서 MemBerReopository의 구현체를 정한다.
	public MemberServiceImpl(MemberRepository memberRepository) {
		this.memberRepository = memberRepository;
	}
	
	
	@Override
	public void join(Member member) {
		memberRepository.save(member);
		
	}


	@Override
	public Member findMember(Long memberid) {
		// TODO Auto-generated method stub
		return memberRepository.findById(memberid);
	}

}
