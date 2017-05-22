package service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MessageService {

	private final MessageFormatter formatter;

	public MessageService(MessageFormatter formatter) {
		this.formatter = formatter;
	}
	
	@Autowired
	public MessageService(List<MessageFormatter> messageFormatters){
		this(new CompositeMessageFormatter(messageFormatters));
	}
	
	public String generateMessage() {
		return formatter.format("Hello, World");
	}

}
