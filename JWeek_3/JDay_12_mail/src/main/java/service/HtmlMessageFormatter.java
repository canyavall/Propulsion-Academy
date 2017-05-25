package service;

import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Order(3)
public class HtmlMessageFormatter implements MessageFormatter {

	@Override
	public String format(String message) {
		return "<strong>" + message + "</strong>";
	}

}
