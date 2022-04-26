package hello.core.beanfind;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import hello.core.AppConfig;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;

public class ApplicationContextBasicFindTest {
	AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);

	@Test
	@DisplayName("빈 이름으로 조회")
	void findBeanByName() {
		
		MemberService memberService = ac.getBean("memberService", MemberService.class);
		System.out.println("memberService = " + memberService);
		System.out.println("memberService = " + memberService.getClass());
		// 멤버서비스의 객체가 멤버서비스impl이면 성공 
		//Assertions.assertThat(memberService).isInstanceOf(MemberServiceImpl.class);
		assertThat(memberService).isInstanceOf(MemberServiceImpl.class);
	}
	
	
	@Test
	@DisplayName("이름 없이 타입으로만 조회")
	void findBeanByType() {
		
		// 같은 타입이 여러개 있을 때 곤란
		MemberService memberService = ac.getBean(MemberService.class);
		//System.out.println("memberService = " + memberService);
		//System.out.println("memberService = " + memberService.getClass());
		// 멤버서비스의 객체가 멤버서비스impl이면 성공 
		//Assertions.assertThat(memberService).isInstanceOf(MemberServiceImpl.class);
		assertThat(memberService).isInstanceOf(MemberServiceImpl.class);
	}
	// 위의 두 테스트는 인터페이스로 조회
	
	@Test
	@DisplayName("구체 타입으로 조회")
	void findBeanByName2() {
		
		MemberService memberService = ac.getBean("memberService", MemberServiceImpl.class);
		System.out.println("memberService = " + memberService);
		System.out.println("memberService = " + memberService.getClass());
		// 멤버서비스의 객체가 멤버서비스impl이면 성공 
		//Assertions.assertThat(memberService).isInstanceOf(MemberServiceImpl.class);
		assertThat(memberService).isInstanceOf(MemberServiceImpl.class);
	}
	
	@Test
	@DisplayName("빈 이름으로 조회x")
	void findBeanByNameX() {
		//ac.getBean("xxxxx" , MemberService.class);
		
		MemberService xxxx = ac.getBean("xxxxx" , MemberService.class);
		
	}
}
