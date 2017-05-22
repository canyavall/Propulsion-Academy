package service;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import config.MessageServiceConfig;

public class MessageServiceTests {
	ApplicationContext context = new AnnotationConfigApplicationContext(MessageServiceConfig.class);

	@Test
	public void consoleFormatter() {
		ConsoleMessageFormatter formatter = new ConsoleMessageFormatter();
		MessageService service = new MessageService(formatter);
		assertThat(service.generateMessage()).isEqualTo("Hello, World!");
	}

	@Test
	public void htmlFormatter() {
		//Don't use this way!!!!!!
		assertThat(context.getBean("HtmlMsgForm", MessageFormatter.class).format("Hello, World")).isEqualTo("<strong>Hello, World</strong>");
	}

	@Test
	public void compositeFormatter() {		
		//MessageService service = context.getBean(MessageService.class);
		MessageService service = context.getBean("MsgService", MessageService.class);
		
		assertThat(service.generateMessage()).isEqualTo("<strong>HELLO, WORLD</strong>");
	}

}