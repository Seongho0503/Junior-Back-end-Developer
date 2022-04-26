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
	@DisplayName("�� �̸����� ��ȸ")
	void findBeanByName() {
		
		MemberService memberService = ac.getBean("memberService", MemberService.class);
		System.out.println("memberService = " + memberService);
		System.out.println("memberService = " + memberService.getClass());
		// ��������� ��ü�� �������impl�̸� ���� 
		//Assertions.assertThat(memberService).isInstanceOf(MemberServiceImpl.class);
		assertThat(memberService).isInstanceOf(MemberServiceImpl.class);
	}
	
	
	@Test
	@DisplayName("�̸� ���� Ÿ�����θ� ��ȸ")
	void findBeanByType() {
		
		// ���� Ÿ���� ������ ���� �� ���
		MemberService memberService = ac.getBean(MemberService.class);
		//System.out.println("memberService = " + memberService);
		//System.out.println("memberService = " + memberService.getClass());
		// ��������� ��ü�� �������impl�̸� ���� 
		//Assertions.assertThat(memberService).isInstanceOf(MemberServiceImpl.class);
		assertThat(memberService).isInstanceOf(MemberServiceImpl.class);
	}
	// ���� �� �׽�Ʈ�� �������̽��� ��ȸ
	
	@Test
	@DisplayName("��ü Ÿ������ ��ȸ")
	void findBeanByName2() {
		
		MemberService memberService = ac.getBean("memberService", MemberServiceImpl.class);
		System.out.println("memberService = " + memberService);
		System.out.println("memberService = " + memberService.getClass());
		// ��������� ��ü�� �������impl�̸� ���� 
		//Assertions.assertThat(memberService).isInstanceOf(MemberServiceImpl.class);
		assertThat(memberService).isInstanceOf(MemberServiceImpl.class);
	}
	
	@Test
	@DisplayName("�� �̸����� ��ȸx")
	void findBeanByNameX() {
		//ac.getBean("xxxxx" , MemberService.class);
		
		MemberService xxxx = ac.getBean("xxxxx" , MemberService.class);
		
	}
}
