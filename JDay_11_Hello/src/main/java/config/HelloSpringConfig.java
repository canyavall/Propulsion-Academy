package config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import hello.DefaultHelloSpringService;

@Configuration
public class HelloSpringConfig {

	@Bean // name = defaults to name of @Bean method.
	// @Bean(name = "myBean")
	// Default scope is "singleton"
	// @Scope("prototype")
	public DefaultHelloSpringService helloSpringService() {
		return new DefaultHelloSpringService();
	}

}