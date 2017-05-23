package service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import config.MessageServiceConfig;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes=MessageServiceConfig.class)
@ActiveProfiles("dev")
public class MessageServiceTests {
	
	@Autowired
	MessageService messageService;
	
	@Autowired
	HtmlMessageFormatter htmlMessageFormatter;
	
	@Autowired
	UpperCaseMessageFormatter upperCaseFormatter;

	@Test
	public void upperCaseMessageFormatter() {
		MessageService service = new MessageService(upperCaseFormatter);
		assertEquals("HELLO, WORLD", service.generateMessage());
	}

	@Test
	public void htmlFormatter() {
		//Don't use this way!!!!!!
		assertThat(htmlMessageFormatter.format("Hello, World")).isEqualTo("<strong>Hello, World</strong>");
	}

	@Test
	public void compositeFormatter() {		
		assertThat(messageService.generateMessage()).isEqualTo("<strong>HELLO, WORLD</strong>!");
	}

}