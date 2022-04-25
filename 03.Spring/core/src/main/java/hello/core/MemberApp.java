package hello.core;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import hello.core.member.Grade;
import hello.core.member.Member;
import hello.core.member.MemberService;


public class MemberApp {

	// 서비스가 잘 되는지 테스트
	public static void main(String[] args) {
		
		ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
		// (메서드 이름, 반환타입)
		MemberService memberService = applicationContext.getBean("memberService", MemberService.class);
		
		//AppConfig appConfig = new AppConfig();
		//MemberService memberService = appConfig.memberService();
		
		// 이전 버전
		//MemberService memberService = new MemberServiceImpl();
		
		// id가 long 타입이여서 꼭 L 붙여줘야 한다. (회원가입 할 계정)
		Member member = new Member( 1L, "memberA", Grade.VIP);
		// 회원가입 
		memberService.join(member);
		// 회원찾기 (레포지터리에서 임시 저장된 계정, 회원가입된 계정)
		Member findMember = memberService.findMember(1L);
		
		System.out.println("new member =" + member.getName());
		System.out.println("findMember =" + findMember.getName());
		
	}
}
