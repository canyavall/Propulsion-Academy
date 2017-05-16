package messTesting;

import static org.junit.Assert.assertEquals;

import org.junit.Test;


import mess.MessageFormatterFactory;

public class MessTest {

	@Test
	public void testMessagesFormat() {
		String out1 = MessageFormatterFactory.createConsoleFormatter().format("Macarena");
		assertEquals("Macarena!", out1);
	}
	
	@Test
	public void testMessagesHTML() {
		String out1 = MessageFormatterFactory.createHtmlFormatter().format("Macarena");
		assertEquals("<strong>Macarena</strong>", out1);
	}
}
