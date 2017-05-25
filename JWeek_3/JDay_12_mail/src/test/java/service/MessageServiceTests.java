package service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.subethamail.wiser.Wiser;

import config.MessageServiceConfig;
import config.TestMailConfig;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes= {MessageServiceConfig.class, TestMailConfig.class })
@ActiveProfiles("dev")
public class MessageServiceTests {
	
	@Autowired
	MessageService messageService;
	
	@Autowired
	HtmlMessageFormatter htmlMessageFormatter;
	
	@Autowired
	UpperCaseMessageFormatter upperCaseFormatter;
	
	@Autowired
	JavaMailSender javaMailSender;
	
	@Autowired
	Wiser wiser;
	
	@Before
	public void deleteMessages(){
		wiser.getMessages().clear();
	}

	@Test
	public void upperCaseMessageFormatter() {
		MessageService service = new MessageService(upperCaseFormatter, javaMailSender);
		assertEquals("HELLO, WORLD", service.generateMessage());
		assertThat(wiser.getMessages()).hasSize(1);
	}

	@Test
	public void htmlFormatter() {
		//Don't use this way!!!!!!
		assertThat(htmlMessageFormatter.format("Hello, World")).isEqualTo("<strong>Hello, World</strong>");
	}

	@Test
	public void compositeFormatter() {		
		assertThat(messageService.generateMessage()).isEqualTo("<strong>HELLO, WORLD</strong>");
		assertThat(wiser.getMessages()).hasSize(1);
	}

}