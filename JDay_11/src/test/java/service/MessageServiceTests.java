package service;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;

public class MessageServiceTests {

	@Test
	public void consoleFormatter() {
		ConsoleMessageFormatter formatter = new ConsoleMessageFormatter();

		MessageService service = new MessageService(formatter);

		assertThat(service.generateMessage()).isEqualTo("Hello, World!");
	}

	@Test
	public void htmlFormatter() {
		MessageService service = new MessageService(new HtmlMessageFormatter());

		assertThat(service.generateMessage()).isEqualTo("<strong>Hello, World</strong>");
	}

	@Test
	public void markdownFormatter() {
		MessageFormatter formatter = new MarkdownMessageFormatter();

		MessageService service = new MessageService(formatter);

		assertThat(service.generateMessage()).isEqualTo("**Hello, World**");
	}

	@Test
	public void compositeFormatter() {
		// @formatter:off
		List<MessageFormatter> formatters = Arrays.asList(
			new TrimmingMessageFormatter(),
			new UpperCaseMessageFormatter(),
			new HtmlMessageFormatter()
		);
		// @formatter:on

		MessageFormatter formatter = new CompositeMessageFormatter(formatters);

		MessageService service = new MessageService(formatter);

		assertThat(service.generateMessage()).isEqualTo("<strong>HELLO, WORLD</strong>");
	}

}