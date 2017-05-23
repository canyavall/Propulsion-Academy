package demo;

import java.util.Map;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import config.HelloSpringConfig;
import hello.HelloSpringService;

public class HelloSpringDemo {

	public static void main(String[] args) {

		@SuppressWarnings("resource")
		ApplicationContext context = new AnnotationConfigApplicationContext(HelloSpringConfig.class);

		HelloSpringService helloSpringService1 = context.getBean(HelloSpringService.class);
		System.out.println(helloSpringService1.generateMessage());

		HelloSpringService helloSpringService2 = context.getBean("helloSpringService", HelloSpringService.class);
		// HelloSpringService helloSpringService2 = context.getBean("defaultHelloSpringService", HelloSpringService.class);
		System.out.println(helloSpringService2.generateMessage());

		HelloSpringService helloSpringService3 = context.getBean(HelloSpringService.class);

		System.out.println("1 == 3: " + (helloSpringService1 == helloSpringService3));
		System.out.println("1 == 2: " + (helloSpringService1 == helloSpringService3));

		//		String str = context.getBean("foo", String.class);
		//		System.out.println("String: " + str);

		Map<String, String> beansOfType = context.getBeansOfType(String.class);
		System.out.println(beansOfType);

	}

}