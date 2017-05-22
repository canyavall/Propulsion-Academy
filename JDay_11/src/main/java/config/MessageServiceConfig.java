package config;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import service.CompositeMessageFormatter;
import service.HtmlMessageFormatter;
import service.MessageFormatter;
import service.MessageService;
import service.TrimmingMessageFormatter;
import service.UpperCaseMessageFormatter;

@Configuration
public class MessageServiceConfig {

	@Bean(name = "MsgService")
	public MessageService MsgService(){
		List<MessageFormatter> formatters = new ArrayList<MessageFormatter>();
		formatters.add(TrimMsgForm());
		formatters.add(UpperCaseMsgForm());
		formatters.add(HtmlMsgForm());
		return new MessageService(new CompositeMessageFormatter(formatters));
		
	}
	
	@Bean
	public MessageFormatter TrimMsgForm(){
		return new TrimmingMessageFormatter();
		
	}
	
	@Bean
	public MessageFormatter UpperCaseMsgForm(){
		return new UpperCaseMessageFormatter();
		
	}
	
	@Bean
	public MessageFormatter HtmlMsgForm(){
		return new HtmlMessageFormatter();
		
	}
}
