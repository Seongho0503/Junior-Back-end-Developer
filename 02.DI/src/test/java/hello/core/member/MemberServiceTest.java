package hello.core.member;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import hello.core.AppConfig;

public class MemberServiceTest {
	
	MemberService memberService;
	//MemberService memberService = new MemberServiceImpl();
	
	// 테스트 전 실행
	@BeforeEach
	public void beforeEach() {
		AppConfig appConfig = new AppConfig();
		memberService = appConfig.memberService();
	}
	
	@Test
	void join() {
		
		//given (조건)
		Member member = new Member(1L, "memberA", Grade.VIP);
		
		//when
		memberService.join(member);
		Member findMember = memberService.findMember(1L);
		
		//then (검증)
		Assertions.assertThat(member).isEqualTo(findMember);
		
		
	}

}
