package hello.core.beanfind;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import hello.core.AppConfig;

	class ApplicationContextInfoTest {
	
	AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);

	@Test
	@DisplayName("모든 빈 출력하기")
	void findAllBean( ) {
		//빈 등록된 이름을 가져옴
		String[] beanDefinitionNames = ac.getBeanDefinitionNames();
		for (String beanDefinitionName : beanDefinitionNames) {
			//타입을 지정 안했기 때문에 Object
			Object bean = ac.getBean(beanDefinitionName);
			System.out.println("key =" + beanDefinitionName + " value =" + bean);
		}
	}
	
	
	@Test
	@DisplayName("에플리케이션 빈 출력하기")
	void findApplicationBean( ) {
		//빈 등록된 이름을 가져옴
		String[] beanDefinitionNames = ac.getBeanDefinitionNames();
		for (String beanDefinitionName : beanDefinitionNames) {
			//타입을 지정 안했기 때문에 Object
			BeanDefinition beanDefinition = ac.getBeanDefinition(beanDefinitionName);
			
			//Role Role_INFRASTRUCTURE : 스프링이 내부에서 사용하는 빈
			//Role Role_APPLICATION : 직접 등록한 애플리케이션 빈
			//(스프링 자체에서 등록한 빈이 아니라)내가 자체적으로 등록한 애플리케이션 빈 
			if(beanDefinition.getRole() == BeanDefinition.ROLE_APPLICATION) {
				Object bean = ac.getBean(beanDefinitionName);
				System.out.println("key =" + beanDefinitionName + " value =" + bean);
			}	
		}
	}
	
	@Test
	@DisplayName("에플리케이션 빈 출력하기")
	void findSpringBean( ) {
		//빈 등록된 이름을 가져옴
		String[] beanDefinitionNames = ac.getBeanDefinitionNames();
		for (String beanDefinitionName : beanDefinitionNames) {
			//타입을 지정 안했기 때문에 Object
			BeanDefinition beanDefinition = ac.getBeanDefinition(beanDefinitionName);
			
			//Role Role_INFRASTRUCTURE : 스프링이 내부에서 사용하는 빈
			//Role Role_APPLICATION : 직접 등록한 애플리케이션 빈
			//(스프링 자체에서 등록한 빈이 아니라)내가 자체적으로 등록한 애플리케이션 빈 
			if(beanDefinition.getRole() == BeanDefinition.ROLE_INFRASTRUCTURE) {
				Object bean = ac.getBean(beanDefinitionName);
				System.out.println("key =" + beanDefinitionName + " value =" + bean);
			}	
		}
	}
	
	
}
