package service;

import static org.assertj.core.api.Assertions.assertThat;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import config.MessageServiceConfig;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes=MessageServiceConfig.class)
public class MessageServiceTests {
	
	@Autowired
	MessageService messageService;
	
	@Autowired
	HtmlMessageFormatter htmlMessageFormatter;
	
	@Autowired
	ConsoleMessageFormatter formatter;

	@Test
	public void consoleFormatter() {
//		MessageService service = new MessageService(formatter);
//		assertThat(service.generateMessage()).isEqualTo("Hello, World!");
	}

	@Test
	public void htmlFormatter() {
		//Don't use this way!!!!!!
		assertThat(htmlMessageFormatter.format("Hello, World")).isEqualTo("<strong>Hello, World</strong>");
	}

	@Test
	public void compositeFormatter() {		
		assertThat(messageService.generateMessage()).isEqualTo("<strong>HELLO, WORLD</strong>");
	}

}