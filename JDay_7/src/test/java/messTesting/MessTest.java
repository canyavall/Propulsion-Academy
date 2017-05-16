package messTesting;

import static org.junit.Assert.*;

import org.junit.Test;

import mess.MessageFormatter;
import mess.MessageFormatterFactory;

public class MessTest {

	@Test
	public void testMessagesFormat() {
		String out1 = MessageFormatterFactory.MSGCONSOLEFACTORY.format("Macarena");
		assertEquals("Macarena!", out1);
	}
	
	@Test
	public void testMessagesHTML() {
		String out1 = MessageFormatterFactory.createHtmlFormatter().format("Macarena");
		assertEquals("<strong>Macarena</strong>", out1);
	}
	
	@Test
	public void testMessagesObject() {
		MessageFormatter out1 = MessageFormatterFactory.MSGCONSOLEFACTORY;
		MessageFormatter out2 = MessageFormatterFactory.MSGCONSOLEFACTORY;
		assertSame(out2, out1);
	}
}
