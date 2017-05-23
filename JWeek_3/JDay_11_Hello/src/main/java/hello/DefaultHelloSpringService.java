package hello;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

//service component with default bean name: "defaultHelloSpringService"
// @Service
// service component with explicit bean name
@Service("helloSpringService")
public class DefaultHelloSpringService implements HelloSpringService {

	private final String message;

	//	@Autowired
	//	public DefaultHelloSpringService(@Qualifier("foo") String message) {
	//		this.message = message;
	//	}

	@Autowired
	public DefaultHelloSpringService(String bar) {
		this.message = bar;
	}

	@Autowired
	public void setMessages(List<String> messages) {
		System.out.println("String beans: " + messages);
	}

	@Override
	public String generateMessage() {
		return message;
	}

}