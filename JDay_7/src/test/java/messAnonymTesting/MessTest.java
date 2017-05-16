package messAnonymTesting;

import static org.junit.Assert.*;

import org.junit.Test;

import messAnonym.MessageFormatter;
import messAnonym.MessageFormatterFactory;

public class MessTest {

	@Test
	public void testMessagesFormat() {
		String out1 = MessageFormatterFactory.MSGCONSOLEFACTORY.format("Macarena");
		assertEquals("Macarena!", out1);
	}
	

	@Test
	public void testMessagesObject() {
		MessageFormatter out1 = MessageFormatterFactory.MSGCONSOLEFACTORY;
		MessageFormatter out2 = MessageFormatterFactory.MSGCONSOLEFACTORY;
		assertSame(out2, out1);
	}
}
