package hello.core.member;

public class MemberServiceImpl implements MemberService{

	// ������ �ϰ� ȸ�� ��ȸ�� �Ϸ��� ���� �ʿ�����? -> ��� �������͸� (ȸ�� �����)
	
	// �߻�ȭ�� ��üȭ �� �� ���� => DIP ����
	// MemberServiceImpl �� �������̽��� ����ü�� ��� ���� (DIP ��������)
	//���� ���̽��� ����                                                                          // ����ü�� ����
	private final MemberRepository memberRepository = new MemoryMemberRepository();
	
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
