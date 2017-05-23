package service;

import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Order(2)
public class TrimmingMessageFormatter implements MessageFormatter {

	@Override
	public String format(String message) {
		return message.trim();
	}

}