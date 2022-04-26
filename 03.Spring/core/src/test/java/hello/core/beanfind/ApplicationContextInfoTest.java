package hello.core.beanfind;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import hello.core.AppConfig;

	class ApplicationContextInfoTest {
	
	AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);

	@Test
	@DisplayName("��� �� ����ϱ�")
	void findAllBean( ) {
		//�� ��ϵ� �̸��� ������
		String[] beanDefinitionNames = ac.getBeanDefinitionNames();
		for (String beanDefinitionName : beanDefinitionNames) {
			//Ÿ���� ���� ���߱� ������ Object
			Object bean = ac.getBean(beanDefinitionName);
			System.out.println("key =" + beanDefinitionName + " value =" + bean);
		}
	}
	
	
	@Test
	@DisplayName("���ø����̼� �� ����ϱ�")
	void findApplicationBean( ) {
		//�� ��ϵ� �̸��� ������
		String[] beanDefinitionNames = ac.getBeanDefinitionNames();
		for (String beanDefinitionName : beanDefinitionNames) {
			//Ÿ���� ���� ���߱� ������ Object
			BeanDefinition beanDefinition = ac.getBeanDefinition(beanDefinitionName);
			
			//Role Role_INFRASTRUCTURE : �������� ���ο��� ����ϴ� ��
			//Role Role_APPLICATION : ���� ����� ���ø����̼� ��
			//(������ ��ü���� ����� ���� �ƴ϶�)���� ��ü������ ����� ���ø����̼� �� 
			if(beanDefinition.getRole() == BeanDefinition.ROLE_APPLICATION) {
				Object bean = ac.getBean(beanDefinitionName);
				System.out.println("key =" + beanDefinitionName + " value =" + bean);
			}	
		}
	}
	
	@Test
	@DisplayName("���ø����̼� �� ����ϱ�")
	void findSpringBean( ) {
		//�� ��ϵ� �̸��� ������
		String[] beanDefinitionNames = ac.getBeanDefinitionNames();
		for (String beanDefinitionName : beanDefinitionNames) {
			//Ÿ���� ���� ���߱� ������ Object
			BeanDefinition beanDefinition = ac.getBeanDefinition(beanDefinitionName);
			
			//Role Role_INFRASTRUCTURE : �������� ���ο��� ����ϴ� ��
			//Role Role_APPLICATION : ���� ����� ���ø����̼� ��
			//(������ ��ü���� ����� ���� �ƴ϶�)���� ��ü������ ����� ���ø����̼� �� 
			if(beanDefinition.getRole() == BeanDefinition.ROLE_INFRASTRUCTURE) {
				Object bean = ac.getBean(beanDefinitionName);
				System.out.println("key =" + beanDefinitionName + " value =" + bean);
			}	
		}
	}
	
	
}
