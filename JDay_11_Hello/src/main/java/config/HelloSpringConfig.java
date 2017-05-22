package config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;

@Configuration
@ComponentScan("hello")
public class HelloSpringConfig {

	// Replaced by component scanning
	//
	//	@Bean // name = defaults to name of @Bean method.
	//	// @Bean(name = "myBean")
	//	// Default scope is "singleton"
	//	// @Scope("prototype")
	//	public DefaultHelloSpringService helloSpringService() {
	//		return new DefaultHelloSpringService();
	//	}

	@Bean // ("message")
	@Order(2)
	public String message() {
		return "foo";
	}

	@Bean
	@Order(1)
	public String bar() {
		return "bar";
	}

}