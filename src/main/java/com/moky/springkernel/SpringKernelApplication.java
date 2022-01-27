package com.moky.springkernel;


import com.moky.springkernel.bean.Student;
import org.springframework.beans.factory.support.BeanDefinitionReader;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

/**
 * IoC （Inverse of Control , 控制反转）
 * DI （Dependency Injection , 依赖注入）
 */
public class SpringKernelApplication {

	public static void main(String[] args) {
		Resource resource = new ClassPathResource("applicationContext.xml");

		DefaultListableBeanFactory defaultListableBeanFactory = new DefaultListableBeanFactory();

		BeanDefinitionReader beanDefinitionReader = new XmlBeanDefinitionReader(defaultListableBeanFactory);

		beanDefinitionReader.loadBeanDefinitions(resource);

		Student student = defaultListableBeanFactory.getBean("student", Student.class);
		System.out.println(student.getName());
		System.out.println(student.getAge());
	}
}
