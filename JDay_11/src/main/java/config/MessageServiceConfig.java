package config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import service.MessageService;

@Configuration
public class MessageServiceConfig {

	@Bean
	public MessageService MessageService(){
		return null;
		
	}
	
	@Bean
	public MessageService TrimmingMessageFormatter(){
		return null;
		
	}
	
	@Bean
	public MessageService UpperCaseMessageFormatter(){
		return null;
		
	}
	
	@Bean
	public MessageService MarkdownMessageFormatter(){
		return null;
		
	}
	
	@Bean
	public MessageService HtmlMessageFormatter(){
		return null;
		
	}
}
