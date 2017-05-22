package service;

public class MessageService {

	private final MessageFormatter formatter;

	public MessageService(MessageFormatter formatter) {
		this.formatter = formatter;
	}

	public String generateMessage() {
		return formatter.format("Hello, World");
	}

}
