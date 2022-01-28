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
 *
 * 关于Spring 容器管理Bean的过程以及加载模式：
 *
 * 1。 需要讲bean的定义信息生命在Spring的配置文件中
 * 2。 需要通过Spring抽象出来的各种Resource来制定对应的配置文件
 * 3。 需要显示声明一个Spring工厂，该工厂用来掌控我们在配置文件中所声明的各种bean以及bean之间的依赖关系
 * 4。 需要定义哥配置信息读取器，该读取器用来读取之前所定义的bean配置文件信息
 * 5。 读取器的作用是读取我们所声明的配置文件信息，并且将读取后的信息装配到之前所声明的工厂当中
 * 6。 需要讲读取器与工厂以及资源对象进行相应的关联处理
 * 7。 工厂所管理的全部对象装配完毕，可以供客户端进行调用，获取客户端想要使用的各种bean对象。
 *
 * Spring对于Bean管理的核心组件：
 *
 * 1。 资源抽象
 * 2。 工厂
 * 3。 配置信息读取器
 *
 * BeanFactory是Spring Bean工厂最顶层的抽象
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
