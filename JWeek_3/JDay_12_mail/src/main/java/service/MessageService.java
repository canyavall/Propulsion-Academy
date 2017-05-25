package service;


import java.util.List;

import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

@Profile("dev")
@Service
public class MessageService {

	private final MessageFormatter formatter;
	private final JavaMailSender javaMailSender;

	public MessageService(MessageFormatter formatter, JavaMailSender javaMailSender) {
		this.formatter = formatter;
		this.javaMailSender = javaMailSender;
	}
	
	@Autowired
	public MessageService(List<MessageFormatter> messageFormatters, JavaMailSender javaMailSender){
		this(new CompositeMessageFormatter(messageFormatters), javaMailSender);
	}
	
	public String generateMessage() {
		String formatedMsg = formatter.format("Hello, World");
		sendNotificationEmail(formatedMsg);
		return formatedMsg;
	}
	
	public void sendNotificationEmail(String message) {
		MimeMessage mimeMessage = javaMailSender.createMimeMessage();
		MimeMessageHelper helper = new MimeMessageHelper(mimeMessage);
		try{
			helper.setFrom("canyavall@gmail.com");
			helper.setTo("canyavall@gmail.com");
			helper.setSubject("This is the message from Bootcamp");
			helper.setText(message);
			javaMailSender.send(mimeMessage);
		}catch(Exception e){
			e.printStackTrace(System.err);
		}

	}

}
