package service;

import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Order(1)
public class UpperCaseMessageFormatter implements MessageFormatter {

	@Override
	public String format(String message) {
		return message.toUpperCase();
	}

}