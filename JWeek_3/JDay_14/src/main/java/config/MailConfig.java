package config;

import org.springframework.context.annotation.Bean;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;

public class MailConfig {
	@Bean
	public JavaMailSender mailSender(){
		JavaMailSenderImpl javaMailSender = new JavaMailSenderImpl();
			javaMailSender.setHost("localhost");
			javaMailSender.setPort(25);
			return javaMailSender;
	}
}
